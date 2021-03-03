package mystring;

/**
 * @ClassName MyString
 * @Description: 串
 * @Author LiMinghua
 * @Date 2020/10/15
 * @Version V1.0
 **/
public final class MyString implements Comparable<MyString>, java.io.Serializable{
    private final char[] value;

    public MyString()
    {
        this.value = new char[0];
    }

    public MyString(java.lang.String s)
    {
        //申请字符数组并复制s串的所有字符
        this.value = new char[s.length()];
        for (int i=0; i<this.value.length; i++) {
            this.value[i] = s.charAt(i);
        }
    }

    public MyString(char[] value, int i, int n)
    {
        if (i>=0 && n>=0 && i+n<=value.length)
        {
            this.value = new char[n];
            for (int j=0; j<n; j++) {
                this.value[j] = value[i+j];
            }
        }
        else {
            throw new StringIndexOutOfBoundsException("i="+i+"，n="+n+"，i+n="+(i+n));
        }
    }
    public MyString(char[] value)
    {
        this(value, 0, value.length);
    }
    public MyString(MyString s)
    {
        this(s.value);
    }

    public int length()                                    //返回串长度，即字符数组容量
    {
        return this.value.length;
    }

    /**
     * 获取下标位置的元素
     *
     * @param i 下标
     * @return: char
     * @auther: LiMinghua
     * @date: 2020/10/15 18:02
     */
    public char charAt(int i) {
        if (i>=0 && i<this.value.length) {
            return this.value[i];
        }
        throw new StringIndexOutOfBoundsException(i);
    }

    /**
     * 返回当前串（目标串）从begin开始首个与模式串pattern匹配的子串序号，若匹配失败返回-1
     * 朴素模式匹配
     *
     * @param pattern 模式串
     * @param index 起始位置
     * @return: int
     * @auther: LiMinghua
     * @date: 2020/10/15 11:59
     */
    public int indexOf(MyString pattern,int index){
        int m = pattern.length(),n = this.length();
        if(index<0||index>=n||index+m>=n||m>n){
            throw new StringIndexOutOfBoundsException();
        }
        // i为字符串的游标，j为模式串的游标
        int i = index,j = 0;
        int count = 0;
        while (i<n&&j<m){
            count++;
            if (this.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }else{
                i = i-j+1;
                j = 0;
                if(i>n-m){
                    break;
                }
            }
        }
        System.out.println("BF.count="+count);
        if (j==m)
        {
            return i-j;
        }
        return -1;
    }

    /**
     * 通过kmp算法得到模式串在目标串中的起始位置，错误返回-1
     *
     * @param pattern 模式串
     * @param index 开始下标
     * @return: int
     * @auther: LiMinghua
     * @date: 2020/10/15 17:59
     */
    public int indexOfByKmp(MyString pattern,int index){

        int m = pattern.length();
        int n = this.length();
        if(index<0||index>=n||index+m>=n||m>n){
            throw new StringIndexOutOfBoundsException();
        }
        // i为字符串的游标，j为模式串的游标
        int i = index;
        int j = 0;
        int count = 0;
        int[] next = getNext(pattern);
        while(i<n&&j<m){
            if(j!=-1){
                count++;
            }
            if (j==-1 || this.charAt(i)==pattern.charAt(j))
            {
                if (j!=-1) {
                    System.out.print("t"+i+"=p"+j+"，");
                }
                i++;
                j++;
            }else
            {
                System.out.println("t"+i+"!=p"+j+"，next["+j+"]="+next[j]);
                j=next[j];
                if (n-i+1<m-j+1)
                {
                    break;
                }
            }
        }
        if (j==m)
        {
            return i-j;
        }
        return -1;
    }

    /**
     * 返回next数组
     *
     * @param pattern 模式串
     * @return: int[]
     * @auther: LiMinghua
     * @date: 2020/10/15 18:01
     */
    public int[] getNext(MyString pattern){

        int[] next = new int[pattern.length()];
        int j = 0,k = -1;
        while(j<pattern.length()-1){
            if(k==-1||pattern.charAt(j)==pattern.charAt(k)){
                next[++j] = ++k;
            }else{
                k = next[k];
            }
        }
        return next;
    }

    @Override
    public int compareTo(MyString s) {
        for (int i=0; i<this.value.length && i<s.value.length; i++) {
            if (this.value[i]!=s.value[i]) {
                //返回两串第一个不同字符的差值
                return this.value[i] - s.value[i];
            }
        }
        //前缀子串，返回两串长度的差值
        return this.value.length - s.value.length;
    }
}
