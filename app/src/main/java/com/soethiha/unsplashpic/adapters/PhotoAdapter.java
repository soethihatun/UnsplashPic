package com.soethiha.unsplashpic.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soethiha.unsplashpic.R;
import com.soethiha.unsplashpic.data.vos.PhotoVO;
import com.soethiha.unsplashpic.views.holders.PhotoViewHolder;

import java.util.List;

/**
 * UnsplashPic
 *
 * @author SoeThihaTun
 * @version 1.0
 * @since 02/12/2017
 */
public class PhotoAdapter extends RecyclerView.Adapter<PhotoViewHolder> {

    private LayoutInflater mInflater;
    private List<PhotoVO> mPhotoList;
    private PhotoViewHolder.ControllerPhotoItem mControllerPhotoItem;

    public PhotoAdapter(Context context, List<PhotoVO> photoList, PhotoViewHolder.ControllerPhotoItem controllerPhotoItem) {
        mInflater = LayoutInflater.from(context);
        mPhotoList = photoList;
        mControllerPhotoItem = controllerPhotoItem;
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.view_item_photo, parent, false);
        return new PhotoViewHolder(itemView, mControllerPhotoItem);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        holder.bindData(mPhotoList.get(position));
    }

    @Override
    public int getItemCount() {
        return mPhotoList.size();
    }

    /**
     * Swap the photo list with new photo list and notify
     * @param newPhotoList New Photo list from data source
     */
    public void setNewData(List<PhotoVO> newPhotoList) {
        mPhotoList = newPhotoList;
        notifyDataSetChanged();
    }
}
