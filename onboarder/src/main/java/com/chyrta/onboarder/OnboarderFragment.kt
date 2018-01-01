package com.chyrta.onboarder

import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.content.res.AppCompatResources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class OnboarderFragment : Fragment() {

    private var onboarderTitle: String? = null
    private var onboarderDescription: String? = null

    @StringRes private var onboarderTitleResId: Int = 0
    @ColorRes private var onboarderTitleColor: Int = 0
    @StringRes private var onboarderDescriptionResId: Int = 0
    @ColorRes private var onboarderDescriptionColor: Int = 0
    @DrawableRes private var onboarderImageResId: Int = 0

    private var onboarderView: View? = null
    private var ivOnboarderImage: ImageView? = null
    private var tvOnboarderTitle: TextView? = null
    private var tvOnboarderDescription: TextView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val bundle = arguments

        onboarderTitle = bundle.getString(ONBOARDER_PAGE_TITLE, null)
        onboarderTitleResId = bundle.getInt(ONBOARDER_PAGE_TITLE_RES_ID, 0)
        onboarderTitleColor = bundle.getInt(ONBOARDER_PAGE_TITLE_COLOR, 0)
        onboarderDescription = bundle.getString(ONBOARDER_PAGE_DESCRIPTION, null)
        onboarderDescriptionResId = bundle.getInt(ONBOARDER_PAGE_DESCRIPTION_RES_ID, 0)
        onboarderDescriptionColor = bundle.getInt(ONBOARDER_PAGE_DESCRIPTION_COLOR, 0)
        onboarderImageResId = bundle.getInt(ONBOARDER_PAGE_IMAGE_RES_ID, 0)
        onboarderView = inflater!!.inflate(R.layout.fragment_onboarder, container, false)
        ivOnboarderImage = onboarderView!!.findViewById<View>(R.id.iv_onboarder_image) as ImageView
        tvOnboarderTitle = onboarderView!!.findViewById<View>(R.id.tv_onboarder_title) as TextView
        tvOnboarderDescription = onboarderView!!.findViewById<View>(R.id.tv_onboarder_description) as TextView

        if (onboarderTitle != null) {
            tvOnboarderTitle!!.text = onboarderTitle
        }

        if (onboarderTitleResId != 0) {
            tvOnboarderTitle!!.text = resources.getString(onboarderTitleResId)
        }

        if (onboarderDescription != null) {
            tvOnboarderDescription!!.text = onboarderDescription
        }

        if (onboarderDescriptionResId != 0) {
            tvOnboarderDescription!!.text = resources.getString(onboarderDescriptionResId)
        }

        if (onboarderTitleColor != 0) {
            tvOnboarderTitle!!.setTextColor(ContextCompat.getColor(activity, onboarderTitleColor))
        }

        if (onboarderDescriptionColor != 0) {
            tvOnboarderDescription!!.setTextColor(ContextCompat.getColor(activity, onboarderDescriptionColor))
        }

        if (onboarderImageResId != 0) {
            ivOnboarderImage!!.setImageDrawable(AppCompatResources.getDrawable(activity, onboarderImageResId))
        }

        return onboarderView
    }

    companion object {

        private val ONBOARDER_PAGE_TITLE = "onboarder_page_title"
        private val ONBOARDER_PAGE_TITLE_RES_ID = "onboarder_page_title_res_id"
        private val ONBOARDER_PAGE_TITLE_COLOR = "onboarder_page_title_color"
        private val ONBOARDER_PAGE_DESCRIPTION = "onboarder_page_description"
        private val ONBOARDER_PAGE_DESCRIPTION_RES_ID = "onboarder_page_description_res_id"
        private val ONBOARDER_PAGE_DESCRIPTION_COLOR = "onborader_page_description_color"
        private val ONBOARDER_PAGE_IMAGE_RES_ID = "onboarder_page_iamge_res_id"

        fun newInstance(page: OnboarderPage): OnboarderFragment {
            val args = Bundle()
            args.putString(ONBOARDER_PAGE_TITLE, page.title)
            args.putString(ONBOARDER_PAGE_DESCRIPTION, page.description)
            args.putInt(ONBOARDER_PAGE_TITLE_RES_ID, page.titleResourceId)
            args.putInt(ONBOARDER_PAGE_DESCRIPTION_RES_ID, page.descriptionResourceId)
            args.putInt(ONBOARDER_PAGE_TITLE_COLOR, page.titleColor)
            args.putInt(ONBOARDER_PAGE_DESCRIPTION_COLOR, page.descriptionColor)
            args.putInt(ONBOARDER_PAGE_IMAGE_RES_ID, page.imageResourceId)
            val fragment = OnboarderFragment()
            fragment.arguments = args
            return fragment
        }

    }

}
