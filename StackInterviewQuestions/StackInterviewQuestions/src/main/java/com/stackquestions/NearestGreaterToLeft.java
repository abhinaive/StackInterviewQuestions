package com.stackquestions;

import java.util.ArrayList;
import java.util.Stack;

/*
   1. for loop is forward
   2. No need to reverse the list
*/

public class NearestGreaterToLeft {

    public static void main(String[] args) {

        ArrayList<Integer>  list = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        int arr[]  = {1, 3, 2, 4};

        for(int i = 0 ; i < arr.length ; i++){

            if(s.isEmpty())
                list.add(-1);

            if(!s.isEmpty() && arr[i] < s.peek())
                list.add(s.peek());

            if(!s.isEmpty() && arr[i] >= s.peek()){

                while(!s.isEmpty() && arr[i] >= s.peek()){
                    s.pop();
                }

                if(s.isEmpty())
                    list.add(-1);
                else
                    list.add(s.peek());
            }
            s.push(arr[i] );
        }

        for(int m : list)
            System.out.print(m + ", ");
    }
}
