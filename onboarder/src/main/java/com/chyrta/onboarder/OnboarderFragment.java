package com.chyrta.onboarder;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class OnboarderFragment extends Fragment {

    private static final String ONBOARDER_PAGE_TITLE = "onboarder_page_title";
    private static final String ONBOARDER_PAGE_TITLE_RES_ID = "onboarder_page_title_res_id";
    private static final String ONBOARDER_PAGE_TITLE_COLOR = "onboarder_page_title_color";
    private static final String ONBOARDER_PAGE_DESCRIPTION = "onboarder_page_description";
    private static final String ONBOARDER_PAGE_DESCRIPTION_RES_ID = "onboarder_page_description_res_id";
    private static final String ONBOARDER_PAGE_DESCRIPTION_COLOR = "onborader_page_description_color";

    private String onboarderTitle;
    private String onboarderDescription;
    private int onboarderTitleResId;
    private int onboarderTitleColor;
    private int onboarderDescriptionResId;
    private int onboarderDescriptionColor;

    private View onboarderView;
    private ImageView ivOnboarderImage;
    private TextView tvOnboarderTitle;
    private TextView tvOnboarderDescription;

    public OnboarderFragment() {}

    public static OnboarderFragment newInstance(OnboarderPage page) {
        Bundle args = new Bundle();
        args.putString(ONBOARDER_PAGE_TITLE, page.getTitle());
        args.putString(ONBOARDER_PAGE_DESCRIPTION, page.getDescription());
        args.putInt(ONBOARDER_PAGE_TITLE_RES_ID, page.getTitleResourceId());
        args.putInt(ONBOARDER_PAGE_DESCRIPTION_RES_ID, page.getDescriptionResourceId());
        args.putInt(ONBOARDER_PAGE_TITLE_COLOR, page.getTitleColor());
        args.putInt(ONBOARDER_PAGE_DESCRIPTION_COLOR, page.getDescriptionColor());
        OnboarderFragment fragment = new OnboarderFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle bundle = getArguments();

        onboarderTitle = bundle.getString(ONBOARDER_PAGE_TITLE, null);
        onboarderTitleResId = bundle.getInt(ONBOARDER_PAGE_TITLE_RES_ID, -1);
        onboarderTitleColor = bundle.getInt(ONBOARDER_PAGE_TITLE_COLOR, -1);
        onboarderDescription = bundle.getString(ONBOARDER_PAGE_DESCRIPTION, null);
        onboarderDescriptionResId = bundle.getInt(ONBOARDER_PAGE_DESCRIPTION_RES_ID, -1);
        onboarderDescriptionColor = bundle.getInt(ONBOARDER_PAGE_DESCRIPTION_COLOR, -1);

        onboarderView = inflater.inflate(R.layout.fragment_onboarder, container, false);
        ivOnboarderImage = (ImageView) onboarderView.findViewById(R.id.iv_onboarder_image);
        tvOnboarderTitle = (TextView) onboarderView.findViewById(R.id.tv_onboarder_title);
        tvOnboarderDescription = (TextView) onboarderView.findViewById(R.id.tv_onboarder_description);

        if (onboarderTitle != null) {
            tvOnboarderTitle.setText(onboarderTitle);
        }

        if (onboarderTitleResId != -1) {
            tvOnboarderTitle.setText(onboarderTitleResId);
        }

        if (onboarderDescription != null) {
            tvOnboarderDescription.setText(onboarderDescription);
        }

        if (onboarderDescriptionResId != -1) {
            tvOnboarderDescription.setText(onboarderDescriptionResId);
        }

        if (onboarderTitleColor != -1) {
            tvOnboarderTitle.setTextColor(onboarderTitleColor);
        }

        if (onboarderDescriptionColor != -1) {
            tvOnboarderDescription.setTextColor(onboarderDescriptionColor);
        }

        return onboarderView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
