/*
2.1 Remove Dups: Write code to remove duplicates from an unsorted linked list.  
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
*/
import java.util.*;

public class RemoveDuplicates{

    public static void removeDuplicates(Node head){
        Set<Integer> nodes = new HashSet<>();
        Node runner = null;
        Node fastRunner = head;
        while(fastRunner != null){
            if(nodes.contains(fastRunner.data)){
                runner.next = runner.next.next;
            }else{
                nodes.add(fastRunner.data);
                runner = fastRunner;
            }
            fastRunner = fastRunner.next;
        }
    }

    public static void unitTest(int[] linkedList){
        Node head = new Node(linkedList);
        Node runner = head;
        System.out.println("LinkedList before removing duplicates:");
        while(runner != null){
            System.out.print(runner.data + ",");
            runner = runner.next;
        }
        System.out.println();
        removeDuplicates(head);
        runner = head;
        System.out.println("LinkedList after removing duplicates:");
        while(runner != null){
            System.out.print(runner.data + ",");
            runner = runner.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        unitTest(new int[]{1, 2, 3, 4, 5, 1, 2, 3});
    }
}