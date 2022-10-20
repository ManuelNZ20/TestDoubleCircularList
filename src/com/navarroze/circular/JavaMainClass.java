package com.navarroze.circular;

public class JavaMainClass {

    public static void main(String[] args) {
        DoubleCircular c1 = new DoubleCircular();
        c1.addStart(2);
        c1.addStart(1);
        c1.addStart(7);
        c1.addStart(0);
        c1.addEnd(5);
        c1.addEnd(9);
        System.out.println("list: "+c1.listNext());
        System.out.println("list: "+c1.listPrevious());
    }
    
}
