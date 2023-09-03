package com.stackquestions;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MaxAreaHistogram {

    private static Stack<Node> barGraphStack;

    public MaxAreaHistogram() {
        barGraphStack = new Stack<>();
    }

    static class Node {

        private int val;
        private int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public static void main(String[] args) {

        int histograph[] = {6, 2, 5, 4, 5, 1, 6};
        int maxAreaHistogram = 0;


        int[] leftArray = nearestSmallestToLeftList(histograph).stream().mapToInt(i -> i).toArray();
        int[] rightArray = nearestSmallestToRightList(histograph).stream().mapToInt(i -> i).toArray();
        int width [] = new int[histograph.length];
        int area  [] = new int[histograph.length];

        for(int k = 0; k < histograph.length ; k++){
            width[k] = rightArray[k] - leftArray[k] -1 ;
        }

        for(int l = 0; l < histograph.length ; l++){
            area[l] = width[l]*histograph[l];

            if(maxAreaHistogram < area[l])
                maxAreaHistogram = area[l];
        }

        System.out.println("Max Area of Histogram is :" + maxAreaHistogram);

    }

    public static ArrayList<Integer> nearestSmallestToLeftList(int arr[]) {

        int pseudoIndex = -1;

        ArrayList<Integer> left = new ArrayList<>();

        Stack<Node> s1 = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            if (s1.isEmpty())
                left.add(pseudoIndex);

            else if (!s1.isEmpty() && arr[i] > s1.peek().val)
                left.add(s1.peek().index);

            else if (!s1.isEmpty() && arr[i] <= s1.peek().val) {

                while (!s1.isEmpty() && arr[i] <= s1.peek().val) {
                    s1.pop();
                }

                if (s1.isEmpty())
                    left.add(pseudoIndex);
                else
                    left.add(s1.peek().index);
            }
            s1.push(new Node(arr[i], i));
        }

        System.out.print("Nearest Smallest to Left Array ");
        for (int m : left)
            System.out.print(m + ", ");

        System.out.println();

        return left;
    }


    public static ArrayList<Integer> nearestSmallestToRightList(int arr[]) {

        int pseudoIndex = 7;

        ArrayList<Integer> right = new ArrayList<>();

        Stack<Node> s2 = new Stack<>();

        for (int i = arr.length -1 ; i >= 0; i--) {

            if (s2.isEmpty())
                right.add(pseudoIndex);

            else if (!s2.isEmpty() && arr[i] > s2.peek().val)
                right.add(s2.peek().index);

            else if (!s2.isEmpty() && arr[i] <= s2.peek().val) {

                while (!s2.isEmpty() && arr[i] <= s2.peek().val) {
                    s2.pop();
                }

                if (s2.isEmpty())
                    right.add(pseudoIndex);
                else
                    right.add(s2.peek().index);
            }
            s2.push(new Node(arr[i], i));
        }

        Collections.reverse(right);

        System.out.print("Nearest Smallest to Right Array ");
        for (int n : right)
            System.out.print(n + ", ");

        System.out.println();



        return right;
    }

}
