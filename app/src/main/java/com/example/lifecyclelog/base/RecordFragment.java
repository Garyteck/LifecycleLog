package com.example.lifecyclelog.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lifecyclelog.BaseApp;
import com.example.lifecyclelog.R;

@TargetApi(Build.VERSION_CODES.KITKAT)
public class RecordFragment extends Fragment {


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public View
    onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_test, container, false);
        BaseApp.recLifeCycle(getClass());

        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BaseApp.recLifeCycle(getClass());

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        BaseApp.recLifeCycle(getClass());

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseApp.recLifeCycle(getClass());
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(final Menu menu, final MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onDetach() {
        super.onDetach();
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onPause() {
        super.onPause();
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onPrepareOptionsMenu(final Menu menu) {
        super.onPrepareOptionsMenu(menu);
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onResume() {
        super.onResume();
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onStart() {
        super.onStart();
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onStop() {
        super.onStop();

        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        BaseApp.recLifeCycle(getClass());
    }
}
