
package com.soethiha.unsplashpic.data.vos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentUserCollectionVO {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("published_at")
    @Expose
    private String publishedAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("curated")
    @Expose
    private boolean curated;

    @SerializedName("cover_photo")
    @Expose
    private CoverPhotoVO coverPhoto;

    @SerializedName("user")
    @Expose
    private UserVO user;

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

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isCurated() {
        return curated;
    }

    public void setCurated(boolean curated) {
        this.curated = curated;
    }

    public CoverPhotoVO getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(CoverPhotoVO coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public LinksVO getLinks() {
        return links;
    }

    public void setLinks(LinksVO links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "CurrentUserCollectionVO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", curated=" + curated +
                ", coverPhoto=" + coverPhoto +
                ", user=" + user +
                ", links=" + links +
                '}';
    }
}
