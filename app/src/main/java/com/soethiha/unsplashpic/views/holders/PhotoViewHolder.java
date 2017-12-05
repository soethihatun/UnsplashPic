package com.soethiha.unsplashpic.views.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.soethiha.unsplashpic.R;
import com.soethiha.unsplashpic.data.vos.PhotoVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * UnsplashPic
 *
 * @author SoeThihaTun
 * @version 1.0
 * @since 02/12/2017
 */

public class PhotoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.iv_photo)
    ImageView ivPhoto;

    private ControllerPhotoItem mController;
    private PhotoVO mPhoto;

    public PhotoViewHolder(View itemView, ControllerPhotoItem controller) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
        mController = controller;
    }

    public void bindData(PhotoVO photo) {
        mPhoto = photo;

//        String imageUrl = MyanmarAttractionsConstants.IMAGE_ROOT_DIR + photo.getImages()[0];
        String imageUrl = mPhoto.getUrls().getRegular();

        Glide.with(ivPhoto.getContext())
                .load(imageUrl)
//                .centerCrop()
//                .placeholder(R.drawable.ic_launcher_background)
//                .error(R.drawable.ic_launcher_background)
                .into(ivPhoto);
    }

    @Override
    public void onClick(View view) {
        mController.onTapPhoto(mPhoto, ivPhoto);
    }

    public interface ControllerPhotoItem {
        void onTapPhoto(PhotoVO photo, ImageView ivPhoto);
    }
}
