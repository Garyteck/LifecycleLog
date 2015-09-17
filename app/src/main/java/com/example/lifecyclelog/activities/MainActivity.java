package com.example.lifecyclelog.activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.lifecyclelog.BaseApp;
import com.example.lifecyclelog.R;
import com.example.lifecyclelog.base.MethodRecordAdapter;
import com.example.lifecyclelog.base.RecordingActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.Observable;
import java.util.Observer;

/**
 * A standard Android RecordingActivity.
 */
@EActivity(R.layout.activity_main)
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends RecordingActivity implements Observer{

    BaseApp mBaseApp;

    @ViewById
    RecyclerView mActivityRecyclerView;


    MethodRecordAdapter methodRecordAdapter = new MethodRecordAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBaseApp = (BaseApp) getApplication();
        mBaseApp.getmActivityRecords().addObserver(this);
    }

    @AfterViews
    void afterViews() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this) {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.MATCH_PARENT);
            }
        };
        mActivityRecyclerView.setLayoutManager(layoutManager);
        mActivityRecyclerView.setAdapter(methodRecordAdapter);
    }


    @Override
    public void update(Observable observable, Object o) {
        if (methodRecordAdapter != null ) {
            methodRecordAdapter.clear();
            methodRecordAdapter.addAll(mBaseApp.getmActivityRecords().getmActivityRecords());
            if (mActivityRecyclerView != null) {
                mActivityRecyclerView.scrollToPosition(methodRecordAdapter.getItemCount()-1);

            }
        }
    }
}
