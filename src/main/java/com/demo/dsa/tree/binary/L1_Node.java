package com.demo.dsa.tree.binary;

/**
 * @Author Richard123m
 * @Date 2019-07-30
 */
public class L1_Node {

    private int data;
    private L1_Node leftChild;
    private L1_Node rightChild;

    public L1_Node(){}
    public L1_Node(int data){
        this.data=data;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public L1_Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(L1_Node leftChild) {
        this.leftChild = leftChild;
    }

    public L1_Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(L1_Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "L1_Node{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
