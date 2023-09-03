package com.stackquestions;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpanProblem {

    private static Stack<Node> stack;

    public StockSpanProblem() {
        stack = new Stack<>();
    }

    static class Node {
        private int stockPrice;
        private int nearestGreaterIndex;

        public Node(int stockPrice, int nearestGreaterIndex) {
            this.stockPrice = stockPrice;
            this.nearestGreaterIndex = nearestGreaterIndex;
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        StockSpanProblem priceData = new StockSpanProblem();

        int arr[] = {100, 80, 60, 70, 60, 75, 85};

        for (int i = 0; i < arr.length; i++) {

            if (priceData.stack.isEmpty())
                list.add(-1);

            if (!priceData.stack.isEmpty() && arr[i] < priceData.stack.peek().stockPrice)
                list.add(priceData.stack.peek().nearestGreaterIndex);

            if (!priceData.stack.isEmpty() && arr[i] >= priceData.stack.peek().stockPrice) {


                while (!priceData.stack.isEmpty() && arr[i] >= priceData.stack.peek().stockPrice) {
                    stack.pop();
                }

                if (priceData.stack.isEmpty())
                    list.add(-1);
                else
                    list.add(priceData.stack.peek().nearestGreaterIndex);
            }
            priceData.stack.push(new Node(arr[i],i));
        }

        for (int m = 0 ; m < list.size(); m++)
            System.out.print(m-list.get(m) + ", ");  // 1, 1, 1, 2, 1, 4, 6,
    }

}





