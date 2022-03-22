package com.leons.part1;


import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        var sq = new StackQueue();
        sq.enqueue(10);
        sq.enqueue(20);
        sq.enqueue(30);
        sq.dequeue();
        sq.dequeue();
        var i = sq.dequeue();

        System.out.println(i);


    }
}
