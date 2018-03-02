package com.homanhuang.spacex_lauches;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.homanhuang.spacex_lauches.launch.Launch;

import java.net.URL;
import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by Homan on 3/1/2018.
 */

public class LaunchRecyclerAdapter extends RecyclerView.Adapter<LaunchRecyclerAdapter.MyViewHolder> {

    private List<Launch> launchList;
    private Context mContext;

    /* Log tag and shortcut */
    final static String TAG = "MYLOG Recycler";
    public static void ltag(String message) { Log.i(TAG, message); }

    public LaunchRecyclerAdapter(Context context, List<Launch> horizontalList) {
        this.launchList = horizontalList;
        this.mContext = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //layout variables
        TextView titleTV;
        TextView dateTV;
        TextView siteTV;
        TextView payloadsTV;
        FrameLayout missionFLayout;
        FrameLayout campaignFLayout;
        FrameLayout launchFLayout;
        FrameLayout recoveryFLayout;
        FrameLayout mediaFLayout;
        FrameLayout pressFLayout;
        FrameLayout articleFLayout;
        FrameLayout videoFLayout;
        FloatingActionButton missionFButton;
        FloatingActionButton campaignFButton;
        FloatingActionButton launchFButton;
        FloatingActionButton recoveryFButton;
        FloatingActionButton mediaFButton;
        FloatingActionButton pressFButton;
        FloatingActionButton articleFButton;
        FloatingActionButton videoFButton;


        public MyViewHolder(View view) {
            super(view);
            titleTV = (TextView) view.findViewById(R.id.titleTV);
            dateTV = (TextView) view.findViewById(R.id.dateTV);
            siteTV = (TextView) view.findViewById(R.id.siteTV);
            payloadsTV = (TextView) view.findViewById(R.id.payloadsTV);

            missionFLayout = (FrameLayout) view.findViewById(R.id.missionFLayout);
            campaignFLayout = (FrameLayout) view.findViewById(R.id.campaignFLayout);
            launchFLayout = (FrameLayout) view.findViewById(R.id.launchFLayout);
            recoveryFLayout = (FrameLayout) view.findViewById(R.id.recoveryFLayout);
            mediaFLayout = (FrameLayout) view.findViewById(R.id.mediaFLayout);
            pressFLayout = (FrameLayout) view.findViewById(R.id.pressFLayout);
            articleFLayout = (FrameLayout) view.findViewById(R.id.articleFLayout);
            videoFLayout = (FrameLayout) view.findViewById(R.id.videoFLayout);

            missionFButton = (FloatingActionButton) view.findViewById(R.id.missionFButton);
            campaignFButton = (FloatingActionButton) view.findViewById(R.id.camaignFButton);
            launchFButton = (FloatingActionButton) view.findViewById(R.id.launchFButton);
            recoveryFButton = (FloatingActionButton) view.findViewById(R.id.recoveryFButton);
            mediaFButton = (FloatingActionButton) view.findViewById(R.id.mediaFButton);
            articleFButton = (FloatingActionButton) view.findViewById(R.id.articleFButton);
            pressFButton = (FloatingActionButton) view.findViewById(R.id.pressFButton);
            videoFButton = (FloatingActionButton) view.findViewById(R.id.videoFButton);

        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //import the layout
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.launch_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Launch mLaunch = launchList.get(position);

        //get flight
        holder.titleTV.setText("... Flight #"+mLaunch.getFlight_number()+"...");

        //get time
        String dateTime = mLaunch.getLaunch_date_local();
        if (dateTime == null) {
            holder.dateTV.setText("To Be Determined!");
        } else {
            String[] parts = dateTime.split("T");
            String date = parts[0];
            String time = parts[1];
            holder.dateTV.setText(date + ", " + time);
        }

        //get launch site
        String site = mLaunch.getLaunchSite().getSite_name_long();
        holder.siteTV.setText(site);

        //get payloads
        String pType = mLaunch
                .getRocket()
                .getSecond_stage()
                .getPayloadsList().get(0)
                .getPayload_type();
        String customer = mLaunch
                .getRocket()
                .getSecond_stage()
                .getPayloadsList().get(0)
                .getCustomersToString();
        holder.payloadsTV.setText(pType + " by " + customer);

        //get 8 links
        //get mission url
        final URL mimissionUrl = mLaunch.getLinks().getMission_patch();
        if (mimissionUrl == null) {
            //hide
            holder.missionFLayout.setVisibility(View.INVISIBLE);
        } else {
            holder.missionFButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ltag("mission: "+mimissionUrl.toString());
                    toBrowser(mimissionUrl.toString());
                }
            });
        }

        //get campaign url
        final URL campaignUrl = mLaunch.getLinks().getReddit_campaign();
        if (campaignUrl == null) {
            //hide
            holder.campaignFLayout.setVisibility(View.INVISIBLE);
        } else {
            holder.campaignFButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ltag("campaign: "+campaignUrl.toString());
                    toBrowser(campaignUrl.toString());
                }
            });
        }

        //get launch url
        final URL launchUrl = mLaunch.getLinks().getReddit_launch();
        if (launchUrl == null) {
            //hide
            holder.launchFLayout.setVisibility(View.INVISIBLE);
        } else {
            holder.launchFButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ltag("launch: "+launchUrl.toString());
                    toBrowser(launchUrl.toString());
                }
            });
        }

        //get recovery url
        final URL recoveryUrl = mLaunch.getLinks().getReddit_recovery();
        if (recoveryUrl == null) {
            //hide
            holder.recoveryFLayout.setVisibility(View.INVISIBLE);
        } else {
            holder.recoveryFButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ltag("recovery: "+recoveryUrl.toString());
                    toBrowser(recoveryUrl.toString());
                }
            });
        }

        //get media url
        final URL mediaUrl = mLaunch.getLinks().getReddit_media();
        if (mediaUrl == null) {
            //hide
            holder.mediaFLayout.setVisibility(View.INVISIBLE);
        } else {
            holder.mediaFButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ltag("media: "+mediaUrl.toString());
                    toBrowser(mediaUrl.toString());
                }
            });
        }

        //get press url
        final URL pressUrl = mLaunch.getLinks().getPresskit();
        if (pressUrl == null) {
            //hide
            holder.pressFLayout.setVisibility(View.INVISIBLE);
        } else {
            holder.pressFButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ltag("press: "+pressUrl.toString());
                    toBrowser(pressUrl.toString());
                }
            });
        }

        //get article url
        final URL articleUrl = mLaunch.getLinks().getArticle_link();
        if (articleUrl == null) {
            //hide
            holder.articleFLayout.setVisibility(View.INVISIBLE);
        } else {
            holder.articleFButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ltag("article: "+articleUrl.toString());
                    toBrowser(articleUrl.toString());
                }
            });
        }

        //get video url
        final URL videoUrl = mLaunch.getLinks().getVideo_link();
        if (videoUrl == null) {
            //hide
            holder.videoFLayout.setVisibility(View.INVISIBLE);
        } else {
            holder.videoFButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ltag("video: "+videoUrl.toString());
                    toBrowser(videoUrl.toString());
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return launchList.size();
    }

    public void toBrowser(String link) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        mContext.startActivity(browserIntent);
    }
}