/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg62;

/**
 *
 * @author omar mohamed adel elsabaawy
 */
public class Stack {

    Node top;

    public void push(int data) {
        Node node = new Node();
        node.data = data;
        node.next = null;
        node.next = top;
        top = node;
    }

    public int pop() {
        int temp = top.data;
        top = top.next;
        return temp;
    }

    public boolean IsEmpty() {
        if (top == null) {
            return true;
        } else {
            return false;
        }
    }

    public int peek() {
        return top.data;
    }
    
    public int TheIslandThatMostlyToGetStuckOn(){
        Node n = top;
        int temp = 0;
        while(n != null){
            temp = n.data;
            n = n.next;
        }
        return temp;
    }
    
}