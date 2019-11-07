package com.demo.dsa.array;

/**
 * @author Richard123m
 * @date 2019-09-02
 *
 *
 * 有序数组
 *
 */
public class L2_OrderArray {

    private long[] arr;
    private int nElems;

    //OrderArray的构造方法初始化数组类
    public  L2_OrderArray(int maxSize){
         arr=new long[maxSize];
         nElems=0;
    }


    //插入
    public  void insert(long data){
        //找到插入数据的位置
        int i;
        for(i=0;i<nElems;i++){
            if(arr[i]>data) break;
        }

        if(i<nElems){ //找到的位置
            for(int j=nElems;j>i;j--){  //找到的位置，其后的数据都要向后移一位
                if(j<arr.length)  arr[j]=arr[j-1];
            }

            arr[i]=data;
            nElems ++;

        }else{ //找不到
             if(nElems < arr.length)  arr[nElems]=data;
             nElems++;
        }

    }

    //遍历
    public  void display(){

         for(int i=0;i<nElems;i++){
              System.err.print(arr[i]+"  ");
         }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }


    /*
       二分查找算法
       找到返因索引值，没找到返回当前长度
     */
    public  int find(long searchData){
        int lowerBound=0;
        int upperBound=nElems-1;

        int curInt;   //对数组进行二分的时候，处在中间元素的索引值

        while (true){

            curInt=lowerBound+(upperBound-lowerBound)/2;  //防止数据过在溢出
            if(arr[curInt]==searchData){

                //因为是有序数组，因此重复是在一起的，那么找到一个数据时，因此应查看其左边是否是相同的数，如果是，继续左，如果否，那么这就是第一次出现的位置
                while (curInt>=0){   //有重复数据时
                    if(arr[curInt] != searchData) break;
                    curInt--;
                }

                if(curInt<=-1) return 0;

                return curInt+1;
            }else if(lowerBound> upperBound){  //数组中没有指定的元素
                return nElems;
            }else{
                if(arr[curInt]>searchData){
                    upperBound=curInt-1;
                }else{
                    lowerBound=curInt+1;
                }
            }
        }
    }

    //删除
    public void delete(long data){
        int i=find(data);  //二分查找
        if(i<nElems){ //找到了
            for(int j=i;j<nElems;j++){
                 arr[j]=arr[j+1];
            }
            nElems --;
        }
    }

}
