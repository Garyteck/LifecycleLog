package com.example.lifecyclelog.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 */
public class FragmentRecords extends Observable{



    public List<Record> getValue() {
        return mFragmentRecords;
    }

    List<Record> mFragmentRecords =new ArrayList<>();

    public void add(Record fragmentRecord) {
        mFragmentRecords.add(fragmentRecord);
        setChanged();
        notifyObservers(fragmentRecord);
    }

    public List<Record> getmFragmentRecords() {
        return mFragmentRecords;
    }



}
