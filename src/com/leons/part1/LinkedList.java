package com.leons.part1;

import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private Node(int value) {
            this.value = value;
        }
        private int value;
        private Node next;
    }

    private Node firstNode, lastNode;
    private int length;

    public void add(int value){
        if(firstNode==null)
            addFirst(value);
        else
            addLast(value);
    }

    //addFirst

    public void addFirst(int value){
        var node = new Node(value);

        if(isEmpty())
            firstNode=lastNode= node;
        else{
            node.next = firstNode;
            firstNode = node;
        }
        length++;
    }
    //addLast

    public void addLast(int value){
        var node = new Node(value);
        if(isEmpty())
            firstNode=lastNode=node;
        else {
            lastNode.next = node; // assign the ref in last chain
            lastNode = node; // changing the last chain node tag to new node
        }
        length++;
    }
    private boolean isEmpty(){
        return firstNode==null;
    }
    //deleteFirst
    public void deleteFirst(){

        if(isEmpty())throw new NoSuchElementException();

        if(firstNode==lastNode){
            firstNode = lastNode = null;
        }else {
            var temp = firstNode;
            firstNode = firstNode.next;
            temp.next = null;
        }
        length--;
    }
    //deleteLast
    public void deleteLast(){
        if(isEmpty())throw new NoSuchElementException();

        if(firstNode==lastNode){
            firstNode = lastNode = null;
        }else {
            Node previous = getPrevious(lastNode);
            previous.next = null;
            lastNode = previous;
        }
        length--;
    }

    private Node getPrevious(Node node ){
        Node iterateNode = firstNode;
        while(iterateNode!=null){
            if(iterateNode.next == node)return iterateNode;
            else iterateNode = iterateNode.next;
        }
        return null;
    }
    //contains
    public boolean contains(int value){
        return indexOf(value)!=-1;
    }

    //indexof
    public int indexOf(int value){
        int index=0;
        Node iterator = firstNode;
        while(iterator!=null){
            if (iterator.value == value)
                return index;
            index++;
            iterator = iterator.next;
        }
        return -1;
    }

    public int size(){
        return length;
    }

    public int[] toArray(){
        int[] array = new int[length];
        int index=0;
        Node iterator = firstNode;
        while(iterator!=null){
            array[index++]=iterator.value;
            iterator = iterator.next;
        }
        return array;
    }

    public void reverse(){

        if(isEmpty())return;

        var prev = firstNode;
        var currentNode = firstNode.next;
        while(currentNode!=null){
           var next = currentNode.next;
           currentNode.next = prev;
           prev = currentNode;
           currentNode = next;
        }
        lastNode = firstNode;
        lastNode.next=null;
        firstNode = prev;
    }

    public int getKthFromEnd(int k){

        if(isEmpty()) throw new NoSuchElementException();
        if(k>length|| k<=0) throw new IllegalArgumentException();

        var cursor1 = firstNode;
        var cursor2 = getNFromFirst(k-1);

        while(cursor2.next!=null){
            cursor1=cursor1.next;
            cursor2=cursor2.next;
        }
        return cursor1.value;
    }

    private Node getNFromFirst(int n) {
        Node currentNode=firstNode;

        for(int i=0;i<n;i++)
            currentNode=currentNode.next;

        return currentNode;
    }
}
