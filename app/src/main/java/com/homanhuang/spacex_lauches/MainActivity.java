package com.homanhuang.spacex_lauches;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.homanhuang.spacex_lauches.launch.Launch;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    /* Log tag and shortcut */
    final static String TAG = "MYLOG SPACEX";
    public static void ltag(String message) { Log.i(TAG, message); }

    /* Toast shortcut */
    public static void msg(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    //=====================================================================
    /*
        Interpret the Website
     */
    public static final String BASE_URL = "https://api.spacexdata.com";

    // Add the interceptor to OkHttpClient
    OkHttpClient.Builder mClient = new OkHttpClient.Builder()
        .addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request()
                        .newBuilder()
                        .addHeader("User-Visitor", "SpaceX-News-App").build();
                ltag("new request: "+newRequest.toString());
                return chain.proceed(newRequest);
            }
        });

    OkHttpClient client = mClient.build();

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            .create();

    Retrofit visitor = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    SpaceXApiInterface service;
    //=====================================================================

    // Request Results
    List<Launch> SpaceXResults;
    List<Launch> upComing;
    /*
        Upcoming Request
     */
    private void upcomingLaunch() {
        final Call<List<Launch>> upcoming = service.getUpComing();
        upcoming.enqueue(new Callback<List<Launch>>() {
            @Override
            public void onResponse(Call<List<Launch>> call, Response<List<Launch>> response) {
                if ( response.isSuccessful() ) {

                    // request successful (status code 200, 201)
                    SpaceXResults = response.body();
                    //backup
                    upComing = SpaceXResults;
                    ltag("Result Size: "+SpaceXResults.size());

                    for (Launch launch : SpaceXResults) {
                        ltag("Flight #: "+launch.getFlight_number());
                    }

                    upcomingTV.setText(SpaceXResults.size() + " Events Found!");

                    //Add recycler view
                    launchRecyclerAdapter = new LaunchRecyclerAdapter(MainActivity.this, SpaceXResults);
                    LinearLayoutManager horizontalLayoutManagaer
                            = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                    launchRecyclerView.setLayoutManager(horizontalLayoutManagaer);
                    launchRecyclerView.setAdapter(launchRecyclerAdapter);
                    SnapHelper snapHelper = new LinearSnapHelper();
                    snapHelper.attachToRecyclerView(launchRecyclerView);

                } else {
                    //request not successful (like 400,401,403 etc)
                    //Handle errors
                    ltag("Http Error: "+response.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Launch>> call, Throwable t) {
                ltag("Fail: "+t.toString());
            }
        });
    }

    /*
       Filter Request
    */
    private void filterLaunch(Map data) {
        final Call<List<Launch>> filterLaunch = service.getTimeLaunches(data);
        filterLaunch.enqueue(new Callback<List<Launch>>() {
            @Override
            public void onResponse(Call<List<Launch>> call, Response<List<Launch>> response) {
                if ( response.isSuccessful() ) {

                    // request successful (status code 200, 201)
                    SpaceXResults = response.body();
                    ltag("Result Size: "+SpaceXResults.size());

                    for (Launch launch : SpaceXResults) {
                        ltag("Flight #: "+launch.getFlight_number());
                    }

                    upcomingTV.setText(SpaceXResults.size() + " Events Found!");

                    //Add recycler view
                    launchRecyclerAdapter = new LaunchRecyclerAdapter(MainActivity.this, SpaceXResults);
                    LinearLayoutManager horizontalLayoutManagaer
                            = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
                    launchRecyclerView.setLayoutManager(horizontalLayoutManagaer);
                    launchRecyclerView.setAdapter(launchRecyclerAdapter);

                } else {
                    //request not successful (like 400,401,403 etc)
                    //Handle errors
                    ltag("Http Error: "+response.toString());
                }
            }

            @Override
            public void onFailure(Call<List<Launch>> call, Throwable t) {
                ltag("Fail: "+t.toString());
            }
        });
    }
    //=====================================================================
    /*
        Restore Up Coming
     */
    public void restoreUpcoming(View v) {
        upcomingTV.setText(upComing.size() + " Events Found!");

        //Add recycler view
        launchRecyclerAdapter = new LaunchRecyclerAdapter(MainActivity.this, upComing);
        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        launchRecyclerView.setLayoutManager(horizontalLayoutManagaer);
        launchRecyclerView.setAdapter(launchRecyclerAdapter);
    }

    //=====================================================================
    /*
        Search Function: Show Search Box
     */
    boolean searchBoxOn = false;
    public void showSearch(View v) {
        if (!searchBoxOn) {
            ltag("search box: "+searchBoxOn);
            launchRecyclerView.setVisibility(View.INVISIBLE);
            searchCLayout.setVisibility(View.VISIBLE);
            searchBoxOn = true;
        } else {
            ltag("search box: "+searchBoxOn);
            launchRecyclerView.setVisibility(View.VISIBLE);
            searchCLayout.setVisibility(View.INVISIBLE);
            searchBoxOn =false;
        }
    }

    //=====================================================================
    /*
        Search Function: Setup a Year picker to show year only
     */
    public void setupYearPicker() {
        // Initialize Date Picker
        int year    = yearPicker.getYear();
        int month   = yearPicker.getMonth();
        int day     = yearPicker.getDayOfMonth();
        yearPicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            }
        });


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int daySpinnerId = Resources.getSystem().getIdentifier("day", "id", "android");
            if (daySpinnerId != 0) {
                View daySpinner = yearPicker.findViewById(daySpinnerId);
                if (daySpinner != null) {
                    daySpinner.setVisibility(View.GONE);
                }
            }

            int monthSpinnerId = Resources.getSystem().getIdentifier("month", "id", "android");
            if (monthSpinnerId != 0) {
                View monthSpinner = yearPicker.findViewById(monthSpinnerId);
                if (monthSpinner != null) {
                    monthSpinner.setVisibility(View.GONE);
                }
            }

            int yearSpinnerId = Resources.getSystem().getIdentifier("year", "id", "android");
            if (yearSpinnerId != 0) {
                View yearSpinner = yearPicker.findViewById(yearSpinnerId);
                if (yearSpinner != null) {
                    yearSpinner.setVisibility(View.VISIBLE);
                }
            }
        } else { //Older SDK versions
            Field f[] = yearPicker.getClass().getDeclaredFields();
            for (Field field : f)
            {
                if(field.getName().equals("mDayPicker") || field.getName().equals("mDaySpinner"))
                {
                    field.setAccessible(true);
                    Object dayPicker = null;
                    try {
                        dayPicker = field.get(yearPicker);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    ((View) dayPicker).setVisibility(View.GONE);
                }

                if(field.getName().equals("mMonthPicker") || field.getName().equals("mMonthSpinner"))
                {
                    field.setAccessible(true);
                    Object monthPicker = null;
                    try {
                        monthPicker = field.get(yearPicker);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    ((View) monthPicker).setVisibility(View.GONE);
                }

                if(field.getName().equals("mYearPicker") || field.getName().equals("mYearSpinner"))
                {
                    field.setAccessible(true);
                    Object yearPicker = null;
                    try {
                        yearPicker = field.get(yearPicker);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    ((View) yearPicker).setVisibility(View.VISIBLE);
                }
            }
        }
    }

    //=====================================================================
    /*
        Search Function: Get the date from DatePicker
     */
    public String getCurrentDate(DatePicker picker, boolean yearOnly){
        StringBuilder builder=new StringBuilder();
        builder.append(picker.getYear());//month is 0 based
        if (!yearOnly) {
            builder.append("-"+ String.format("%02d", picker.getMonth() + 1) + "-");
            builder.append(String.format("%02d", picker.getDayOfMonth()));
        }
        return builder.toString();
    }

    //=====================================================================
    /*
        Search Function: OnClick for SearchRangeButton
     */
    public void searchDateRange(View v) throws ParseException {
        launchRecyclerView.setVisibility(View.VISIBLE);
        searchCLayout.setVisibility(View.INVISIBLE);
        searchBoxOn =false;

        String startDate = getCurrentDate(startDatePicker, false);
        String finalDate = getCurrentDate(finalDatePicker, false);

        Map<String, String> data = new HashMap<>();

        //compare the dates to decide the oldest
        if (startDate.compareTo(finalDate) <= 0) {
            data.put("start", startDate);
            data.put("final", finalDate);
        } else {
            data.put("start", finalDate);
            data.put("final", startDate);
        }
        filterLaunch(data);
    }

    //=====================================================================
    /*
        Search Function: OnClick for SearchYearButton
     */
    public void searchYear(View v) {
        launchRecyclerView.setVisibility(View.VISIBLE);
        searchCLayout.setVisibility(View.INVISIBLE);
        searchBoxOn =false;

        Map<String, String> data = new HashMap<>();
        data.put("launch_year", getCurrentDate(yearPicker, true));
        filterLaunch(data);
    }

    //=====================================================================
    /*
        Layout Variables
     */
    TextView upcomingTV;
    TextView searchTV;
    RecyclerView launchRecyclerView;
    LaunchRecyclerAdapter launchRecyclerAdapter;
    ConstraintLayout searchCLayout;
    DatePicker startDatePicker;
    DatePicker finalDatePicker;
    DatePicker yearPicker;
    Button searchRangeButton;
    Button searchYearButton;
    //=====================================================================
    /*
        OnCreate
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
            BSON -> JAVA
         */
        service = visitor.create(SpaceXApiInterface.class);
        //call upcoming result
        upcomingLaunch();
        /*
            END PARSING
         */

        upcomingTV = (TextView) findViewById(R.id.upcomingTV);
        searchTV = (TextView) findViewById(R.id.searchTV);
        launchRecyclerView = (RecyclerView) findViewById(R.id.launch_recycler_view);
        searchCLayout = (ConstraintLayout) findViewById(R.id.searchCLayout);

        searchRangeButton = (Button) findViewById(R.id.searchRangeButton);
        searchYearButton = (Button) findViewById(R.id.searchYearButton);

        //for search box
        Calendar calendar = Calendar.getInstance();
        startDatePicker = (DatePicker) findViewById(R.id.startDatePicker);
        startDatePicker.setMaxDate(calendar.getTimeInMillis());
        finalDatePicker = (DatePicker) findViewById(R.id.finalDatePicker);
        finalDatePicker.setMaxDate(calendar.getTimeInMillis());
        yearPicker = (DatePicker) findViewById(R.id.yearPicker);
        yearPicker.setMaxDate(calendar.getTimeInMillis());
        setupYearPicker();

        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

}
