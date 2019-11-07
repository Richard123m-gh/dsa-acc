package com.demo.dsa.tree.redblack;

public class L1_Node {

    private int data;
    private L1_Node leftChild;
    private L1_Node rightChild;
    private boolean color; //添加颜色属性 true红，false黑
    private L1_Node parent; //该节点的父节点


    public L1_Node(){}

    public L1_Node(int data){
        this.data=data;
    }

    public L1_Node(boolean color,int data, L1_Node leftChild, L1_Node rightChild, L1_Node parent) {
        super();
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.color = color;
        this.parent = parent;
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

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public L1_Node getParent() {
        return parent;
    }

    public void setParent(L1_Node parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "L1_Node{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                ", color=" + color +
                ", parent=" + parent +
                '}';
    }
}
