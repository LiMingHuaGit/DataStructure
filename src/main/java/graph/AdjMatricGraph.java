package graph;

import mylist.MySeqList;

import java.util.Arrays;

/**
 * @ClassName AdjMatricGraph
 * @Description: 邻接矩阵表示的带权图类
 * @Author LiMinghua
 * @Date 2021/1/6
 * @Version V1.0
 **/
public class AdjMatricGraph<T> {
    /**
     * 顶点集合
     */
    protected MySeqList<T> vertexList;
    /**
     * 图的邻接矩阵
     */
    protected int[][] adjMatrix;

    /**
     * 最大权值
     */
    private final int MAX_WEIGHT = 99999;

    /**
     * 构造空图
     * @param size 容量
     */
    public AdjMatricGraph(int size){
        size = Math.max(size, 10);
        //构造容量为size的空顺序表，无顶点
        this.vertexList = new MySeqList<>(size);
        this.adjMatrix = new int[size][size];
        for(int i = 0;i<size;i++){
            for(int j=0;j<size;j++){
                //边的权值为0或最大权值
                this.adjMatrix[i][j] = (i==j)?0:MAX_WEIGHT;
            }
        }
    }

    /**
     * 根据顶点和带权边构造图
     * @param vertices 顶点
     * @param edges 带权边
     */
    public AdjMatricGraph(T[] vertices, MyEdge[] edges){
        //构造空图
        this(vertices.length);
        if(vertices.length == 0){
            return;
        }
        for (T vertex : vertices) {
            insertVertex(vertex);
        }
        if(edges!=null){
            for (MyEdge edge : edges) {
                insertEdge(edge);
            }
        }
    }

    /**
     * 返回顶点顺序表元素个数
     * @return 顶点顺序表元素个数
     */
    public int vertexCount(){
        return this.vertexList.length();
    }

    /**
     * 返回指定顶点的数据元素
     * @param i 顶点序号
     * @return 数据元素
     */
    public T get(int i){
        return this.vertexList.get(i);
    }

    /**
     * 返回边E(vi,vj)的权值
     * @param i 顶点序号
     * @param j 顶点序号
     * @return 权值
     */
    public int getWeight(int i,int j){
        return this.adjMatrix[i][j];
    }

    /**
     * 插入值为x的顶点
     * @param x 顶点元素
     * @return 顶点序号
     */
    public int insertVertex(T x){
        //顶点顺序表追加元素，自动扩充值
        this.vertexList.insert(x);
        //若二维数组容量不足，扩充
        if(this.vertexCount()>this.adjMatrix.length){
            int[][] temp = adjMatrix;
            int i,j;
            //二维数组扩充2倍
            this.adjMatrix = new int[temp.length*2][temp.length*2];
            for(i=0;i<temp.length;i++){
                //复制原邻接矩阵
                for(j=0;j<temp.length;j++){
                    this.adjMatrix[i][j] = temp[i][j];
                    for(j=temp.length;j<temp.length*2;j++){
                        this.adjMatrix[i][j] = MAX_WEIGHT;
                    }
                }
            }
            //初始化扩充的邻接矩阵
            for(i=temp.length;i<temp.length*2;i++){
                for(j=0;j<temp.length*2;j++){
                    this.adjMatrix[i][j] = (i==j)?0:MAX_WEIGHT;
                }
            }
        }
        //返回插入顶点序号
        return this.vertexList.length()-1;
    }

    /**
     * 插入一条边
     * @param i 顶点
     * @param j 顶点
     * @param weight 边的权值
     */
    public void insertEdge(int i,int j,int weight){
        int n = this.vertexCount();
        if(i>=0&&i<n&&j>=0&&j<n&&i!=j&&this.adjMatrix[i][j]==MAX_WEIGHT){
            this.adjMatrix[i][j] = weight;
        }
    }
    /**
     * 插入一条边
     * @param edge 边
     */
    public void insertEdge(MyEdge edge){
        this.insertEdge(edge.start,edge.dest,edge.weight);
    }

    @Override
    public String toString() {
        return "AdjMatricGraph{" +
                "vertexList=" + vertexList +
                ", adjMatrix=" + Arrays.toString(adjMatrix) +
                ", MAX_WEIGHT=" + MAX_WEIGHT +
                '}';
    }
}
