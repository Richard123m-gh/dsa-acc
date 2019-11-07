package com.demo.dsa.array;

import com.google.gson.internal.$Gson$Preconditions;

/**
 * @author Richard123m
 * @date 2019-09-02
 *
 * 有序数组
 *
 */
public class L2_Main {

    public static void main(String[] args) {

        L2_OrderArray orderArray=new L2_OrderArray(100);

        orderArray.insert(15);
        orderArray.insert(44);
        orderArray.insert(44);
        orderArray.insert(22);
        orderArray.insert(8);
        orderArray.insert(44);
        orderArray.insert(13);

        orderArray.display();

        System.err.println("二分查找=>"+orderArray.find(44));

       // orderArray.delete(22);

       // orderArray.display();

    }


}
