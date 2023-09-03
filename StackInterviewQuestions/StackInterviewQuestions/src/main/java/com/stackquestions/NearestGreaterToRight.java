package com.stackquestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NearestGreaterToRight {

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> a = new ArrayList<>();

        int arr[] = {1, 3, 2, 4};

        for (int i = arr.length - 1; i >= 0; i--) {

            if (s.isEmpty()) {
                a.add(-1);
            } else if (!s.isEmpty() && s.peek() > arr[i]) {
                a.add(s.peek());
            } else if (!s.isEmpty() && s.peek() <= arr[i]) {

                while (!s.isEmpty() && s.peek() <= arr[i]) {
                    s.pop();
                }

                if (s.isEmpty())
                    a.add(-1);
                else
                    a.add(s.peek());

            }

            s.push(arr[i]);

        }

        Collections.reverse(a);

        for(int m : a){
            System.out.print(m + " ,");
        }

    }

}
