package com.leons.part1;


public class Main {

    public static void main(String[] args) {
        var arrQ = new ArrayQueue(5);
        arrQ.enqueue(10);
        arrQ.enqueue(20);
        arrQ.enqueue(30);
        arrQ.dequeue();
        arrQ.enqueue(40);
        arrQ.dequeue();
        arrQ.enqueue(50);
        System.out.println(arrQ);
        arrQ.enqueue(60);
        System.out.println(arrQ);
        arrQ.enqueue(70);

    }
}
