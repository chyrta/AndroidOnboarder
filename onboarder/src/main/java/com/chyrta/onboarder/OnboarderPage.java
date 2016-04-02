package com.chyrta.onboarder;

import android.graphics.drawable.Drawable;

public class OnboarderPage {

    public String title;
    public String description;
    public Drawable imageResource;
    public int titleResourceId;
    public int descriptionResourceId;
    public int imageResourceId;
    public int titleColor;
    public int descriptionColor;

    public OnboarderPage(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public OnboarderPage(String title, String description, int imageResourceId) {
        this.title = title;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public OnboarderPage(String title, String description, Drawable imageResource) {
        this.title = title;
        this.description = description;
        this.imageResource = imageResource;
    }

    public OnboarderPage(int title, int description) {
        this.titleResourceId = title;
        this.descriptionResourceId = description;
    }

    public OnboarderPage(int title, int description, int imageResourceId) {
        this.titleResourceId = title;
        this.descriptionResourceId = description;
        this.imageResourceId = imageResourceId;
    }

    public OnboarderPage(int title, int description, Drawable imageResource) {
        this.titleResourceId = title;
        this.descriptionResourceId = description;
        this.imageResource = imageResource;
    }

    public void setTitleColor(int color) {
        this.titleColor = color;
    }

    public void setDescriptionColor(int color) {
        this.descriptionColor = color;
    }

}
