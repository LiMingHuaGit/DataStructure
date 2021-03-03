package graph;

/**
 * @ClassName MyEdge
 * @Description: 带权值的边
 * @Author LiMinghua
 * @Date 2021/1/6
 * @Version V1.0
 **/
public class MyEdge implements Comparable<MyEdge> {
    /**
     * 边的起点序号，终点序号，权值
     */
    public int start,dest,weight;

    /**
     * 构造器
     * @param start 边的起点序号
     * @param dest 终点序号
     * @param weight 权值
     */
    public MyEdge(int start,int dest,int weight){
        this.start = start;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "MyEdge{" +
                "start=" + start +
                ", dest=" + dest +
                ", weight=" + weight +
                '}';
    }

    /**
     * 起点不相同时，返回起点的差值，起点相同时，返回终点的差值
     * @param o 要比较的边
     * @return 起点或终点的差值
     */
    @Override
    public int compareTo(MyEdge o) {
        if(this.start!=o.start){
            return this.start -o.start;
        }
        return this.dest - o.dest;
    }
}
