package com.robosoft;
import java.util.*;

public class StackOfIntegers
    {
        private int size;
        private int[] elements;
        int top = -1;

        public StackOfIntegers()
        {
            size = 16;
            elements = new int[size];
        }

        public StackOfIntegers(int capacity)
        {
            size = capacity;
            elements = new int[capacity];
        }
        public boolean empty()
        {
            if (top == 0)
                {
                    return true;
                }
            return false;
        }
        public void push(int value)
        {
            if(top == size-1)
            {
                System.out.println("Stack overflow");
            }
            else{
                top++;
                elements[top]=value;


            }

        }
        public int peek()
        {
            return elements[top];
        }
        public int pop()
             {

                 System.out.println(elements[top]);
                 top--;

              return elements[top+1];
             }
      void display()
            {
             for(int i=0;i<=top;i++)
                 {
                     System.out.println(elements[i]);
                 }
        }
    }
