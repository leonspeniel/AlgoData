package com.leons.part1;

import java.util.NoSuchElementException;

public class Stack {
    private int[] array;
    private int size=0;

    public Stack() {
        array=new int[2];
    }

    //push
    public void push(int value){
        if(size==array.length){
            var newArray = new int[size*2];
            System.arraycopy(array,0,newArray,0,size);
            array=newArray;
        }
        array[size++]=value;
    }
    //pop
    public int pop(){
        if(isEmpty())throw new IllegalStateException();
        return array[--size];
    }
    //peek
    public int peek(){
        if(isEmpty())throw new IllegalStateException();
        return array[size-1];
    }
    //isEmpty
    public boolean isEmpty(){
        return size==0;
    }
}
