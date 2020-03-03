package com.demo.dsa.stackQueue;

import java.util.Stack;

/**
 * @author Richard123m
 * @date 2020-03-03
 *
 *  利用栈实现字符串的逆转
 *
 */
public class L3_Stack_StrReverse {

    public static void main(String[] args) {
           String s="How are you";
           char[] sa=s.toCharArray();
           Stack<Character> stack=new Stack<>();
           for (char c:sa){
               stack.push(c);
           }

        System.out.println("正序=>"+s);
           while(!stack.isEmpty()){
               System.out.print(stack.pop());
           }



    }

}





