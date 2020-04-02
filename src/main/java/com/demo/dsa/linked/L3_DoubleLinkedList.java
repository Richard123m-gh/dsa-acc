package com.demo.dsa.linked;

/**
 * @author Richard123m
 * @date 2020-04-02
 *
 *
 *   双端链表
 *
 */
public class L3_DoubleLinkedList {

    public static void main(String[] args) {

        DoubleLinkedList link=new DoubleLinkedList();
        link.addHead(1);
        link.addHead(3);
        link.addTail(2);
        link.addTail(4);
        link.display();



    }


}

class DoubleLinkedList{

    private int size;    //链表的节点数
    private Node head;   //head头节点指针
    private Node tail;   //tail尾节点指针

    public DoubleLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    private class Node{
        private Object data;  //封装在节点里的数据
        private Node next;  //指针，指向下一个节点

        public Node(Object data){

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

    //在头节点添加
    public Object addHead(Object data){

         Node newNode=new Node(data);
         if(size==0){
             head=newNode;
             tail=newNode;
         }else{
             newNode.next=head;
             head=newNode;
         }

         size++;
         return newNode;

    }

    //在尾节点添加
    public Object addTail(Object data){
         Node newNode=new Node(data);
         if(size==0){
             head=newNode;
             tail=newNode;
         }else{
             tail.next=newNode;
             tail=newNode;
         }

         size++;

         return newNode;
    }


    //删除头节点
    public Object deleteHead(){

        Object obj=null;

        if(size==0){
            return obj;
        }else if(size==1){  //链表中只有一个节点
            obj=head.data;
            head=null;
            tail=null;
            size--;
        }else{
            obj=head.data;
            head=head.next;
            size--;
        }

        return obj;

    }

    public Node find(Object data){
        Node current=head;


        while(current!=null){
            if(data.equals(current.data)){
                return current;
            }else{
                current=current.next;
            }
        }

        return null;
    }

    public boolean isEmpty(){
        return head.next==null? false:true;
    }


    //删除指定节点
    public boolean delete(Object value){
        if(isEmpty()) return false;

        Node current=head;
        Node previous=head;

        while (!value.equals(current.data)){
            if(current.next==null){
                return false;
            }else{
                previous=current;
                current=current.next;
            }
        }

        if(size==1){
            head=null;
            tail=null;
        }else if(current==head){
            head=head.next;
            size--;
        }else if(current==tail){
            previous.next=null;
            tail=previous;
        }else {
            previous.next=current.next;
            size--;
        }

        return true;
    }


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

    //获取节点个数
    public int getSize(){
        return size;
    }


}




