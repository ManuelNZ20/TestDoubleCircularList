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
    
    public void addEnd(int date){
        Node newnode = new Node(date);
        if (isEmpty()) {
            start = end = newnode;
        }else{
            end.setNext(newnode);
            newnode.setPrevious(end);
            end = newnode;
            end.setNext(start);
            start.setPrevious(end); 
        }
    }
    
    public void removeStart(){
        if (start==end) {
            start = end = null;
        }else{
            Node aux = start;
            start = start.getNext();
            start.setPrevious(end);
            end.setNext(start);
            aux.setNext(null);
            aux.setPrevious(null);
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
    
    public String listPrevious(){
        String list = "";
        Node node = end;
        do {
            list += (node.getPrevious()!=end)?node.getDate()+" <-> ":node.getDate();
            node = node.getPrevious();
        } while (node!=end);
        return list;
    }
    
}
