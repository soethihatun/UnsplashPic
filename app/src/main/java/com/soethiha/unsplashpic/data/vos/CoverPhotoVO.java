
package com.soethiha.unsplashpic.data.vos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * UnsplashPic
 *
 * @author SoeThihaTun
 * @version 1.0
 * @since 03/12/2017
 */
public class CoverPhotoVO {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("width")
    @Expose
    private int width;

    @SerializedName("height")
    @Expose
    private int height;

    @SerializedName("color")
    @Expose
    private String color;

    @SerializedName("likes")
    @Expose
    private int likes;

    @SerializedName("liked_by_user")
    @Expose
    private boolean likedByUser;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("user")
    @Expose
    private UserVO user;

    @SerializedName("urls")
    @Expose
    private UrlsVO urls;

    @SerializedName("categories")
    @Expose
    private List<CategoryVO> categories = null;

    @SerializedName("links")
    @Expose
    private LinksVO links;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isLikedByUser() {
        return likedByUser;
    }

    public void setLikedByUser(boolean likedByUser) {
        this.likedByUser = likedByUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserVO getUser() {
        return user;
    }

    public void setUser(UserVO user) {
        this.user = user;
    }

    public UrlsVO getUrls() {
        return urls;
    }

    public void setUrls(UrlsVO urls) {
        this.urls = urls;
    }

    public List<CategoryVO> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryVO> categories) {
        this.categories = categories;
    }

    public LinksVO getLinks() {
        return links;
    }

    public void setLinks(LinksVO links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "CoverPhotoVO{" +
                "id='" + id + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", color='" + color + '\'' +
                ", likes=" + likes +
                ", likedByUser=" + likedByUser +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", urls=" + urls +
                ", categories=" + categories +
                ", links=" + links +
                '}';
    }
}
