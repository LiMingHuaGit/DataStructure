package mylist;

/**
 * @ClassName MyNode
 * @Description: 单链表节点
 * @Author LiMinghua
 * @Date 2020/10/13
 * @Version V1.0
 **/
public class MyNode<T> {
    public T data;
    public MyNode<T> next;

    public MyNode(T data,MyNode<T> next){
        this.data = data;
        this.next = next;
    }
    public MyNode(){
        this(null,null);
    }

    @Override
    public String toString() {
        return "MyNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
