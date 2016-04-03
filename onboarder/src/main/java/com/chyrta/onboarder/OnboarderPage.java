package com.chyrta.onboarder;

import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

public class OnboarderPage {

    public String title;
    public String description;
    public Drawable imageResource;
    @StringRes public int titleResourceId;
    @StringRes public int descriptionResourceId;
    @DrawableRes public int imageResourceId;
    @ColorRes public int titleColor;
    @ColorRes public int descriptionColor;
    @ColorRes public int backgroundColor;

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

    public String getTitle() {
        return title;
    }

    public int getTitleResourceId() {
        return titleResourceId;
    }

    public String getDescription() {
        return description;
    }

    public int getDescriptionResourceId() {
        return descriptionResourceId;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public int getDescriptionColor() {
        return descriptionColor;
    }

    public void setTitleColor(int color) {
        this.titleColor = color;
    }

    public void setDescriptionColor(int color) {
        this.descriptionColor = color;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }
}
