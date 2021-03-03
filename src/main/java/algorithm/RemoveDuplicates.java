package algorithm;

import java.util.Arrays;

/**
 * @ClassName removeDuplicates
 * @Description: TODO
 * @Author LiMinghua
 * @Date 2021/1/16
 * @Version V1.0
 **/
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,1,2,2,3,3,4,4};
        System.out.println(removeDuplicates2(nums));
        System.out.println(Arrays.toString(nums));


    }

    public static int removeDuplicates(int[] nums) {
        int j = 0;
        int length = nums.length;
        int end = nums[length-1];
        for(int i = 0;i<length;i++){
            if(nums[i]==end){
                break;
            }
            if(nums[i]==nums[j]){
                continue;
            }
            for(int k = i;k<length;k++){
                nums[k-i+j+1] = nums[k];
            }
            j=i-(i-j-1);
        }
        return j+1;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}
