package mystring;


import org.openjdk.jol.info.ClassLayout;

import java.lang.instrument.Instrumentation;

/**
 * @ClassName MyStringTest
 * @Description: TODO
 * @Author LiMinghua
 * @Date 2020/10/15
 * @Version V1.0
 **/
public class MyStringTest {
    public static void main(String[] args) {

        MyString target = new MyString("aaaaab");
        MyString pattern = new MyString("aab");
        System.out.println(ClassLayout.parseInstance(pattern).toPrintable());
        System.out.println(target.indexOfByKmp(pattern,0));
    }
}
