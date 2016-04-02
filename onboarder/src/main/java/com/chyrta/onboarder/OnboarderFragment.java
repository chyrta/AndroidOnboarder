package com.chyrta.onboarder;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OnboarderFragment extends Fragment implements View.OnClickListener {

    View onBoarderView;

    public OnboarderFragment() {}

    public static OnboarderFragment newInstance(OnboarderPage page) {
        Bundle args = new Bundle();
        OnboarderFragment fragment = new OnboarderFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        onBoarderView = inflater.inflate(R.layout.fragment_onboarder, container, false);
        return onBoarderView;
    }


    @Override
    public void onClick(View v) {

    }

}
