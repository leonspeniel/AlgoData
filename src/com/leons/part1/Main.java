package com.leons.part1;


import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        var sq = new PriorityQueue();
        sq.enqueue(20);
        sq.enqueue(10);
        sq.enqueue(30);
        sq.enqueue(15);


        System.out.println(sq.dequeue());


    }
}
