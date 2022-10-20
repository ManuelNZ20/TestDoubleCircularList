package com.navarroze.circular;

public class DoubleCircular {
    private Node start;
    private Node end;
    
    public DoubleCircular(){
        start = end = null;
    }
    
    public boolean isEmpty(){
        return start==null;
    }
    
    public void addStart(int date)
    {
        Node newnode = new Node(date);
        if (isEmpty()) {
            start = end = newnode;
        }else{
            newnode.setNext(start);
            start.setPrevious(newnode);
            start = newnode;
            end.setNext(start);
            start.setPrevious(end);
        }
    }
    
    public String listNext(){
        String list = "";
        Node node = start;
        do {
            list += (node.getNext()!=start)?node.getDate()+" <-> ":node.getDate();
            node = node.getNext();
        } while (node!=start);
        return list;
    }
}
