package com.example.taye.alcchallenge.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.example.taye.alcchallenge.R;

/**
 * Created by TAYE on 21/04/2017.
 */

public class DetailUserActivity extends AppCompatActivity {

    TextView detailedUsername, ghLink;
    ImageView imageView;
    String username, avatarUrl, htmlUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Details Activity");

        imageView = (ImageView) findViewById(R.id.detailImageView);
        detailedUsername = (TextView) findViewById(R.id.detailedUsername);
        ghLink = (TextView) findViewById(R.id.detailedGithubLink);

        username = getIntent().getExtras().getString("login");
        htmlUrl = getIntent().getExtras().getString("htmlUrl");
        avatarUrl = getIntent().getExtras().getString("avatarUrl");

        ghLink.setText(htmlUrl);
        Linkify.addLinks(ghLink, Linkify.WEB_URLS);

        Glide.with(this)
                .load(avatarUrl)
                .placeholder(R.drawable.loading)
                .into(imageView);

        detailedUsername.setText(username);

    }

    private Intent shareIntent() {
        username = getIntent().getExtras().getString("login");
        htmlUrl = getIntent().getExtras().getString("htmlUrl");

        Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                .setText("Check out this awesome developer @" + username + ", " + htmlUrl + ".")
                .setType("text/plain")
                .getIntent();
        return  shareIntent;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_detail, menu);
        MenuItem menuItem = menu.findItem(R.id.share);
        menuItem.setIntent(shareIntent());
        return true;
    }

}
