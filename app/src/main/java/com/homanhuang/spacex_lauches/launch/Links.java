package com.homanhuang.spacex_lauches.launch;

import com.google.gson.annotations.SerializedName;

import java.net.URL;

/**
 * Created by Homan on 3/1/2018.
 */

public class Links {
    
    @SerializedName("mission_patch")
    URL mission_patch;
    @SerializedName("reddit_campaign")
    URL reddit_campaign;
    @SerializedName("reddit_launch")
    URL reddit_launch;
    @SerializedName("reddit_recovery")
    URL reddit_recovery;
    @SerializedName("reddit_media")
    URL reddit_media;
    @SerializedName("presskit")
    URL presskit;
    @SerializedName("article_link")
    URL article_link;
    @SerializedName("video_link")
    URL video_link;

    public URL getMission_patch() {
        return mission_patch;
    }

    public void setMission_patch(URL mission_patch) {
        this.mission_patch = mission_patch;
    }

    public URL getReddit_campaign() {
        return reddit_campaign;
    }

    public void setReddit_campaign(URL reddit_campaign) {
        this.reddit_campaign = reddit_campaign;
    }

    public URL getReddit_launch() {
        return reddit_launch;
    }

    public void setReddit_launch(URL reddit_launch) {
        this.reddit_launch = reddit_launch;
    }

    public URL getReddit_recovery() {
        return reddit_recovery;
    }

    public void setReddit_recovery(URL reddit_recovery) {
        this.reddit_recovery = reddit_recovery;
    }

    public URL getReddit_media() {
        return reddit_media;
    }

    public void setReddit_media(URL reddit_media) {
        this.reddit_media = reddit_media;
    }

    public URL getPresskit() {
        return presskit;
    }

    public void setPresskit(URL presskit) {
        this.presskit = presskit;
    }

    public URL getArticle_link() {
        return article_link;
    }

    public void setArticle_link(URL article_link) {
        this.article_link = article_link;
    }

    public URL getVideo_link() {
        return video_link;
    }

    public void setVideo_link(URL video_link) {
        this.video_link = video_link;
    }

    @Override
    public String toString() {
        return "Links{" +
                "\nmission_patch=" + mission_patch +
                ", \nreddit_campaign=" + reddit_campaign +
                ", \nreddit_launch=" + reddit_launch +
                ", \nreddit_recovery=" + reddit_recovery +
                ", \nreddit_media=" + reddit_media +
                ", \npresskit=" + presskit +
                ", \narticle_link=" + article_link +
                ", \nvideo_link=" + video_link +
                '}';
    }
}
