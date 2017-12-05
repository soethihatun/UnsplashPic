package com.soethiha.unsplashpic.activities;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.soethiha.unsplashpic.R;
import com.soethiha.unsplashpic.UnsplashPicApp;
import com.soethiha.unsplashpic.adapters.PhotoAdapter;
import com.soethiha.unsplashpic.data.models.PhotoModel;
import com.soethiha.unsplashpic.data.vos.PhotoVO;
import com.soethiha.unsplashpic.events.DataEvent;
import com.soethiha.unsplashpic.views.holders.PhotoViewHolder;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * UnsplashPic
 *
 * @author SoeThihaTun
 * @version 1.0
 * @since 01/12/2017
 */

public class MainActivity extends BaseActivity {

    @BindView(R.id.rv_photo_list)
    RecyclerView rvPhotos;

    private PhotoAdapter mPhotoAdapter;
    private PhotoViewHolder.ControllerPhotoItem controllerPhotoItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        List<PhotoVO> photoList = PhotoModel.getObjInstance().getPhotoList();
        mPhotoAdapter = new PhotoAdapter(getApplicationContext(), photoList, controllerPhotoItem);
        Log.d(UnsplashPicApp.TAG, "onCreate: Size = " + (photoList.size()));
        rvPhotos.setAdapter(mPhotoAdapter);
    }

    @Subscribe
    public void onEvent(DataEvent.PCDataLoadedEvent event) {
        String extra = event.getExtraMessage();
        Toast.makeText(getApplicationContext(), "Extra : " + extra, Toast.LENGTH_SHORT).show();
        Log.d(UnsplashPicApp.TAG, "onPCDataLoadedEvent: ");

        List<PhotoVO> newPhotoList = event.getPhotoList();
        mPhotoAdapter.setNewData(newPhotoList);
    }
}
