package com.demo.dsa.linked;

/**
 * @author Richard123m
 * @date 2020-04-02
 *
 *  基于双端链表的双端队列
 *
 *
 */
public class L4_QueueDoubleLinkedList {

    public static void main(String[] args) {

         QueueDoubleLinkedList queue=new QueueDoubleLinkedList();
         queue.insert(1);
         queue.insert(2);

         //队列，先进先出
        System.out.println(queue.delete());


    }

}

class QueueDoubleLinkedList{

    private DoubleLinkedList doubleLinkedList;

    public QueueDoubleLinkedList(){
        doubleLinkedList=new DoubleLinkedList();
    }

    public void insert(Object data){
        doubleLinkedList.addTail(data);
    }

    public Object delete(){
        return doubleLinkedList.deleteHead();
    }

    public boolean isEmpty(){
         return doubleLinkedList.isEmpty();
    }

    public int getSize(){
        return doubleLinkedList.getSize();
    }

    public void display(){
        doubleLinkedList.display();
    }


}



