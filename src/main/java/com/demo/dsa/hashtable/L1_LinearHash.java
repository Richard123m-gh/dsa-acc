package com.demo.dsa.hashtable;

/**
 * @author Richard123m
 * @date 2020-04-14
 *
 *  基于线性探测
 *
 *
 */
public class L1_LinearHash {

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);


    }


}


//定义在hash表中保存的数据项对应的类
class DataItem{

    private int data;  //数据项中的值

    public  DataItem(int data){
         this.data=data;
    }

    //在外部获取数据值的接口
    public int getData() {
        return data;
    }

}


class MyHashTable{

    //声明hashtable中的底层的属性
    private DataItem[] hashArray;  //保存在hash表中的数据项
    private int arraySize;   //保存上面的数组的长度的属性
    private int itemNum;    //保存上面的数组中真正含有的数据项的个数
    private DataItem delItem; //表示hash表中删除的数据项

    public MyHashTable(){}


    public MyHashTable(int arraySize){
         this.arraySize=arraySize;
         hashArray=new DataItem[arraySize];
         itemNum=0;
         delItem=new DataItem(-1); //这里规定，被删除的数据项，它里面的值就是-1.
    }

    //判断数组是不是满的
    public boolean isFull(){
         return (itemNum==arraySize);
    }

    //判断是不是空的
    public boolean isEmpty(){
        return (itemNum==0);
    }

    //实现把hash表中的数据项的值，做一个打印输出。
    public void display(){
        System.out.println("hashtable:  ");
        for(int i=0;i<arraySize;i++){
              if(hashArray[i]!=null){
                  System.out.print(hashArray[i].getData()+"   ");
              }else{
                  System.out.println("***");
              }

        }
    }

    /*
         实现哈希函数
         目的：将输入大范围的key，返回为输出小范围的数.
     */
    public int hashFunction(int key){
          return key%arraySize;
    }


}




