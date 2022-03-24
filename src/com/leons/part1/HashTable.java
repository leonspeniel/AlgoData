package com.leons.part1;

import java.util.LinkedList;

public class HashTable {

    private class Entry{
        private int key;
        private String value;

        private Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int size = 5;
    private LinkedList<Entry>[] mainArray = new LinkedList[size];

    //put
    public void put(int key, String value){

        int i = getIndex(key);

        if( mainArray[i]==null)
            mainArray[i] = new LinkedList<>();

        var entrys = mainArray[i];
        for(Entry en : entrys)
            if(en.key==key){
                en.value=value;
                return;
            }

        entrys.add(new Entry(key,value));
    }
    //get
    public String get(int key){
        int i = getIndex(key);
        var bucket = mainArray[i];
        if(bucket!=null)
            for (Entry en:bucket)
                if (en.key==key)
                    return en.value;

        return null;
    }
    //remove

    public void remove(int key){
        int i = getIndex(key);
        var bucket = mainArray[i];
        if(bucket==null)
            throw new IllegalStateException();
        for (Entry en:bucket)
            if (en.key==key) {
                bucket.remove(en);
                return;
            }
        throw new IllegalStateException();
    }

    private int getIndex(int key){
        return key%size;
    }
}
