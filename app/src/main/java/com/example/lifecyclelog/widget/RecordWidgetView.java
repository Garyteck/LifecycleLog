package com.example.lifecyclelog.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.lifecyclelog.R;
import com.example.lifecyclelog.base.GenericWidgetView;
import com.example.lifecyclelog.model.ActivityRecord;
import com.example.lifecyclelog.model.FragmentRecord;
import com.example.lifecyclelog.model.Record;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 */

@EViewGroup(R.layout.list_item_record)
public class RecordWidgetView extends GenericWidgetView<Record> {

    @ViewById(android.R.id.text1)
    TextView mTextViewMethod;

    Context mContext;

    public RecordWidgetView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    public RecordWidgetView(Context context, AttributeSet attrs) {

        super(context, attrs);
        mContext = context;
    }

    public RecordWidgetView(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public void bind(Record record) {

        mTextViewMethod.setText(record.getMethod());

        /*if (record instanceof ActivityRecord) {
            mTextViewMethod.setBackgroundColor(mContext.getColor(R.color.red));
        }else {
            mTextViewMethod.setBackgroundColor(mContext.getColor(R.color.green));
        }*/

    }
}
