/*
This singly linked list taken from pg 92 of the CTCL book 
is a helper class for the questions in this chapter.
*/

public class Node{
    public Node next = null;
    public int data;

    public Node(int d){
        data = d;
    }

    public Node(int[] list){
        data = list[0];
        Node next = this;
        for(int i = 1; i < list.length; i++){
            next.next = new Node(list[i]);
            next = next.next;
        }
    }

    public void appendToTail(int d){
        Node end = new Node(d);
        Node n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }
}