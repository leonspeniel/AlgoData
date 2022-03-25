package com.leons;


import com.leons.part1.HashTable;
import com.leons.part2.MyTree;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        var mtree = new MyTree();
        mtree.insert(7);
        mtree.insert(4);
        mtree.insert(1);
        mtree.insert(6);
        mtree.insert(9);
        mtree.insert(8);
        mtree.insert(10);

        System.out.println(mtree.find(11));

    }


}
