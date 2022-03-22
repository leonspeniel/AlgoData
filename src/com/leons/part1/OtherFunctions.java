package com.leons.part1;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
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
}
