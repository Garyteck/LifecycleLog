package com.example.lifecyclelog.fragments;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lifecyclelog.BaseApp;
import com.example.lifecyclelog.R;
import com.example.lifecyclelog.base.GenericRecyclerAdapter;
import com.example.lifecyclelog.base.MethodRecordAdapter;
import com.example.lifecyclelog.base.RecordFragment;
import com.example.lifecyclelog.model.Record;

import java.util.Observable;
import java.util.Observer;

@TargetApi(Build.VERSION_CODES.KITKAT)
public class TestFragment extends RecordFragment implements Observer{

    BaseApp mBaseApp;
    RecyclerView mFragmentRecyclerView;
    GenericRecyclerAdapter<Record> mRecordAdapter;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mBaseApp = (BaseApp) activity.getApplication();
        mBaseApp.getmFragmentRecords().addObserver(this);
        mRecordAdapter = new MethodRecordAdapter(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  super.onCreateView(inflater, container, savedInstanceState);

        mFragmentRecyclerView = (RecyclerView) v.findViewById(R.id.mFragmentRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity()) {
            @Override
            public RecyclerView.LayoutParams generateDefaultLayoutParams() {
                return new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.MATCH_PARENT);
            }
        };
        mFragmentRecyclerView.setLayoutManager(layoutManager);
        mRecordAdapter = new MethodRecordAdapter(getActivity());
        mFragmentRecyclerView.setAdapter(mRecordAdapter);
        return v;
    }

    @Override
    public void update(Observable observable, Object o) {
        if (mRecordAdapter != null ) {
            mRecordAdapter.clear();
            mRecordAdapter.addAll(mBaseApp.getmFragmentRecords().getmFragmentRecords());
            if (mFragmentRecyclerView != null) {
                mFragmentRecyclerView.scrollToPosition(mRecordAdapter.getItemCount() -1);
            }
        }
    }
}
