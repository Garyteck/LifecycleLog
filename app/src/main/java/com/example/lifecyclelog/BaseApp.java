package com.example.lifecyclelog;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;

import com.example.lifecyclelog.activities.MainActivity_;
import com.example.lifecyclelog.model.ActivityRecords;
import com.example.lifecyclelog.model.FragmentRecords;
import com.example.lifecyclelog.model.Record;

/**
 * Created by gary on 14/09/15.
 */
public final class BaseApp extends Application {



    static final ActivityRecords mActivityRecords = new ActivityRecords();
    static final FragmentRecords mFragmentRecords = new FragmentRecords();

    public ActivityRecords getmActivityRecords() {
        return mActivityRecords;
    }

    public FragmentRecords getmFragmentRecords() {
        return mFragmentRecords;
    }

    public static void recLifeCycle(Class<?> callingClass) {
        final String note="";
        recLifeCycle(callingClass, note);
    }

    private static void recLifeCycle(Class<?> callingClass, String note) {
        String className = callingClass.getSimpleName();
        StackTraceElement[] s = Thread.currentThread().getStackTrace();
        String methodName = s[4].getMethodName();

        Log.i("LifecycleLog",
                className + "." + methodName + (TextUtils.isEmpty(note) ? "" : " / " + note));
        add(callingClass,new Record(methodName));
    }

    public static void add(Class<?> callingClass, Record record){
        String className = callingClass.getSimpleName();

        if (className.equals(MainActivity_.class.getSimpleName())) {
            mActivityRecords.add(record);
            mFragmentRecords.add(new Record(""));

        }else {
            mActivityRecords.add(new Record(""));
            mFragmentRecords.add(record);
        }
    }



}
