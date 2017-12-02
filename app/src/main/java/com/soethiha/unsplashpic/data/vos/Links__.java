
package com.soethiha.unsplashpic.data.vos; ;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links__ {

    @SerializedName("self")
    @Expose
    private String self;
    @SerializedName("photos")
    @Expose
    private String photos;

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "Links__{" +
                "self='" + self + '\'' +
                ", photos='" + photos + '\'' +
                '}';
    }
}
