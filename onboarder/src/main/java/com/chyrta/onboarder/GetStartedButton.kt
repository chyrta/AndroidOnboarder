package com.chyrta.onboarder

import android.support.annotation.ColorRes
import android.support.annotation.StringRes

class GetStartedButton {

    var title: String? = null
    var titleResourceId: Int? = null
        private set
        @StringRes get
    var textColorResourceId: Int? = null
        private set
        @ColorRes get

    inner class Creator internal constructor() {

        fun text(title: String): Creator {
            this@GetStartedButton.title = title
            return this
        }

        fun textResourceId(@StringRes titleResourceId: Int): Creator {
            this@GetStartedButton.titleResourceId = titleResourceId
            return this
        }

        fun textColor(@ColorRes textColorResourceId: Int): Creator {
            this@GetStartedButton.textColorResourceId = textColorResourceId
            return this
        }

        fun create(): GetStartedButton {
            return this@GetStartedButton
        }

    }

    companion object {
        fun newCreator(): Creator {
            return GetStartedButton().Creator()
        }
    }

}
