package com.leons.part1;

public class Array {
    private int[] array;
    private int count;
    public Array(int length){
        array = new int[length];
    }

    public void insert(int item){
        if(array.length == count){
            int[] tempArray = new int[count*2];
            System.arraycopy(array, 0, tempArray, 0, count);
            array=tempArray;
        }
        array[count++] = item;
    }

    public void insertAt(int position, int item){
        if(position>count || position<0)
            throw new IllegalArgumentException();

        if(array.length == count){
            int[] tempArray = new int[count*2];
            System.arraycopy(array, 0, tempArray, 0, count);
            array=tempArray;
        }

        for(int i=position;i==count;i++)
            array[i+1]=array[i];

        array[position] = item;
        count++;
    }

    public Array intersect(Array compareArray){
        Array intersectAr = new Array(compareArray.count);

        for(int i=0;i<count;i++)
            if(compareArray.indexOf(array[i])>=0)
                intersectAr.insert(array[i]);

        return intersectAr;

    }

    public void removeAt(int index){
        if(index<0 || index>=count)
            throw new IllegalArgumentException();
        System.arraycopy(array, index + 1, array, index, count - index);
        count--;
    }

    public int indexOf(int item){
        for(int i=0;i<count;i++)
            if(array[i]==item)
                return i;

        return -1;
    }

    public int max(){
        int max = -1;
        for(int i=0;i<count;i++)
            if(array[i]>max)
                max=array[i];

        return max;
    }
    public int[] reverse(){
        int[] reverseArray = new int[count];
        for(int i=0;i<count;i++)
            reverseArray[i]=array[count-i-1];
        return reverseArray;
    }



    public void print(){
        for (int i=0;i<count;i++)
            System.out.println(array[i]);
    }
}
