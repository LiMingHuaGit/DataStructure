package graph;

/**
 * @ClassName MyGraph
 * @Description: 图接口,抽象数据类型
 * @Author LiMinghua
 * @Date 2021/1/6
 * @Version V1.0
 **/
public interface MyGraph<T> {
    /**
     * 最大权值（表示无穷大）
     */
    public static final int MAX_WEIGHT = 99999;
    /**
     * 返回顶点数
     * @Description
     * @return: int
     * @auther: LiMinghua
     * @date: 2021/1/6 11:26
     */
    int vertexCount();

    /**
     * 返回顶点vi的数据元素
     * @param i 顶点
     * @return 数据元素
     */
    T get(int i);

    /**
     * 返回边的权值
     * @param i 顶点
     * @param j 顶点
     * @return E(i,j)边的权值
     */
    int getWeight(int i,int j);

    /**
     * 插入值为x的顶点，并返回顶点序号
     * @param x 顶点值
     * @return 顶点序号
     */
    int insertVertex(T x);

    /**
     *
     * 在两顶点间插入一条边
     * @param i 顶点
     * @param j 顶点
     * @param weight 权值
     */
    void insertEdge(int i,int j,int weight);

    /**
     * 删除顶点vi及其相关联的边
     * @param i 顶点序号
     */
    void removeVertex(int i);

    /**
     * 删除边E(i,j)
     * @param i 顶点
     * @param j 顶点
     */
    void removeEdge(int i,int j);

    /**
     * 返回vi在vj后的下一个邻接顶点序号
     * @param i 顶点
     * @param j 顶点
     * @return 邻接顶点序号
     */
    int getNextNeighbor(int i,int j);

    /**
     * 深度优先搜索遍历
     * @param i 出发顶点
     */
    void DFSTraverse(int i);

    /**
     * 广度优先搜索遍历
     * @param i 出发顶点
     */
    void BFSTraverse(int i);
}
