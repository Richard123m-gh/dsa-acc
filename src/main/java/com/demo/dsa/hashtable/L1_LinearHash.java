package com.demo.dsa.hashtable;

import sun.jvm.hotspot.jdi.CharValueImpl;

/**
 * @author Richard123m
 * @date 2020-04-14
 *
 *  基于线性探测的哈希表
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


    //插入数据
    public void insert(DataItem item){

         //1. 如果hash表满了,对hash表进行扩容
         if(isFull()){
             System.out.println("哈希表已经满了,进行扩容.");

         }

         int data=item.getData();  //取出数值

         //对data进行哈希化
         int hashval=hashFunction(data);//目的是用这个hash值来做未保存数值的index

         //条件即表示该位置被占用
         while (hashArray[hashval]!=null && hashArray[hashval].getData()!=-1){
              //进行线性探索,查找下面相邻的空位
              hashval ++;
              hashval=hashval % arraySize;  //hash值加1后,再进行哈希化
         }

         //while循环正常结束，表示找到了空位置
         hashArray[hashval]=item;
         itemNum++;


    }



    /*
        扩容
        不能将原数组的数据项，直接复制到新数组的相同位置上。

     */
    private void  extend(){

          int num=arraySize;  //原数组的长度临时保存
          itemNum=0; //对hash中保存的数据项个数重新计数
          arraySize=arraySize*2; //将原数组扩2倍
          DataItem[] oldDataItemArr=hashArray;  //把原数组的数据也临时保存
          hashArray=new DataItem[arraySize];
          for(int i=0;i<num;i++){
              insert(oldDataItemArr[i]);
          }


    }


    //删除
    public DataItem delete(int data){
         if(isEmpty()){
             System.out.println("哈希表为空");
             return null;
         }else {
             //删除之前都是查找，先查找要删除的目标
             int hashval=hashFunction(data);
             while (hashArray[hashval]!=null){
                  if(hashArray[hashval].getData()==data){
                        //找到要删除的目标
                        DataItem temp=hashArray[hashval];
                        hashArray[hashval]=delItem; //真正的删除动作
                        itemNum --;
                        return temp;
                  }

                 hashval++;
                 //探测
                 hashval=hashval%arraySize;
             }

             return null; //表示,哈希表里没有要删除的目标数据项，什么都没有删除。


         }


    }


}




