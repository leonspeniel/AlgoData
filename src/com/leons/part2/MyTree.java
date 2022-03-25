package com.leons.part2;

public class MyTree {

    private class Node{
        private int value;
        private Node rightChild,leftChild;
        private Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value){
        if(root==null){
            root = new Node(value);
            return;
        }
        var cursor = root;
        while (true){
            if(cursor.value>value) {
                if (cursor.leftChild == null) {
                    cursor.leftChild = new Node(value);
                    break;
                }
                cursor = cursor.leftChild;
            }
            else{
                if (cursor.rightChild == null) {
                    cursor.rightChild = new Node(value);
                    break;
                }
                cursor = cursor.rightChild;
            }
        }
    }

    public boolean find(int value){
        var cursor = root;
        while(cursor!=null){
            if(cursor.value==value)return true;
            cursor = cursor.value>value?cursor.leftChild:cursor.rightChild;
        }
        return false;
    }
}
