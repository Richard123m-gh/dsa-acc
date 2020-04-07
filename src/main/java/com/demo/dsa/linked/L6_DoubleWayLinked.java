package com.demo.dsa.linked;

/**
 * @author Richard123m
 * @date 2020-04-07
 *
 * 双向链表
 * 与双端链表比较,双向链表有两个指针:next、prev，而双端链表只有一个指针:next。因此双向链表可以反向遍历。
 *
 */
public class L6_DoubleWayLinked {

    public static void main(String[] args) {

    }

}


class DoubleWayLinked{

    private int size;
    private Node head;
    private Node tail;

    public DoubleWayLinked(){
         size=0;
         head=null;
         tail=null;
    }

    private class Node {
        private Object data;  //封装在节点里的数据
        private Node next;  //指针，指向下一个节点
        private Node prev;  //指针，指向上一个节点

        public Node(Object data) {

            this.data = data;

        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    ", prev=" + prev +
                    '}';
        }
    }


    //在头部增加
    public Object addHead(Object data){

        Node newNode=new Node(data);
        if(size==0){
            head=newNode;
            tail=newNode;
            newNode.next=null;
            newNode.prev=null;
        }else{

            newNode.next=head;
            newNode.prev=null;
            head.prev=newNode;
            head=newNode;
        }

        size++;
        return newNode;
    }

    //尾部增加节点
    public Object addTail(Object data){
        Node newNode=new Node(data);
        if(size==0){
            head=newNode;
            tail=newNode;
            newNode.next=null;
            newNode.prev=null;
        }else{
            tail.next=newNode;
            newNode.prev=tail;
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
            head.prev=null;
            size--;
        }

        return obj;

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
            head.prev=null;
            size--;
        }else if(current==tail){
            previous.next=null;
            tail=previous;
        }else {
            previous.next=current.next;
            current.next.prev=previous;
            size--;
        }

        return true;
    }


}











