package com.demo.dsa.linked;

/**
 * @author Richard123m
 * @date 2020-03-26
 *
 *  单向链表的实现
 *
 *  单链表是链表中结构最简单的。一个单链表的节点Node分为两部分:
 *  第一部分data保存或者显示节点的信息，
 *  另一个部分存储下一个节点的地址，
 *  最后一个节点存储地址的部分指向空值。链表有一个头节点
 *
 */
public class L1_SingleLinked {

    public static void main(String[] args) {

           SingleLinkedList singleLinkedList=new SingleLinkedList();
           singleLinkedList.add("a");
           singleLinkedList.add("b");
           singleLinkedList.add("c");

        System.out.println(singleLinkedList);
        System.out.println(singleLinkedList.find("d"));
        System.out.println(singleLinkedList.delete());


    }


}


class SingleLinkedList{

    private int size;  //链表的节点数
    private Node head;  //头节点指针，节点类

    public SingleLinkedList(){
        this.size=0;
        this.head=null;
    }


    private class Node{
         private Object data;  //封装在节点中的真实数据
         private Node next; //指针，指向下一个节点

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

    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "size=" + size +
                ", head=" + head +
                '}';
    }

    /*
           特别之处在于，一般添加运算都从左到右加，即后加的在右边。
           但这里不一样。这里是从右往左加，最初的在右边，后加的在左边，后加的指针指向先前加的。
         */
    public Object add(Object data){
          Node newNode=new Node(data);

          if(size==0){  //如果是空链表
               this.head=newNode;
          }else{ //后加的在左边，并且，后加的next指针指向先前加的。即要换位。
               newNode.next=head;
               head=newNode;
          }

          this.size++;

          return head;

    }

    public  Object delete(){

        if(this.size>0){
             Object obj=head.data;
             this.head=head.next;
             size --;
             return obj;
        }else{
             return null;
        }

    }

    //查找指定的数据所对应节点
    public Node find(Object data){
        Node current=head;
        int tempsize=size;

        while (tempsize>0) {
      //  while(current!=null){
             if(data.equals(current.data)){
                  return current;
             }else{
                  current=current.next;
             }

             tempsize --;
        }

        return null;
    }

    public boolean isEmpty(){
          return size==0;
        // return head.next==null? false:true;
    }


}




