package mylist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName MyListTest
 * @Description: TODO
 * @Author LiMinghua
 * @Date 2020/10/13
 * @Version V1.0
 **/
public class MyListTest {
    public static void main(String[] args) {
        String[] values = {"1",null,"2","3","4","5"};
        int[] a = {1,2,3,4,5,6,7};
        int[] b = {4,5,6};
        rotate(a,3);
        rotate2(a,3);

        MySeqList<String> seqList = new MySeqList<String>(values);
        seqList.insert(0,"start");
        seqList.remove(0);
        seqList.remove("5");
        System.out.println(seqList.toString());
        MyLinkedList<String> linkedList = new MyLinkedList<String>(values);
        linkedList.insert(0,"start");
        linkedList.insert("1");
        linkedList.remove(6);
        linkedList.remove("start");
        System.out.println(linkedList.toString());
        LinkedList linkedList1 = new LinkedList();
        linkedList1.offer(1);
        linkedList1.add(2);

        System.out.println(linkedList1.toString());
        System.out.println( linkedList1.poll());
        System.out.println(linkedList1.toString());
    }


    public static void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        if(k<nums.length){
            for(int i=0;i<k;i++){
                temp[i] = nums[nums.length-k+i];
            }
            System.arraycopy(nums, 0, temp, k, nums.length-k);
            System.arraycopy(temp, 0, nums, 0, nums.length);
        }else if(k>nums.length&&nums.length!=1){
            k=k%nums.length;
            for(int i=0;i<k;i++){
                temp[i] = nums[nums.length-k+i];
            }
            System.arraycopy(nums, 0, temp, k, nums.length-k);
            System.arraycopy(temp, 0, nums, 0, nums.length);
        }
    }
    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
        for(int i = 0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}
