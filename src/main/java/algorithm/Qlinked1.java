package algorithm;



/**
 * @ClassName Qlinked1
 * @Description: TODO
 * @Author LiMinghua
 * @Date 2021/1/4
 * @Version V1.0
 **/
public class Qlinked1 {

    public static void main(String[] args) {
        //如果不使用rear直接用head会使头节点丢失，rear只起到标识指针的作用，head则用来留存头节点的位置
        //head -> 头节点的引用 ,new Node<Integer>(null,null)-> 创建头节点
        Node head = new Node<Integer>(1,null);
        //rear -> 头节点的引用,即指向头节点（存放堆中地址），本身存储在堆栈中
        Node rear = head;
        for(int i=2;i<9;i++){
            //rear.next-> 下一个节点的引用，指向新创建的对象
            rear.next = new Node(i,null);
            //将rear指向下一个对象
            rear = rear.next;
        }
        for (Node p = head; p!=null; p=p.next)
        {
            System.out.println(p.item);
        }
        System.out.println("_________________");

        Node revers = reverseList(head);

        for (Node p = revers; p!=null; p=p.next)
        {
            System.out.println(p.item);
        }

        System.out.println("_________________");

        Node revers2 = reverse(revers,3);

        for (Node p = revers2; p!=null; p=p.next)
        {
            System.out.println(p.item);
        }
        System.out.println("_________________");

        Node revers3 = reverse2(revers2,3);

        for (Node p = revers3; p!=null; p=p.next)
        {
            System.out.println(p.item);
        }
    }



    public static Node<Integer> reverseList(Node<Integer> head){
        if(head == null ||head.next == null){
            return head;
        }
        Node<Integer> newList = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newList;
    }

    /**
     *
     * @Description 给定一个单链表的头节点 head,实现一个调整单链表的函数，使得每K个节点之间为一组进行逆序，并且从链表的头部开始组起，头部剩余节点数量不够一组的不需要逆序。
     * @param paramList 初始链表
     * @param k 分组间隔长度
     * @return: java.util.LinkedList
     * @auther: LiMinghua
     * @date: 2021/1/4 20:42
     */
    public static Node reverse(Node paramList, int k){
        Node temp = paramList;
        for(int i =1;i<k&& temp!= null;i++){
            temp = temp.next;
        }
        if(temp == null){
            return paramList;
        }
        Node temp2 = temp.next;
        temp.next = null;
        Node newHead = reverseList(paramList);
        Node newTemp = reverse(temp2,k);
        paramList.next = newTemp;
        return newHead;

    }

    /**
     *
     * @Description 给定一个单链表的头节点 head,实现一个调整单链表的函数，使得每K个节点之间为一组进行逆序，并且从链表的尾部开始组起，头部剩余节点数量不够一组的不需要逆序。
     * @param paramList 初始链表
     * @param k 分组间隔长度
     * @return: java.util.LinkedList
     * @auther: LiMinghua
     * @date: 2021/1/4 20:42
     */
    public static Node reverse2(Node paramList, int k){
        Node reversParam = reverseList(paramList);

        Node temp = reversParam;
        for(int i =1;i<k&& temp!= null;i++){
            temp = temp.next;
        }
        if(temp == null){
            return paramList;
        }
        Node temp2 = temp.next;
        temp.next = null;
        Node newHead = reverseList(reversParam);
        Node newTemp = reverse(temp2,k);
        reversParam.next = newTemp;
        return reverseList(newHead);
    }

}

class Node<E> {
    public E item;
    public Node<E> next;

    public Node( E element, Node<E> next) {
        this.item = element;
        this.next = next;
    }
    public Node(){
        this(null,null);
    }
}

