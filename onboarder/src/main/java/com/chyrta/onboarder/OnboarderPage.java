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

    public int getImageResourceId() {
        return imageResourceId;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public static Creator newCreator() {
        return new OnboarderPage().new Creator();
    }

    public class Creator {

        private Creator() {}

        public Creator title(String title) {
            OnboarderPage.this.title = title;
            return this;
        }

        public Creator titleResourceId(@StringRes int titleResourceId) {
            OnboarderPage.this.titleResourceId = titleResourceId;
            return this;
        }

        public Creator description(String description) {
            OnboarderPage.this.description = description;
            return this;
        }

        public Creator descriptionResourceId(@StringRes int descriptionResourceId) {
            OnboarderPage.this.descriptionResourceId = descriptionResourceId;
            return this;
        }

        public Creator imageDrawable(Drawable imageDrawable) {
            OnboarderPage.this.imageResource = imageDrawable;
            return this;
        }

        public Creator imageResourceId(@DrawableRes int imageResourceId) {
            OnboarderPage.this.imageResourceId = imageResourceId;
            return this;
        }

        public Creator titleColor(@ColorRes int titleColor) {
            OnboarderPage.this.titleColor = titleColor;
            return this;
        }

        public Creator descriptionColor(@ColorRes int descriptionColor) {
            OnboarderPage.this.descriptionColor = descriptionColor;
            return this;
        }

        public Creator backgroundColor(@ColorRes int backgroundColor) {
            OnboarderPage.this.backgroundColor = backgroundColor;
            return this;
        }

        public OnboarderPage create() {
            return OnboarderPage.this;
        }

    }

}
