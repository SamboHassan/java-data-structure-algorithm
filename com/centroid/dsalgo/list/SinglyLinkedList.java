package com.centroid.dsalgo.list;

import java.util.List;

public class SinglyLinkedList {
    private ListNode head; //main node of the singly linked list

    private static class ListNode{
        private int data; //Generic type
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }

    }

   public void display(){
        ListNode current = head;
        while (current != null){
            System.out.print(current.data + "-->");
            current = current.next;
        }
       System.out.print("null");
       System.out.println();
   }

   public int length(){
        int count = 0;
        if (head == null){
            return 0;
        }
        ListNode current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
   }

    public void insert(int value, int position){
        ListNode node = new ListNode(value);
        if (position == 1){
            node.next = head;
            head = node;
        }else {
            ListNode previous = head;
            int count = 1;
            while (count < position-1){
                previous = previous.next;
                count++;
            }

            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }

   public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
   }

   public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if (head == null){
            head = newNode;
            return;
        }
        ListNode current = head;
        while (null != current.next){
            current = current.next;
        }
        current.next = newNode;
   }





    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
//        sll.head = new ListNode(10);
//        ListNode second = new ListNode(1);
//        ListNode third = new ListNode(8);
//        ListNode fourth = new ListNode(11);
//
//        //Now we will connect them together to form chain
//        sll.head.next = second; //10-->1
//        second.next = third;//10-->1-->8
//        third.next = fourth;//10-->1-->8-->11-->null

//        sll.insertFirst(30);
        sll.insertFirst(1);
        sll.insertLast(30);
        sll.insertLast(40);
        sll.insertFirst(12);
        sll.insert(17, 2);

        sll.display();
//        System.out.println("The length of sll is: " + sll.length());
    }
}
