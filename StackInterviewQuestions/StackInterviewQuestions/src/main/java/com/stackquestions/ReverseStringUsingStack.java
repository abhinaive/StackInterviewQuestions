package freecodecamp.Stack;

import java.util.Stack;

public class ReverseStringUsingStack {

    public static String reverseStringUsingStack(String str){

        Stack<Character> stack = new Stack<>();

        char charArr [] = str.toCharArray();

        for(char c : charArr){
            stack.push(c);
        }

        for(int i = 0; i < charArr.length; i++){
           charArr[i]  = stack.pop();
        }

        return new String(charArr);
    }

    public static void main(String[] args) {
        System.out.println(ReverseStringUsingStack.reverseStringUsingStack("ZAMBIA"));
    }
}
