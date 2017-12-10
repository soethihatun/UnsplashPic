
package com.soethiha.unsplashpic.data.vos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * UnsplashPic
 *
 * @author SoeThihaTun
 * @version 1.0
 * @since 03/12/2017
 */
public class CategoryVO {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("photo_count")
    @Expose
    private int photoCount;

    @SerializedName("links")
    @Expose
    private LinksVO links;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(int photoCount) {
        this.photoCount = photoCount;
    }

    public LinksVO getLinks() {
        return links;
    }

    public void setLinks(LinksVO links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "CategoryVO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", photoCount=" + photoCount +
                ", links=" + links +
                '}';
    }
}
