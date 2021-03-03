package test;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Stack;

/**
 * @ClassName test
 * @Description: TODO
 * @Author LiMinghua
 * @Date 2021/1/8
 * @Version V1.0
 **/
public class Ltest {
    public static void main(String[] args) {
//        HashMap<Integer, Integer> map = new HashMap();
//        System.out.println(0^1);

//        Stack<Integer> stack = new Stack<Integer>();
//        for(int i = 0;i<10;i++){
//            stack.push(i+1);
//        }
//        System.out.println(stack.toString());
//
//        System.out.println(stack.pop());
//        stack.push(1);
//        System.out.println(stack.toString());
//        System.out.println(stack.peek());


//        int k = 1;
//        k = k%10;
//        k = k/10;
//        System.out.println(k);

        int[] Dp = {2,3,4};
        int[] p = new int[10];

        int s = 6;
        //System.out.println(twoSum(p,s)[0]);
        System.out.println(LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai"))).getYear());
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] rs = new int[2];
        int length = numbers.length;
        for(int i = 0;i<length;i++){
            for(int j = i+1;j<length;j++){
                if(numbers[i]+numbers[j]==target){
                    rs[0] = ++i;
                    rs[1] = ++j;
                    return rs;
                }
            }
        }
        return rs;
    }
}
