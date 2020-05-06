package com.demo.dsa.graph;

import java.util.ArrayDeque;

/**
 * @author Richard123m
 * @date 2020-05-06
 *
 * 有向图的拓扑排序
 *
 *
 */
public class L3_GraphTopo {

    //属于图,这种数据结构的基本的属性
    private L1_Vertex[] vertexList;   //保存的顶点的数组
    private int[][] adjMat; //邻接矩阵，保存边
    private int nVerts; //图中的存在的顶点的计数器
    private ArrayDeque stack; //实现深度优先搜索用的栈
    private ArrayDeque queue; //实现广度优先搜索的队列
    private final int MAX_VERTS=16;   //初始化一个图中顶点的最大的个数
    private char[] sortedArray;  //增加一个属性，保存拓排序后的结果


    public L3_GraphTopo(){
        this.vertexList=new L1_Vertex[this.MAX_VERTS];
        this.adjMat=new int[this.MAX_VERTS][this.MAX_VERTS];
        for(int i=0;i<this.MAX_VERTS;i++){
            for(int j=0;j<this.MAX_VERTS;j++){
                adjMat[i][j]=0;
            }
        }

        this.nVerts=0;

        this.stack=new ArrayDeque();
        this.queue=new ArrayDeque();
        this.sortedArray=new char[MAX_VERTS];
    }


    //向图中插入新的元素
    public void insert(char label){
        vertexList[nVerts++]=new L1_Vertex(label);
    }

    /**
     *
     * @param start  开始的节点
     * @param end    结束的节点
     *
     *   有了顶点后，更新边，设置哪个顶点与哪个顶点是连接的
     *
     */
    public void addEdge(int start,int end){

        //这里为有向图，一个边从头到尾，以及从尾到头为两个边
        adjMat[start][end]=1;

    }

    //输出指定顶点中的label值
    public void displayVertext(int index){
        System.out.println(vertexList[index].label);
    }

    //topo排序
    public void topo(){

        int orig_nverts=nVerts;
        while (nVerts>0){

            //找到没有进一步的邻接顶点的顶点,找到了返回目标顶点的下标，没找到返回-1.
            int currentVert=noSuccessors();
            if(currentVert==-1){
                System.err.println("图中出现环形，不能进行topo排序。");
                break;
            }

            sortedArray[nVerts-1]=vertexList[currentVert].label;

            //把放进到结果数组的顶点，从图中删除
            deleteVertex(currentVert);

        }


        //把排序的结果做一个输出
        System.out.println("topo排序的结果:");
        for(int i=0;i<orig_nverts;i++){
            System.out.print(sortedArray[i]+"  ");
        }



    }

    //邻接表
    private int noSuccessors(){

        boolean isAim=false;  //是否为要找的目标
        for(int row=0;row<nVerts;row++){
            isAim=true;  //循环初始化
            for(int col=0;col<nVerts;col++){
                 if(adjMat[row][col]==1){
                     isAim=false;
                     break;
                 }
            }

            if(isAim){
                return row; //实质返回了目标顶点的下标
            }

        }

        return -1;
    }



    private void deleteVertex(int delV){

         if(delV!=nVerts-1){  //要删除的顶点不在数组的末尾
              //删除它，实质上就是把后面的全部元素向前移动一位
              for(int i=delV;i<delV;i++){
                   vertexList[i]=vertexList[i+1];
              }

              //更新邻接矩阵，删掉行的下一行向上移
              for(int row=delV;row<nVerts-1;row++){
                    moveRowUp(row,nVerts);
              }



             //更新邻接矩阵，删掉列的下一列向左移
             for(int col=delV;col<nVerts-1;col++){
                  moveColLeft(col,nVerts);
             }


         }

         //完成后节点删除后，用来保存顶点个数的nVerts要减一
         nVerts--;

    }


    private void moveRowUp(int row,int length){

         for(int col=0;col<length;col++){
              adjMat[row][col]=adjMat[row][col+1]; //将下行的数据赋给上一行
         }
    }


    private void moveColLeft(int col,int length){

         for(int row=0;row<length;row++){
              adjMat[row][col]=adjMat[row][col+1];
         }

    }



}
