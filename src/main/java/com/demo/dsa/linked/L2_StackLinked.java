package com.demo.dsa.linked;

/**
 * @author Richard123m
 * @date 2020-03-27
 *
 *  单向链表实现栈
 *
 *  与数组实现的区别: 增加元素时，一样；删除元素时，链表比数组快
 *
 */
public class L2_StackLinked {

    public static void main(String[] args) {

          StackSingleLinked stackSingleLinked=new StackSingleLinked();
          stackSingleLinked.push(1);
          stackSingleLinked.push(2);
          stackSingleLinked.push(3);

          System.out.println(stackSingleLinked.pop());

    }

}

class StackSingleLinked{

    private SingleLinkedList link;
    public StackSingleLinked(){
         link=new SingleLinkedList();
    }

    //压栈
    public void push(Object data){
        link.add(data);
    }

    //弹出栈顶元素
    public Object pop(){
         return link.del();
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return link.isEmpty();
    }

    //打印
    public void display(){
        link.display();
    }

}
