package com.demo.dsa.array;

/**
 * @author Richard123m
 * @date 2019-08-27
 *
 * 测试无序数组
 *
 */
public class L1_Main {

    public static void main(String[] args) {

        L1_DisorderArray array=new L1_DisorderArray(100);

        //新增数据
        array.insert(11);
        array.insert(12);
        array.insert(13);
        array.insert(14);
        array.insert(15);


        //删除
        array.delete(13);

        System.out.println(array.find(14));


        //遍历
        array.display();



    }


}
