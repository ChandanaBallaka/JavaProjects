package com.robosoftin;

public class StackOfIntegers
    {
        int[] element;
        private int size;

        int index=0;
        public StackOfIntegers()
            {
                element=new int[16];
                size=16;
            }

        public StackOfIntegers(int capacity)
            {
                element=new int[capacity];
                size=capacity;
            }

        public int[] getElement() {
            return element;
        }

        public void setElement(int[] element) {
            this.element = element;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size)
            {
                this.size = size;
            }




        boolean empty()
            {
                if(element.length==0)
                {
                    System.out.println("Stack is empty");
                }
                return true;
            }
        public int peek()
             {
                 return element[index];
             }
        public void push(int value){
        if(index>=size){
            System.out.println("stack overflow");
            return;
        }
        element[index]=value;
        index++;

        }

        public void pop(){
            int[] nw = new int[size];
            for(int i=0;i<index-1;i++){
                nw[i]=element[i];
            }
            element=nw;
            index--;
        }
    }
