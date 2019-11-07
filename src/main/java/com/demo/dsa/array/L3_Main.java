package com.demo.dsa.array;

/**
 * @author Richard123m
 * @date 2019-09-17
 *
 * 稀疏数组的压缩
 *
 * 对大规模数组有用，成千上万
 *
 */
public class L3_Main {

    public static void main(String[] args) throws Exception{

           //未压缩
          // uncompress();

           //经过压缩,以时间换空间。时间复杂度n3
           compress();

    }


    /*
       普通解法，不压缩
       浪费内存空间，读数据的时候,效率高些，以空间换时间
     */
    private static void uncompress() throws Exception{

        long[][] arr=new long[9][7]; //构建数组,占用63个内存空间
        arr[1][1]=3;
        arr[3][0]=1;
        arr[3][1]=4;
        arr[4][2]=7;
        arr[5][5]=5;

        //遍历输出
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.err.print(arr[i][j]+"    ");
            }
            Thread.sleep(2000);
            System.out.println();

        }


    }


    private static void compress() throws Exception{

         L3_XiShuNode[] arr=new L3_XiShuNode[6];
         arr[0]=new L3_XiShuNode(9,7,5); //第一部分，记录各行列的非零的总数
         arr[1]=new L3_XiShuNode(1,1,3);
         arr[2]=new L3_XiShuNode(3,0,1);
         arr[3]=new L3_XiShuNode(3,1,4);
         arr[4]=new L3_XiShuNode(4,2,7);
         arr[5]=new L3_XiShuNode(5,5,5);

         for(int i=0;i<arr[0].getRow();i++){
             for(int j=0;j<arr[0].getCol();j++){
                 //判断当前位置 (i,j)坐标位置 有没有非零值
                 int k=0;
                 for(k=1;k<arr.length;k++){
                      if(i==arr[k].getRow() && j==arr[k].getCol()){
                          System.out.print(arr[k].getValue()+"    ");
                          k=0;
                          break;
                      }
                 }

                 if(k!=0) System.out.print("0    ");
             }
             Thread.sleep(1000);
             System.out.println();
         }


    }

}
