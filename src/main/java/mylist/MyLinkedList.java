package mylist;

import java.util.Arrays;
import java.util.Optional;

/**
 * @ClassName MyLinkedList
 * @Description: 链表
 * @Author LiMinghua
 * @Date 2020/10/13
 * @Version V1.0
 **/
public class MyLinkedList<T> implements MyList<T> {
    public MyNode<T> head;

    public MyLinkedList(){
        this.head = new MyNode<T>();
    }
    public MyLinkedList(T[] values){
        this();
        MyNode<T> rear = this.head;
        for (T value : values) {
            if (value != null) {
                rear.next = new MyNode<T>(value, null);
                rear = rear.next;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }

    @Override
    public int size() {
        int size=0;
        for (MyNode<T> p=this.head.next;  p!=null;  p=p.next) {
            size++;
        }
        return size;
    }

    @Override
    public boolean insert(int index, T element) {
        if (element==null) {
            throw new NullPointerException("x==null");
        }
        MyNode<T> front=this.head;
        for (int j=0;  front.next!=null && j<index;  j++)
        {
            front = front.next;
        }
        front.next = new MyNode<T>(element, front.next);
        return true;
    }

    @Override
    public boolean insert(T element) {
        return insert(Integer.MAX_VALUE, element);
    }

    @Override
    public boolean remove(int index) {
        MyNode<T> front=this.head;
        for (int j=0;  front.next!=null && j<index;  j++)
        {
            front = front.next;
        }
        if (index>=0 && front.next!=null)
        {
            T old = front.next.data;
            front.next = front.next.next;
            return true;
        }
        return false;
    }

    @Override
    public T get(int index) {
        MyNode<T> p=this.head.next;
        for (int j=0; p!=null && j<index; j++) {
            p = p.next;
        }
        return (index>=0 && p!=null) ? p.data : null;
    }

    @Override
    public boolean remove(Object element) {
        MyNode<T> front=this.head, p=front.next;
        while (p!=null && !element.equals(p.data))
        {
            front = p;
            p=p.next;
        }
        if (p!=null)
        {
            front.next = p.next;
            return true;
        }
        return false;
    }

    public T get(T element) {
        for (MyNode<T> p=this.head.next;  p!=null;  p=p.next) {
            if (element.equals(p.data))
            {
                return p.data;
            }
        }
        return (T)Optional.empty();
    }

    @Override
    public String toString() {
        StringBuilder str= new StringBuilder("MySeqList{Nodes=[");

        for (MyNode<T> p=this.head.next;  p!=null;  p=p.next)
        {   str.append(p.data.toString());
            if (p.next!=null) {
                str.append(", ");
            }
        }
        return str+"]}";
    }
}
