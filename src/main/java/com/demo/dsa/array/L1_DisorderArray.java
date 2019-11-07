package com.demo.dsa.array;

/**
 * @author Richard123m
 * @date 2019-08-27
 *
 * 无序数组
 *
 */
public class L1_DisorderArray {

    private long[] arr; //被封装的数组
    private int nElems; //数组当前实际长度


    public long[] getArr() {
        return arr;
    }

    public int getnElems() {
        return nElems;
    }

    //通过数组类的构造方法初始化
    public L1_DisorderArray(int maxSize){
        //maxsize是数组的最大长度
        arr=new long[maxSize]; //初始化被封装的数组
        nElems=0;
    }

    //新增数据项
    public void insert(long data){
        arr[nElems]=data;
        nElems ++;
    }

    //查找某一特定的数据项
    public boolean find(long searchData){

        int i;
        for(i=0;i<nElems;i++){  //如果最终没找到,i==nElems
            if(searchData == arr[i]){
                 break;
            }
        }

        if(i==nElems){
            return  false;
        }else{
            return  true;
        }
    }



    public void delete(long targetDate){

         //首先找到要删除的数据
         int i;
        for(i=0;i<nElems;i++){  //如果最终没找到,i==nElems
            if(targetDate == arr[i]){
                break;
            }
        }

        if(i==nElems){
            System.out.println("没有找到被删除的数据。"+targetDate);
        }else{

            for(int j=i;j<nElems;j++){
                  arr[j]=arr[j+1];
            }
            nElems --;
        }



    }

    //遍历
    public void  display(){
        for(int i=0;i<nElems;i++){
            System.out.println(arr[i]);
        }
    }



}
