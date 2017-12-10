package com.soethiha.unsplashpic.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.soethiha.unsplashpic.R;
import com.soethiha.unsplashpic.activities.base.BaseActivity;
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

        // If no photo list
        if (photoList == null || photoList.isEmpty()) {
            // Load the data from data layer
            refreshPhotoList();
        }

        controllerPhotoItem = this;
        mPhotoAdapter = new PhotoAdapter(getApplicationContext(), photoList, controllerPhotoItem);
        rvPhotos.setAdapter(mPhotoAdapter);

        // Set Layout Manager to Recycler View
        rvPhotos.setLayoutManager(new LinearLayoutManager(this));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshPhotoList();
            }
        });
    }

    private void refreshPhotoList() {
        if (NetworkUtilities.isOnline(getApplicationContext())) {
            swipeRefreshLayout.setRefreshing(true);
            PhotoModel.getObjInstance().loadPhotos(getApplicationContext());
        } else {
            // Stop loading
            swipeRefreshLayout.setRefreshing(false);
            Toast.makeText(this, R.string.net_con_fail, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onTapPhoto(PhotoVO photo, ImageView ivPhoto) {
        // Toast.makeText(this, "Tapped", Toast.LENGTH_SHORT).show();
    }

    @Subscribe
    public void onEvent(DataEvent.PhotoDataLoadedEvent event) {
        String extraMessage = event.getExtraMessage();
        List<PhotoVO> newPhotoList = event.getPhotoList();

        Toast.makeText(this, "success - " + newPhotoList.size(), Toast.LENGTH_SHORT).show();
        if (newPhotoList == null || newPhotoList.isEmpty()) {
            Toast.makeText(getApplicationContext(), extraMessage, Toast.LENGTH_SHORT).show();
        } else {
            mPhotoAdapter.setNewData(newPhotoList);

            // Stop loading
            swipeRefreshLayout.setRefreshing(false);
        }
    }
}
