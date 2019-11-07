package com.demo.dsa.array;

/**
 * @author Richard123m
 * @date 2019-09-17
 *
 * 压缩后的稀疏数组
 *
 */
public class L3_XiShuNode {

    private int row;  //行的总数(第一部分),或行的下标(第二部分)
    private int col;   //列的总数(第一部分),或列的下标(第二部分)
    private long value; //具体的值

    public L3_XiShuNode(int row, int col, long value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "L3_XiShuNode{" +
                "row=" + row +
                ", col=" + col +
                ", value=" + value +
                '}';
    }
}
