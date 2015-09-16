package com.example.lifecyclelog.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public abstract class GenericWidgetView<T> extends FrameLayout
{

    public GenericWidgetView(Context context)
    {
        super(context);
    }

    public GenericWidgetView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public GenericWidgetView(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    public abstract void bind(T object);


}