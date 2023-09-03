package com.stackquestions;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallestToLeft {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> s = new Stack<>();

        int arr[]  = {4,5,2,10,8};

        for(int i = 0 ; i < arr.length ; i++){

            if(s.isEmpty())
                list.add(-1);

            else if(!s.isEmpty() && arr[i] > s.peek())
                list.add(s.peek());

            else if(!s.isEmpty() && arr[i] <= s.peek()){

                while(!s.isEmpty() && arr[i] <= s.peek()){
                    s.pop();
                }

                if(s.isEmpty())
                    list.add(-1);
                else
                    list.add(s.peek());
            }
            s.push(arr[i]);
        }

        for(int m : list)
            System.out.print(m + ", ");
    }
}
