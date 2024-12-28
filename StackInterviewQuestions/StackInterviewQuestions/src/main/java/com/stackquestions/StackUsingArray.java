package freecodecamp.Stack;

import java.util.EmptyStackException;

public class StackUsingArray {

    private int[] arr;
    private int top;

    public StackUsingArray(){           // Default size of stack
        top = -1;
        arr = new int[10];
    }

    public StackUsingArray(int capacity){    // Customised size of stack
      this.top = -1;
      arr = new int[capacity];
    }

    public boolean isEmpty(){
        return top < 0;
    }

    public boolean isFull(){
        return (arr.length == sizeofStack());
    }

    public int sizeofStack(){
        return top + 1;
    }

    public void push(int data){
        if(isFull())
            throw new RuntimeException("Stack is Full !!!");

        top++;
        arr[top] = data;
    }

    public int pop(){
        if(isEmpty())
            throw new EmptyStackException();
        int poppedElement = arr[top];
        top--;

        return poppedElement;
    }

    public int peek(){
        if(isEmpty())
            throw new EmptyStackException();

        return arr[top];
    }

    public static void main(String[] args) {

        StackUsingArray stack = new StackUsingArray();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek()); //30

        stack.pop();

        System.out.println(stack.peek());  //20
        
    }
}
