package com.demo.dsa.tree.binary;


/**
 * @Author Richard123m
 * @Date 2019-07-30
 *
 * 二叉树的一个基本的类结构
 *
 */
public class L1_BinaryTree {

    private L1_Node root;

    public L1_Node getRoot() {
        return root;
    }

    public L1_BinaryTree(){
        root=null; //新创建的树什么也没有
    }

    //查找某个节点
    public L1_Node find(int data){
          L1_Node current=root;   //初始化，当前节点是根节点
          while(current!=null){  //当前节点不是NUll，循环

                if(data<current.getData()){
                    current=current.getLeftChild();  //如果比当前节点小，那么左移
                }else if(data > current.getData()){
                    current=current.getRightChild(); //如果比当前节点大，那么右移
                }else{
                     return  current; //如果与当前节点相等，返回
                }

          }

          //如果current=null，证明无该节点。
          return  null;

    }




    //插入节点。如果插入值比父节点大，右边；否则，左边
    public  boolean insert(int data){
         L1_Node newNode=new L1_Node(data);
         if(root==null) {
              root=newNode;
              return  true;
         }else{
             L1_Node current=root;     //初始当前节点
             L1_Node parentNode=null; //初始父节点

             while(current!=null){
                 parentNode=current;
                 if(data<current.getData()){
                      current=current.getLeftChild();
                      if(current==null){
                           parentNode.setLeftChild(newNode);
                           return true;
                      }
                 }else{
                      current=current.getRightChild();
                      if(current==null){
                           parentNode.setRightChild(newNode);
                           return true;
                      }
                 }
             }
         }

         return  false;  //理论上应该都能插入，返回false，表明插入过程异常
    }

    //中序遍历
    public void midOrder(L1_Node current){
          //先左
          if(current==null){ //递归边界条件
              return;
          }else{
              midOrder(current.getLeftChild());
              System.out.println(current.getData());
              midOrder(current.getRightChild());
          }
    }

    //前序遍历
    public void preOrder(L1_Node current){
        //先左
        if(current==null){ //递归边界条件
            return;
        }else{
            System.out.println(current.getData()); //根节点
            preOrder(current.getLeftChild());
            preOrder(current.getRightChild());
        }
    }

    //后序遍历
    public void afterOrder(L1_Node current){
        //先左
        if(current==null){ //递归边界条件
            return;
        }else{
            afterOrder(current.getLeftChild());
            afterOrder(current.getRightChild());
            System.out.println(current.getData());
        }
    }

    //求最大值与最小值.根据二叉树的特点,最小值为最左侧的节点，最大值为最右侧的节点。
    public L1_Node getMaxNode(){
         L1_Node current=root;
         L1_Node maxNode=current;
         while (current!=null){
              maxNode=current;
              current=current.getRightChild();
         }
         return maxNode;

    }

    //最小值
    public L1_Node getMinNode(){

        L1_Node current=root;
        L1_Node minNode=current;
        while (current!=null){
            minNode=current;
            current=current.getLeftChild();
        }
        return minNode;

    }





    //删除节点
    public boolean delete(int data){

        //找到要删除的节点
        L1_Node current=root;
        L1_Node parent=null;
        boolean isLeftChild=false; //当前节点是其父节点的左节点还是右节点
        while(current.getData()!=data){  //等于，则跳出循环
            parent=current;

            if(data<current.getData()){

                current=current.getLeftChild();  // 往左移
                isLeftChild=true;

            }else{
                current=current.getRightChild(); //往右移
                isLeftChild=false;
            }


            if(current==null){ // 树中没有要找的节点,该delete方法直接结束
                return  false;
            }


        }

        //正常结束循环，表示找到了要删除的节点,current


        //删除找到的节点
        if(current.getLeftChild()==null && current.getRightChild()==null){ //该节点无子节点

            if(current==root){  //只有一个节点，是根节点
                 root=null;
            }else{
                if(isLeftChild){//当前节点是其父节点的左节点
                    parent.setLeftChild(null);
                }else {
                    parent.setRightChild(null);
                }
            }


             return  true;
        }else if(current.getLeftChild()!=null && current.getRightChild()==null){ //该节点只有左节点
             if(current==root){ //只有两个节点情况下，删除根节点
                root=current.getLeftChild();
             } else {
                 if(isLeftChild){
                     parent.setLeftChild(current.getLeftChild());
                 }else{
                     parent.setRightChild(current.getLeftChild());
                 }
             }

              return  true;
        }else if(current.getLeftChild()==null && current.getRightChild()!=null){//该节点只有右节点
             if(current==root){
                 root=current.getRightChild();
             }else {
                 if(isLeftChild){
                     parent.setLeftChild(current.getRightChild());
                 }else {
                     parent.setRightChild(current.getRightChild());
                 }
             }

              return true;
        }else{  //要删除的节点有两个子节点
            //先找到要被删除节点的右子树中最小节点(右子树的最左节点)
            L1_Node replaceNOde=getReplaceNode(current);

            if(current==root){
                root=replaceNOde;
            }else{
                if(isLeftChild){
                    parent.setLeftChild(replaceNOde);
                }else {
                    parent.setRightChild(replaceNOde);
                }
            }

            replaceNOde.setLeftChild(current.getLeftChild());

            return true;

        }

       // return  false; //?出意外

    }

    //找出右子树的最左节点
    public L1_Node getReplaceNode(L1_Node delNode){
         L1_Node replaceNode=delNode;
         L1_Node replaceNodeParent=delNode;
         L1_Node grnCurrent=delNode.getRightChild();

         while (grnCurrent!=null){
              replaceNodeParent=replaceNode;
              replaceNode=grnCurrent;
              grnCurrent=grnCurrent.getLeftChild();
         }

         if(replaceNode!=delNode.getRightChild()){
             replaceNodeParent.setLeftChild(replaceNode.getRightChild());
             replaceNode.setRightChild(delNode.getRightChild());
         }


         return replaceNode;
    }


}
