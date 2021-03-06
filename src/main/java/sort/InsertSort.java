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
            for(int j = i;j > 0 && array[j] < array[j-1];j--){
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
}
