package sort;

/**
 * @ClassName BubbleSort
 * @Description: 冒泡排序
 * @Author LiMinghua
 * @Date 2021/3/4
 * @Version V1.0
 **/
public class BubbleSort {

    /**
     * @Description 冒泡排序
     * @param num 数组
     * @auther: LiMinghua
     * @date: 2021/3/4 23:36
     */
    public static void sort(int[] num){
        for(int i = num.length-1;i > 0;i--) {
            for (int j = 0; j < i; j++) {
                if (num[j] > num[j + 1]) {
                    SelectionSort.swapArray(num, j, j + 1);
                }
            }
        }
    }

    /**
     * 拆解问题，将单个冒泡动作拆解，查找当前数组最大数并交换到选定位置
     * @Description 查找当前数组最大数并交换到选定位置
     * @param num 数组
     * @param n 要交换的位置
     * @return: void
     * @auther: LiMinghua
     * @date: 2021/3/4 23:37
     */
    public static void findMax(int[] num,int n){
        for(int i = 0;i<n;i++){
            if(num[i]>num[i+1]) {
                SelectionSort.swapArray(num, i, i + 1);
            }
        }
    }


    /**
     * 拆分冒泡 外层循环，进行多次交换
     * @Description 拆分冒泡 外层循环，进行多次交换
     * @auther: LiMinghua
     * @date: 2021/3/4 23:58
     */
    public static void dismantleSort(int[] num){
//        for(int i = 0;i<num.length-1;i++){
//            findMax(num,i+1);
//        }
        for(int i = num.length-1;i>0;i--){
            findMax(num,i);
        }
    }
}
