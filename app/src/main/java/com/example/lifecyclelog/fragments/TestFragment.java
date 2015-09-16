package com.example.lifecyclelog.fragments;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.*;

import com.example.lifecyclelog.BaseApp;
import com.example.lifecyclelog.R;
import com.example.lifecyclelog.base.GenericRecyclerAdapter;
import com.example.lifecyclelog.base.GenericWidgetView;
import com.example.lifecyclelog.base.MethodRecordAdapter;
import com.example.lifecyclelog.base.RecordFragment;
import com.example.lifecyclelog.model.Record;
import com.example.lifecyclelog.widget.RecordWidgetView_;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

@TargetApi(Build.VERSION_CODES.KITKAT)
public class TestFragment extends RecordFragment implements Observer{

    BaseApp mBaseApp;
    RecyclerView mFragmentRecyclerView;
    GenericRecyclerAdapter<Record> mRecordAdapter;
    List<Record> mRecords = new ArrayList<>();


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
        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mFragmentRecyclerView.setLayoutManager(layoutManager);
        mRecordAdapter.addAll(mRecords);
        mRecordAdapter = new MethodRecordAdapter(getActivity());
        mFragmentRecyclerView.setAdapter(mRecordAdapter);
        return v;
    }

    @Override
    public void update(Observable observable, Object o) {
        if (mRecordAdapter != null ) {
            mRecordAdapter.add((Record) o);
            if (mFragmentRecyclerView != null) {
                mFragmentRecyclerView.scrollToPosition(mRecordAdapter.getItemCount() -1);
            }
        }
    }
}
