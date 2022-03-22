package com.leons.part1;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayQueue {

    private int[] array;
    private int first=0,last=0,count=0;

    public ArrayQueue(int length){
        array = new int[length];
    }

    //enqueue
    public void enqueue(int value){
        if(isFull()) throw new IllegalStateException();
        array[last]=value;
        last = (last+1)%array.length;
        count++;
    }

    //dequeue
    public int dequeue(){
        if(isEmpty()) throw new IllegalStateException();
        int val = array[first];
        array[first]=0;
        first = (first+1)%array.length;
        count--;
        return val;
    }
    //peek
    public int peek(){
        if(isEmpty()) throw new EmptyStackException();
        return array[first];
    }
    //isEmpty
    public boolean isEmpty(){
        return count==0;
    }
    //isFull
    public boolean isFull(){
        return count==array.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
