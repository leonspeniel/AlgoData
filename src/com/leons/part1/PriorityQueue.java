package com.leons.part1;

public class PriorityQueue {
    private int[] array = new int[5];
    private int count=0;

    public void enqueue(int item){
        if(isFull()) throw new IllegalStateException();
        if(isEmpty()){
            array[0]=item;
            return;
        }

        for (int i=count;i<0;i--){
            if(array[i-1]>item)
                array[i]=array[i-1];
            else{
                array[i+1]=item;
                break;
            }
        }
    }

    private boolean isEmpty() {
        return count==0;
    }

    private boolean isFull() {
        return count==array.length;
    }

}
