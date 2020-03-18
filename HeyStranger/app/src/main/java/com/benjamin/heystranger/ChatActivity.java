package com.benjamin.heystranger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int MAX_LENGTH_NAME = 20;
    private ImageView imgMoreMedia, imgAddPhoto, imgAddVideo, imgAddIcon;
    private EditText edtChat;
    private boolean isMoreMedia = false;
    private Toolbar toolbar;
    private TextView tvPartner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        findId();
        initViews();
    }

    private void findId() {
        imgMoreMedia = findViewById(R.id.imgAddMedia);
        imgAddPhoto = findViewById(R.id.imgAddPhoto);
        imgAddVideo = findViewById(R.id.imgAddVideo);
        imgAddIcon = findViewById(R.id.imgAddIcon);
        edtChat = findViewById(R.id.edtChat);
        toolbar = findViewById(R.id.toolbarChat);
        tvPartner = findViewById(R.id.tvPartner);
    }

    private void initViews() {
        toolbar.setTitle(R.string.empty_string);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        imgMoreMedia.setOnClickListener(this);
        edtChat.setOnClickListener(this);

        setPartnerName("Trung");
    }

    private void setPartnerName(String name){
        if (name.length() > MAX_LENGTH_NAME){
            name = name.substring(0, 10) + "...";
        }
        tvPartner.setText(name);
    }

    private void openMoreMedia(){
        imgAddPhoto.setVisibility(View.VISIBLE);
        imgAddVideo.setVisibility(View.VISIBLE);
        imgAddIcon.setVisibility(View.VISIBLE);
        imgMoreMedia.setImageResource(R.drawable.close_media);
    }

    private void closeMoreMedia(){
        imgAddPhoto.setVisibility(View.GONE);
        imgAddVideo.setVisibility(View.GONE);
        imgAddIcon.setVisibility(View.GONE);
        imgMoreMedia.setImageResource(R.drawable.more_media_send);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgAddMedia:
                if (isMoreMedia){
                    closeMoreMedia();
                }else {
                    openMoreMedia();
                }
                isMoreMedia = !isMoreMedia;
                break;
            case R.id.edtChat:
                closeMoreMedia();
                isMoreMedia = false;
                break;
        }
    }
}
