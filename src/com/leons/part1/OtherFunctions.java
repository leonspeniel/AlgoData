package com.leons.part1;

import java.util.*;
import java.util.Stack;

public class OtherFunctions {

    public String reverseString(String input) {
        if (input == null) throw new IllegalArgumentException();
        var stackString  = new Stack<Character>();
        for(char a :input.toCharArray()){
            stackString.push(a);
        }

        var reveredString = new StringBuilder();

        while(!stackString.empty())
            reveredString.append(stackString.pop());


        return reveredString.toString();

    }

    public boolean stringBalanceChecker(String value){
        if(value==null || value.isEmpty())throw new IllegalArgumentException();

        var bracketMap = new HashMap<>();
        bracketMap.put(')','(');
        bracketMap.put('>','<');
        bracketMap.put(']','[');
        bracketMap.put('}','{');

        var specialStack = new Stack<>();
        for (char a : value.toCharArray()){
            if(bracketMap.containsValue(a)){
                specialStack.push(a);
            }
            if(bracketMap.containsKey(a)){
                if(specialStack.isEmpty())return false;
                char check = (char) specialStack.pop();
                char pairVal = (char) bracketMap.get(a);
                if(pairVal!=check)return false;
            }
        }

        return specialStack.empty();
    }

    public static Queue<Integer> reverseQueue(Queue<Integer> queue){
        var stack = new Stack<Integer>();

        while (!queue.isEmpty())
            stack.add(queue.remove());
        while (!stack.isEmpty())
            queue.add(stack.pop());

        return queue;
    }

    //my imp1
    /*public static char firstNonRepeatChar(String msg){
        var map = new HashMap<Character,Integer>();
        var value =msg.replace(" ","");
        var valArray = value.toCharArray();
        for(int i=0;i<valArray.length;i++){
            map.put(valArray[i],i);
        }
        System.out.println(map);
        var min = Collections.min(map.values());
        return valArray[min];
    }*/

    //with mosh
    public static char firstNonRepeatChar(String msg){
        var map = new HashMap<Character,Integer>();
        var valArray = msg.toCharArray();
        for(char ch:valArray){
            int val= map.getOrDefault(ch, 0);
            map.put(ch,val+1);
        }
        System.out.println(map);
        for (char c : valArray)
            if (map.get(c) == 1)
                return c;

        return Character.MIN_VALUE;
    }

    public static char findFirstRepeatedChar(String msg){
        var set = new HashSet<Character>();
        for(char ch : msg.toCharArray()){
            if(set.contains(ch))
                return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
