package mylist;

/**
 * @ClassName MyList
 * @Description: 线性表
 * @Author LiMinghua
 * @Date 2020/10/13
 * @Version V1.0
 **/
public interface MyList<T> {

    /**
     * 判断List是否为空
     *
     * @return: boolean
     * @auther: LiMinghua
     * @date: 2020/10/13 10:16
     */
    public boolean isEmpty();

    /**
     * 返回List长度
     *
     * @return: List长度
     * @auther: LiMinghua
     * @date: 2020/10/13 10:17
     */
    public int size();

    /**
     * 按位插入
     *
     * @param index 下标
     * @param element 元素
     * @return: boolean
     * @auther: LiMinghua
     * @date: 2020/10/13 10:41
     */
    public boolean insert(int index,T element);

    /**
     * 尾插
     *
     * @param element 元素
     * @return: boolean
     * @auther: LiMinghua
     * @date: 2020/10/13 10:19
     */
    public boolean insert(T element);

    /**
     * 按位删除
     *
     * @param index 下标
     * @return: boolean
     * @auther: LiMinghua
     * @date: 2020/10/13 10:23
     */
    public boolean remove(int index);

    /**
     * 按值删除
     *
     * @param element 元素值
     * @return: boolean
     * @auther: LiMinghua
     * @date: 2020/10/13 10:23
     */
    public boolean remove (T element);

    /**
     * 按位查找
     *
     * @param index 下标
     * @return: T
     * @auther: LiMinghua
     * @date: 2020/10/13 10:25
     */
    public T get(int index);
}
