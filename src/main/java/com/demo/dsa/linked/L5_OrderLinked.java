package com.demo.dsa.linked;

import com.sun.tools.corba.se.idl.constExpr.Or;

/**
 * @author Richard123m
 * @date 2020-04-06
 *
 *  有序单向链表
 *
 */
public class L5_OrderLinked {

    public static void main(String[] args) {

         OrderLinkedList orderLinkedList=new OrderLinkedList();
         orderLinkedList.insert(10);
         orderLinkedList.insert(2);
         orderLinkedList.insert(8);

         orderLinkedList.display();



    }
}

class OrderLinkedList{

    private Node head;
    private int size;

    private class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data=data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public OrderLinkedList(){
        head=null;
        size=0;
    }

    //插入
    public void insert(int data){
        Node newNode=new Node(data);
        Node previous=null;
        Node current=head;

        while (current!=null && data > current.data){
            previous=current;
            current=current.next;
        }


        if(previous==null){ //如果插入的数，比头节点还小
            head=newNode;
            head.next=current;
        }else{
            newNode.next=current;
            previous.next=newNode;
        }

        size++;

    }

    //删除头节点
    public int deleteHead(){
        int headData=head.data;
        head=head.next;
        size--;
        return headData;
    }

    //遍历输出所有的node信息
    public void display(){
        if(size>0){
            Node current=head;
            int tmpsize=size;
            if(tmpsize>1){

                for(int i=tmpsize;i>0;i--){
                    if(current==head) {
                        System.out.print("["+current.data+" -> ");
                    }else if(current.next==null){
                        System.out.println(current.data+"]");
                    }else{
                        System.out.print(current.data+" -> ");
                    }
                    current=current.next;
                }

                System.out.println("********");

            }else {
                System.out.println("["+head+"]");
            }

        }else{  //空链表
            System.out.println("[]");
        }
    }







}


