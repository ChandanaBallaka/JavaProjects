package com.robosoft;
import java.util.*;
public class Main
    {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter size");
            int size = sc.nextInt();
            StackOfIntegers st = new StackOfIntegers(size);
            System.out.println(st.empty());
             st.push(10);
             st.push(20);
            System.out.println(st.empty());
             st.push(30);
             st.display();
            System.out.println("Peak element is " + st.peek());
             System.out.println("Poping the elements");
             st.pop();
             //st.display();




        }
    }
