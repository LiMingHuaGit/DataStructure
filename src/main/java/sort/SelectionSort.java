package sort;

import javax.sound.midi.SoundbankResource;

/**
 * @ClassName SelectionSort
 * @Description: 选择排序
 * @Author LiMinghua
 * @Date 2021/3/2
 * @Version V1.0
 **/
public class SelectionSort {
    public static void main(String[] args) {
//        int[] array = {9,8,7,6,5,4,3,2,1};
//        selectionSort(array);
        int[] array = {8,1,3,2,4,5,6,9,7};
        print(array);
        //selectionSort1(array);
        //selectionSort(array);
        //BubbleSort.findMax(array,6);

        BubbleSort.dismantleSort(array);
        print(array);
    }

    /**
     * 每次交换最小值放在前面
     * @Description
     * @return:
     * @auther: LiMinghua
     * @date: 2021/3/3 0:07
     */
    public static void selectionSort(int[] array){
        //边界处理
        boolean ifend = false;

        for(int i = 0;i<array.length-1;i++){
            //数组每次循环的最前面位置
            int minPosition = i;
            //找出最小值位置并记录
            for(int j=i+1;j<array.length;j++){
                minPosition = array[j]<array[minPosition]?j:minPosition;
            }
            //交换
            swapArray(array,i,minPosition);

            System.out.println("第"+(i)+"次循环");
            print(array);

            //判定是否正序
            for(int k = 0;k<array.length-1;k++){
                if(array[k]<array[k+1]){
                    ifend = true;
                }else {
                    ifend = false;
                    break;
                }
            }
            //正序跳出循环
            if(ifend){
                break;
            }
        }
    }

    /**
     * 每次交换最小值和最大值
     * @Description
     * @return:
     * @auther: LiMinghua
     * @date: 2021/3/3 0:08
     */
    public static void selectionSort1(int[] array){
        //边界处理
        boolean ifend = false;

        for(int i = 0;i<array.length-1;i++){

            System.out.println("第"+(i)+"次循环");
            //数组每次循环的最前面位置
            int minPosition = i;
            //数组每次循环的最后面位置
            int maxPosition = array.length-i-1;

            //找出最小值
            for(int j=i+1;j<array.length;j++){
                minPosition = array[j]<array[minPosition]?j:minPosition;
            }
            swapArray(array,i,minPosition);
            print(array);

            //找出最大值
            for(int j=i;j<array.length-i;j++){
                maxPosition = array[j]>array[maxPosition]?j:maxPosition;
            }
            swapArray(array,array.length-i-1,maxPosition);
            print(array);

            //判定是否正序
            for(int k = 0;k<array.length-1;k++){
                if(array[k]<array[k+1]){
                    ifend = true;
                }else {
                    ifend = false;
                    break;
                }
            }
            //正序跳出循环
            if(ifend){
                break;
            }
        }
    }

    /**
     * 交换数组元素
     * @Description
     * @param array 数组
     * @param i 交换位置
     * @param j 交换位置
     * @return: void
     * @auther: LiMinghua
     * @date: 2021/3/3 0:41
     */
    public static void swapArray(int[] array, int i, int j){

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 打印数组
     * @Description
     * @return:
     * @auther: LiMinghua
     * @date: 2021/3/3 0:42
     */
    public static void print(int[] array){
        for(int i:array){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
