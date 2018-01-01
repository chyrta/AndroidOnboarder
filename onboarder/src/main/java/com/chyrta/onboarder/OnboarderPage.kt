package com.chyrta.onboarder

import android.graphics.drawable.Drawable
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes

class OnboarderPage {

    var title: String? = null
        private set
    var description: String? = null
        private set
    var imageResource: Drawable? = null
        private set

    var titleResourceId: Int = 0
        @StringRes get() = field
        private set(@StringRes titleResourceId) { field = titleResourceId}

    var descriptionResourceId: Int = 0
        @StringRes get() = field
        private set(@StringRes descriptionResourceId) { field = descriptionResourceId }

    var imageResourceId: Int = 0
        @DrawableRes get() = field
        private set(@DrawableRes value) { field = value }

    var titleColor: Int = 0
        @ColorRes get() = field
        private set(@ColorRes titleColor) { field = titleColor}


    var descriptionColor: Int = 0
        @ColorRes get() = field
        private set(@ColorRes descriptionColor) { field = descriptionColor }

    var backgroundColor: Int = 0
        @ColorRes get() = field
        private set(@ColorRes backgroundColor ) { field = backgroundColor }

    inner class Creator internal constructor() {

        fun title(title: String): Creator {
            this@OnboarderPage.title = title
            return this
        }

        fun titleResourceId(@StringRes titleResourceId: Int): Creator {
            this@OnboarderPage.titleResourceId = titleResourceId
            return this
        }

        fun description(description: String): Creator {
            this@OnboarderPage.description = description
            return this
        }

        fun descriptionResourceId(@StringRes descriptionResourceId: Int): Creator {
            this@OnboarderPage.descriptionResourceId = descriptionResourceId
            return this
        }

        fun imageDrawable(imageDrawable: Drawable): Creator {
            this@OnboarderPage.imageResource = imageDrawable
            return this
        }

        fun imageResourceId(@DrawableRes imageResourceId: Int): Creator {
            this@OnboarderPage.imageResourceId = imageResourceId
            return this
        }

        fun titleColor(@ColorRes titleColor: Int): Creator {
            this@OnboarderPage.titleColor = titleColor
            return this
        }

        fun descriptionColor(@ColorRes descriptionColor: Int): Creator {
            this@OnboarderPage.descriptionColor = descriptionColor
            return this
        }

        fun backgroundColor(@ColorRes backgroundColor: Int): Creator {
            this@OnboarderPage.backgroundColor = backgroundColor
            return this
        }

        fun create(): OnboarderPage {
            return this@OnboarderPage
        }

    }

    companion object {

        fun newCreator(): Creator {
            return OnboarderPage().Creator()
        }
    }

}
