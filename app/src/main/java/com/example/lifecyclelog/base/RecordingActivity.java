package com.example.lifecyclelog.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;

import com.example.lifecyclelog.BaseApp;
import com.example.lifecyclelog.R;


@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public abstract class RecordingActivity extends android.app.Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseApp.recLifeCycle(getClass());

        FragmentManager.enableDebugLogging(true);
        LoaderManager.enableDebugLogging(true);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        BaseApp.recLifeCycle(getClass());
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    protected void onPause() {
        super.onPause();
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        BaseApp.recLifeCycle(getClass());

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public boolean onPrepareOptionsMenu(final Menu menu) {
        boolean result = super.onPrepareOptionsMenu(menu);
        BaseApp.recLifeCycle(getClass());

        return result;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    protected void onResume() {
        super.onResume();
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    protected void onStart() {
        super.onStart();
        BaseApp.recLifeCycle(getClass());

    }

    @Override
    protected void onStop() {
        super.onStop();
        BaseApp.recLifeCycle(getClass());
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        BaseApp.recLifeCycle(getClass());
    }

    /*@Override
    public void onUserInteraction() {
        BaseApp.recLifeCycle(getClass());
        super.onUserInteraction();
        BaseApp.recLifeCycle(getClass());
    }*/
}
