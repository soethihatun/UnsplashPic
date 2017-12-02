
package com.soethiha.unsplashpic.data.vos; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links____ {

    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("html")
    @Expose
    private String html;
    @SerializedName("photos")
    @Expose
    private String photos;
    @SerializedName("likes")
    @Expose
    private String likes;
    @SerializedName("portfolio")
    @Expose
    private String portfolio;

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return "Links____{" +
                "self='" + self + '\'' +
                ", html='" + html + '\'' +
                ", photos='" + photos + '\'' +
                ", likes='" + likes + '\'' +
                ", portfolio='" + portfolio + '\'' +
                '}';
    }
}
