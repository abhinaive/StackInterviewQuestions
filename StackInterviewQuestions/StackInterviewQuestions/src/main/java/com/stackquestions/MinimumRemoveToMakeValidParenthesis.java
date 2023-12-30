package com.stackquestions;

import java.util.Stack;

public class MinimumRemoveToMakeValidParenthesis {

    private Stack<Integer> stack;
    private Integer numberOfRemovals;

    public MinimumRemoveToMakeValidParenthesis(){
        stack = new Stack<Integer>();
        numberOfRemovals = 0;
    }


    public String minimumRemovalToMakeValidParenthesis(Character parenthesisArr [],MinimumRemoveToMakeValidParenthesis minRemoval ){

        for(int i = 0; i < parenthesisArr.length; i++){
            if(parenthesisArr[i] == '('){
                minRemoval.stack.push(i);
            }

            else if(parenthesisArr[i] == ')'){

                if(minRemoval.stack.isEmpty()){    // Case 1 : ((( ))))
                    parenthesisArr[i] = '@';       // Marker later used for removal
                }
                else{                              // Case 2 : ((( )))
                    minRemoval.stack.pop();
                }
            }

        }

        while(!minRemoval.stack.isEmpty()){    // Case3 :  (((( ))
            parenthesisArr[minRemoval.stack.peek()] = '@';
            minRemoval.stack.pop();
        }

        // Remove All Invalid parenthesis
        StringBuilder sb = new StringBuilder();

        for(int j = 0; j < parenthesisArr.length; j++){
            if(parenthesisArr[j] != '@')
                sb.append(parenthesisArr[j]);
            else
                minRemoval.numberOfRemovals++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Character parenthsisArr [] = {'(','(','(','(','(','(',')',')',')'};

        MinimumRemoveToMakeValidParenthesis minRemoval = new MinimumRemoveToMakeValidParenthesis();

        String afterRemovalStr = minRemoval.minimumRemovalToMakeValidParenthesis(parenthsisArr,minRemoval);

        System.out.println("Minimum Number Of Removals : " + minRemoval.numberOfRemovals);
        System.out.println("Final String After Removals : " + afterRemovalStr);

    }
}
