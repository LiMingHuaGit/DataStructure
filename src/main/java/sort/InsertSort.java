package sort;

/**
 * @ClassName: InsertSort
 * @ProjectName DataStructure
 * @Description: 插入排序
 * @Author minghua
 * @Date 2021/3/611:35 上午
 * @Version V1.0
 */
public class InsertSort {
    /**
     * 从数组第二位开始，每位的元素向前逐个比较排序
     * @Description 从数组第二位开始，每位的元素向前逐个比较排序
     * @param array 数组
     * @return: void
     * @auther: LiMinghua
     */
    public static void sort(int[] array){
        //从第二位开始移动数组元素
        for (int i = 1; i <array.length ; i++) {
            //向前比较
            for(int j = i;j > 0 && array[j] < array[j-1];--j){
                SelectionSort.swapArray(array,j,j-1);
            }

//            for(int j = i;j>0;j--){
//                if(array[j]<array[j-1]){
//                    //较小则交换
//                    SelectionSort.swapArray(array,j,j-1);
//                }else{
//                    //当其大于前面数组元素时则说明它已经到了正确到位置
//                    break;
//                }
//            }

        }
    }

    /**
     * @Description 优化插入排序，将元素存在tmp中，比较后大于tmp的直接后移一位，最后将tmp直接插入在正确的位置
     * @param array 数组
     */
    public static void sort1(int[] array){
        int tmp = array[1];
        for (int i = 1; i <array.length ; i++) {
            tmp = array[i];
//            int j = i - 1;
//            while (j >= 0 && array[j] > tmp)
//            {
//                array[j + 1] = array[j];
//                --j;
//            }
//            array[j + 1] = tmp;
            int j = i;
            for (;j > 0 && array[j-1] > tmp ; j--) {
                array[j] = array[j-1];
            }
            array[j] = tmp;
        }
    }

    /**
     * 希尔排序
     * @param array 数组
     */
    public static void shellSort(int[] array){
        for (int gap = 4; gap >0 ; gap/=2) {
            for (int i = gap; i <array.length ; i++) {
                //向前比较
                for(int j = i;j > gap-1 && array[j] < array[j-gap];j-=gap){
                    SelectionSort.swapArray(array,j,j-gap);
                }
            }
        }
    }
}
