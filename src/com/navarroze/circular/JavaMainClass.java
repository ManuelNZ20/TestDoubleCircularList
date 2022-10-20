package com.navarroze.circular;

public class JavaMainClass {

    public static void main(String[] args) {
        final int date = 0;
        DoubleCircular c1 = new DoubleCircular();
        c1.addStart(1);
        c1.addStart(2);
        c1.addStart(7);
        c1.addStart(0);
        c1.addStart(9);
        c1.addStart(9);
        c1.addEnd(9);
        c1.addEnd(8);
        c1.addEnd(5);
        c1.addEnd(9);
        System.out.println("list: " + c1.listNext());
        c1.removeStart();
        c1.removeEnd();
        c1.remove(9);
        System.out.println("list: " + c1.listNext());
        if (c1.search(date) != null) {
            System.out.println("El nodo si existe en la list");
        } else {
            System.out.println("El nodo no existe en la list");
        }
        c1.ordered();
        System.out.println("list next: " + c1.listNext());
        System.out.println("list previous: "+c1.listPrevious());
        DoubleCircular c2 = new DoubleCircular();
        c2.addNodeAsc(8);
        c2.addNodeAsc(1);
        c2.addNodeAsc(5);
        c2.addNodeAsc(0);
        c2.addNodeAsc(2);
        c2.addNodeAsc(9);
        c2.addNodeAsc(3);
        c2.addNodeAsc(6);
        c2.addNodeAsc(4);
        c2.addNodeAsc(7);
        System.out.println("list2: \n"
                + c2.listNext());
        
        DoubleCircular c3 = new DoubleCircular();
        c3.addNodeDesc(8);
        c3.addNodeDesc(1);
        c3.addNodeDesc(5);
        c3.addNodeDesc(0);
        c3.addNodeDesc(2);
        c3.addNodeDesc(9);
        c3.addNodeDesc(3);
        c3.addNodeDesc(6);
        c3.addNodeDesc(4);
        c3.addNodeDesc(7);
        System.out.println("list2: \n"
                + c3.listNext());
    }

}
