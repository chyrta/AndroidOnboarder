package com.chyrta.onboarder;

import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;

public class GetStartedButton {

    private String title;

    public String getTitle() {
        return title;
    }

    @StringRes
    private int titleResourceId;

    @ColorRes
    private int textColorResourceId;

    public int getTitleResourceId() {
        return titleResourceId;
    }

    public int getTextColorResourceId() {
        return textColorResourceId;
    }

    public static Creator newCreator() {
        return new GetStartedButton().new Creator();
    }

    public class Creator {

        private Creator() {}

        public Creator text(String title) {
            GetStartedButton.this.title = title;
            return this;
        }

        public Creator textResourceId(@StringRes int titleResourceId) {
            GetStartedButton.this.titleResourceId = titleResourceId;
            return this;
        }

        public Creator textColorResourceId(@ColorRes int textColorResourceId) {
            GetStartedButton.this.textColorResourceId = textColorResourceId;
            return this;
        }

        public GetStartedButton create() {
            return GetStartedButton.this;
        }

    }

}
