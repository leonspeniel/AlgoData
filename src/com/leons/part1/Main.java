package com.leons.part1;


import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        HashTable ht = new HashTable();
        ht.put(3,"hello");
        ht.put(4,"world");
        ht.put(8,"img");

        System.out.println(ht.get(8));

    }


}
