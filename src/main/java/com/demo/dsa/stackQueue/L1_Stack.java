package com.demo.dsa.stackQueue;

/**
 * @author Richard123m
 * @date 2020-03-01
 *
 *   实现简单的栈
 *
 *   用数组来实现，也可以用链表
 *
 *   产生的问题:
 *   - 不能自动扩容, 改由链表实现
 *   - 不能存不同类型的数据
 *
 *
**/
public class L1_Stack {

    public static void main(String[] args) {

           LowerStack lowerStack=new LowerStack(3);
           lowerStack.push(1);
           lowerStack.push(2);
           lowerStack.push(3);

        System.out.println("栈顶元素 => "+lowerStack.peek());

        while (!lowerStack.isEmpty()){
            System.err.println("pop => "+lowerStack.pop());
        }


    }

}

class LowerStack{

    private long[] elemDataArray; //栈的内部封装的数组，用来保存压入栈的数据元素
    private int  maxSize;  //栈的最大长度
    private int topPointer;  //栈顶指针，始终指向栈顶上的第一个元素。栈是空栈，默认值为-1

    /*
        通过构造方法，初始化栈
        size 指定栈的最大长度
     */
    public LowerStack(int size){

        this.maxSize=size;
        elemDataArray=new long[size];
        topPointer=-1;
    }

    //实现压栈
    public void push(long data){
        //如果栈还没有满
        if(topPointer < (maxSize-1)){
            elemDataArray[++topPointer]=data;
        }
    }

    //实现出栈
    public long pop(){
        return elemDataArray[topPointer--];
    }

     //读栈顶元素
    public long peek(){
        return elemDataArray[topPointer];
    }

    //判断是否为空栈
    public boolean isEmpty(){
        return (topPointer==-1);
    }

    public boolean isFull(){
        return topPointer==maxSize-1;
    }

}



