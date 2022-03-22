package com.leons.part1;

import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

public class StackQueue {

    private Stack<Integer> normal=new Stack<>();
    private Stack<Integer> reverse=new Stack<>();

    // My Logic
    /*public void enqueue(int item){
        normal.add(item);
        reverse=new Stack<>();
        var temp = new Stack<>();
        temp.addAll(normal);
        while (!temp.isEmpty()){
            reverse.add((int)temp.pop());
        }
    }

    public int dequeue(){
        int val = reverse.pop();
        normal=new Stack<>();
        var temp = new Stack<>();
        temp.addAll(reverse);
        while (!temp.isEmpty()){
            normal.add((int)temp.pop());
        }
        return val;
    }*/

    //Mosh logic

    public void enqueue(int item){
        normal.add(item);
    }

    public int dequeue(){
        if(isEmpty()) throw new IllegalStateException();
        normalToReverse();
        return reverse.pop();
    }

    private void normalToReverse() {
        if (reverse.isEmpty())
            while (!normal.isEmpty())
                reverse.add(normal.pop());
    }

    public int peek(){
        if(isEmpty()) throw new IllegalStateException();
        normalToReverse();
        return reverse.peek();
    }

    public boolean isEmpty(){
        return normal.isEmpty() && reverse.isEmpty();
    }
}
