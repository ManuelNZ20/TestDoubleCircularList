package com.navarroze.circular;

public class DoubleCircular {

    private Node start;
    private Node end;

    public DoubleCircular() {
        start = end = null;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public void addStart(int date) {
        Node newnode = new Node(date);
        if (isEmpty()) {
            start = end = newnode;
        } else {
            newnode.setNext(start);
            start.setPrevious(newnode);
            start = newnode;
            end.setNext(start);
            start.setPrevious(end);
        }
    }

    public void addEnd(int date) {
        Node newnode = new Node(date);
        if (isEmpty()) {
            start = end = newnode;
        } else {
            end.setNext(newnode);
            newnode.setPrevious(end);
            end = newnode;
            end.setNext(start);
            start.setPrevious(end);
        }
    }

    public void removeStart() {
        if (!isEmpty()) {
            if (start == end) {
                start = end = null;
            } else {
                Node aux = start;
                start = start.getNext();
                start.setPrevious(end);
                end.setNext(start);
                aux.setNext(null);
                aux.setPrevious(null);
            }
        }
    }

    public void removeEnd() {
        if (isEmpty()) {
            if (start == end) {
                start = end = null;
            } else {
                Node aux = end;
                end = end.getPrevious();
                end.setNext(start);
                start.setPrevious(end);
                aux.setNext(null);
                aux.setPrevious(null);
            }
        }
    }

    public void remove(int date) {
        if (!isEmpty()) {
            Node cur = start, prev = null, aux;
            do {
                if (cur.getDate() == date) {
                    if (prev == null) {
                        if (start == end) {
                            start = end = null;
                        } else {
                            aux = start;
                            start = start.getNext();
                            end.setNext(start);
                            start.setPrevious(end);
                            aux.setNext(null);
                            aux.setPrevious(null);
                        }
                        cur = start.getNext();
                        prev = null;
                    } else {
                        aux = cur;
                        if (cur == end) {
                            end = prev;
                            end.setNext(start);
                            start.setPrevious(end);
                            cur = start;
                        } else {
                            cur = cur.getNext();
                            prev.setNext(cur);
                            cur.setPrevious(prev);
                        }
                        aux.setNext(null);
                        aux.setPrevious(null);
                    }
                } else {
                    prev = cur;
                    cur = cur.getNext();
                }
            } while (cur != start);
        }
    }

    public Node search(int date) {
        if (!isEmpty()) {
            Node n = start;
            do {
                if (n.getDate() == date) {
                    return n;
                }
                n = n.getNext();
            } while (n != start);
        }
        return null;
    }

    public void ordered() {
        if (!isEmpty()) {
            int date = 0;
            Node i = start, j = null;
            do {
                j = i.getNext();
                while (j != start) {
                    if (i.getDate() > j.getDate()) {
                        date = i.getDate();
                        i.setDate(j.getDate());
                        j.setDate(date);
                    }
                    j = j.getNext();
                }
                i = i.getNext();
            } while (i != start);
        }
    }

    public void addNodeAsc(int date) {
        Node newnode = new Node(date);
        if (isEmpty()) {
            start = end = newnode;
        } else if (newnode.getDate() < start.getDate()) {
            newnode.setNext(start);
            start.setPrevious(newnode);
            start = newnode;
            end.setNext(start);
            start.setPrevious(end);
        } else {
            Node cur = start.getNext(), prev = null;
            boolean enc = false;
            do {
                enc = newnode.getDate() < cur.getDate();
                if (enc) {
                    if (prev==null) {
                        start.setNext(newnode);
                        newnode.setPrevious(start);
                        newnode.setNext(cur);
                        cur.setPrevious(newnode);
                    }else{
                        prev.setNext(newnode);
                        newnode.setPrevious(prev);
                        newnode.setNext(cur);
                        cur.setPrevious(newnode);
                    }
                } else {
                    prev = cur;
                    cur = cur.getNext();
                }
            } while (cur != start && !enc);
            if (!enc) {
                end.setNext(newnode);
                newnode.setPrevious(end);
                end = newnode;
                end.setNext(start);
                start.setPrevious(end);
            }
        }
    }

    public String listNext() {
        String list = "";
        if (!isEmpty()) {
            Node node = start;
            do {
                list += (node.getNext() != start) ? node.getDate() + " <-> " : node.getDate();
                node = node.getNext();
            } while (node != start);
        }
        return list;
    }

    public String listPrevious() {
        String list = "";
        if (!isEmpty()) {
            Node node = end;
            do {
                list += (node.getPrevious() != end) ? node.getDate() + " <-> " : node.getDate();
                node = node.getPrevious();
            } while (node != end);
        }
        return list;
    }

}
