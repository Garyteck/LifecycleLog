package com.example.lifecyclelog.base;

import android.app.Activity;
import android.view.ViewGroup;

import com.example.lifecyclelog.model.Record;
import com.example.lifecyclelog.widget.RecordWidgetView_;

/**
 * Created by gary on 14/09/15.
 */
public class MethodRecordAdapter extends GenericRecyclerAdapter<Record> {

    Activity mActivity;

    public MethodRecordAdapter(Activity activity) {
        super(activity);
        mActivity = activity;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public GenericWidgetView getItemView(ViewGroup parent, int viewType) {
        return RecordWidgetView_.build(mActivity);
    }
}
