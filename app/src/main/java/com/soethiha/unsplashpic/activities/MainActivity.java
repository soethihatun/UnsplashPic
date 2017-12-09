package com.soethiha.unsplashpic.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.soethiha.unsplashpic.R;
import com.soethiha.unsplashpic.UnsplashPicApp;
import com.soethiha.unsplashpic.adapters.PhotoAdapter;
import com.soethiha.unsplashpic.data.models.PhotoModel;
import com.soethiha.unsplashpic.data.vos.PhotoVO;
import com.soethiha.unsplashpic.events.DataEvent;
import com.soethiha.unsplashpic.utils.NetworkUtilities;
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

public class MainActivity extends BaseActivity implements PhotoViewHolder.ControllerPhotoItem {

    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;

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
        controllerPhotoItem = (PhotoViewHolder.ControllerPhotoItem) this;
        mPhotoAdapter = new PhotoAdapter(getApplicationContext(), photoList, controllerPhotoItem);
        Log.d(UnsplashPicApp.TAG, "onCreate: Size = " + (photoList.size()));
        rvPhotos.setAdapter(mPhotoAdapter);

        // Set Layout Manager to Recycler View
        rvPhotos.setLayoutManager(new LinearLayoutManager(this));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // This method performs the actual data-refresh operation.
                // The method calls setRefreshing(false) when it's finished.
                refreshPhotoList();
            }
        });
    }

    private void refreshPhotoList() {
        if (NetworkUtilities.isOnline(getApplicationContext())) {
            PhotoModel.getObjInstance().loadPhotos(getApplicationContext());
        } else {
            // Stop loading
            swipeRefreshLayout.setRefreshing(false);
            Toast.makeText(this, "Connection fail.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onTapPhoto(PhotoVO photo, ImageView ivPhoto) {
        Toast.makeText(this, "Tapped", Toast.LENGTH_SHORT).show();
    }

    @Subscribe
    public void onEvent(DataEvent.PCDataLoadedEvent event) {
        String extraMessage = event.getExtraMessage();
        List<PhotoVO> newPhotoList = event.getPhotoList();
        Toast.makeText(getApplicationContext(), extraMessage + " : " + newPhotoList.size(), Toast.LENGTH_SHORT).show();
        mPhotoAdapter.setNewData(newPhotoList);

        // Stop loading
        swipeRefreshLayout.setRefreshing(false);
    }
}
