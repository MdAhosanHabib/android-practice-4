package com.freeapps.sbnapps;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.google.android.gms.ads.AdView;


public class PrivacyPolicy extends Fragment {


    WebView webViewAudio;
    private AdView mAdView;
    public PrivacyPolicy() {
        // Required empty public constructor
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.privacy_policy, container, false);


        webViewAudio = rootView.findViewById(R.id.webView);

        WebSettings webSettings = webViewAudio.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webViewAudio.loadUrl("http://cdn.topofstacksoftware.com/apps/privacy/islamic.html");



        return rootView;
    }

}