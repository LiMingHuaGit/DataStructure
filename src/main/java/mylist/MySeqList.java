package mylist;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @ClassName MySeqList
 * @Description: 顺序表
 * @Author LiMinghua
 * @Date 2020/10/13
 * @Version V1.0
 **/
public class MySeqList<T> implements MyList<T>{

    private Object[] elements;
    private int num;

    public MySeqList(int length){
        this.elements = new Object[length];
        this.num = 0;
    }

    public MySeqList(){
        this(5);
    }

    public MySeqList(T[] values){
        int nullNum = 0;
        for(int i = 0;i < values.length; i++){
            if(values[i] == null){
                nullNum++;
            }
        }
        this.elements = new Object[values.length-nullNum];

        int differ = 0;
        for(int i = 0;i < values.length; i++){
            if(values[i] != null){
                elements[i-differ] = values[i];
                this.num++;
            }else{
                differ++;
            }
        }
        this.num = elements.length;
    }

    public void  apacity(){
        Object[] newElements = new Object[this.elements.length*2];
        System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);
        this.elements = newElements;
    }

    @Override
    public String toString() {
        return "MySeqList{" +
                "elements=" + Arrays.toString(elements) +
                ", num=" + num +
                '}';
    }

    @Override
    public boolean isEmpty() {
        return this.num==0;
    }

    @Override
    public int size() {
        return this.num;
    }

    @Override
    public boolean insert(int index, T element) {
        if(element == null){
            throw new NullPointerException();
        }
        if(index < 0 || index >this.num){
            throw new IndexOutOfBoundsException();
        }
        if(index>=this.elements.length || this.num+1>this.elements.length){
            apacity();
        }
        if(index == this.num){
            this.elements[index] = element;
            this.num++;
            return true;
        }

        Object[] trans = this.elements;
        for(int i=0;i<index-1;i++){
            this.elements[i] = trans[i];
        }
        for(int j=this.num-1;j>=index;j--){
            this.elements[j+1] = trans[j];
        }
        this.elements[index] = element;
        this.num++;
        return true;
    }

    @Override
    public boolean insert(T element) {
        insert(this.num,element);
        return true;
    }


    @Override
    public boolean remove(int index) {
        if(index<0||index>this.elements.length){
            throw new IndexOutOfBoundsException();
        }
        if(index>this.num){
            throw new NoSuchElementException();
        }
        if(index == this.num-1){
            this.elements[num-1] = null;
            this.num--;
            return true;
        }
        Object[] trans = this.elements;
        for(int i=0;i<index;i++){
            this.elements[i] = trans[i];
        }
        for(int i= index;i<this.num-1;i++){
            this.elements[i] = trans[i+1];
            this.elements[i+1] = null;
        }
        this.num--;
        return true;
    }


    @Override
    public boolean remove(Object element) {
        Object[] trans = this.elements;
        for(int i =0;i<num;i++){
            if(this.elements[i].equals(element)){
                if(i==this.num-1){
                    this.elements[i] = null;
                    this.num--;
                    return true;
                }
                for(int j=0;i<i;j++){
                    this.elements[j] = trans[j];
                }
                for(int j= i;j<this.num-1;j++){
                    this.elements[j] = trans[j+1];
                    this.elements[j+1] = null;
                }
                this.num--;
                return true;
            }
        }
        return false;
    }

    @Override
    public T get(int index) {
        if(index>=0&&index<this.num) {
            return (T) this.elements[index];
        }
        return (T) Optional.empty();
    }

    public int length(){
        return elements.length;
    }
}
