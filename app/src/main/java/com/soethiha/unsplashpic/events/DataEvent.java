package com.soethiha.unsplashpic.events;

import com.soethiha.unsplashpic.data.vos.PhotoVO;

import java.util.List;

/**
 * UnsplashPic
 *
 * @author SoeThihaTun
 * @version 1.0
 * @since 02/12/2017
 */
public class DataEvent {
    public static class PhotoDataLoadedEvent {

        private String extraMessage;
        private List<PhotoVO> photoList;

        public PhotoDataLoadedEvent(String extraMessage, List<PhotoVO> photoList) {
            this.extraMessage = extraMessage;
            this.photoList = photoList;
        }

        public String getExtraMessage() {
            return extraMessage;
        }

        public List<PhotoVO> getPhotoList() {
            return photoList;
        }
    }
}
