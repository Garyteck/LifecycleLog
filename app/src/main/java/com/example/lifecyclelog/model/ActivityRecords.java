package com.example.lifecyclelog.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 */
public class ActivityRecords extends Observable{

    List<Record> mActivityRecords = new ArrayList<>();

    public void add(Record activityRecord) {
        mActivityRecords.add(activityRecord);
        setChanged();
        notifyObservers(activityRecord);
    }

    @Override
    public boolean hasChanged() {
        return true;
    }
}
