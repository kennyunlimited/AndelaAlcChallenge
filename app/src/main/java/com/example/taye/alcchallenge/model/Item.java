package com.example.taye.alcchallenge.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by TAYE on 21/04/2017.
 */

public class Item {

    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("avatar_url")
    @Expose
    private String avatar_url;

    @SerializedName("html_url")
    @Expose
    private String htm_url;

    public Item(String login, String avatar_url, String htm_url) {
        this.login = login;
        this.avatar_url = avatar_url;
        this.htm_url = htm_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getHtm_url() {
        return htm_url;
    }

    public void setHtm_url(String htm_url) {
        this.htm_url = htm_url;
    }
}
