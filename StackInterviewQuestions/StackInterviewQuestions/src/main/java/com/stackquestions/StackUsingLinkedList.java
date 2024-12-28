package freecodecamp.Stack;

import java.util.EmptyStackException;

public class StackUsingLinkedList {

    private ListNode top;
    private int length;

    public class ListNode{

        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }

    }

    public StackUsingLinkedList(){
        this.top = null;
        this.length = 0;
    }

    public int lengthOfStack(){
        return this.length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void push(int data){
        ListNode newNode = new ListNode(data);
        newNode.next = top;
        top = newNode;
        length++;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int topElement = top.data;
        top = top.next;
        length--;
        return topElement;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }



    public static void main(String[] args) {

        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek()); //30

        stack.pop();

        System.out.println(stack.peek());  //20


    }
}
