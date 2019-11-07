package com.demo.dsa.answer;


/*
    将有序数组转为二叉树
 */
public class L2_ArrayToTree {

    public static void main(String[] args) {

         int[] arr={1,2,3,4,5,6,7,8};

        System.out.println(gen(arr));


    }

    private static Node gen(int[] arr){
        if(arr==null) return null;

        return generate(arr,0,arr.length-1);
    }

    private static Node generate(int[] arr,int low,int high){

         if(low>high) return null;

         int mid=(low+high)/2;

         Node head=new Node(arr[mid]);
         head.setLeft(generate(arr,low,mid-1));
         head.setRight(generate(arr,mid+1,high));

         return head;
    }



}

class Node{

    private int data;
    private Node left;
    private Node right;

    public Node(int data){
        this.data=data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
