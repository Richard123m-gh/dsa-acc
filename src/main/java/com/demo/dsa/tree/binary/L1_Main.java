package com.demo.dsa.tree.binary;


import com.google.gson.Gson;

/**
 *    测试
 */
public class L1_Main {

    public static void main(String[] args) throws Exception{

          L1_BinaryTree bt=insert();

          System.out.println("生成的树为==>");

          Gson gson=new Gson();

          System.err.println(gson.toJson(bt.getRoot()));


          L1_Node root=bt.find(40);

          //中序遍历
          bt.midOrder(root);
          bt.preOrder(root);
          bt.afterOrder(root);


          //删除
          bt.delete(85);

        //  bt.midOrder(root);


    }


    private static L1_BinaryTree insert(){

          L1_BinaryTree bt=new L1_BinaryTree();
          bt.insert(40);  //根节点
          bt.insert(36);
          bt.insert(37);
          bt.insert(85);
          bt.insert(49);
          bt.insert(88);


          return bt;


    }


}
