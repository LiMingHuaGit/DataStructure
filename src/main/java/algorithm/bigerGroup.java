package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName bigerGroup
 * @Description: TODO
 * @Author LiMinghua
 * @Date 2021/1/5
 * @Version V1.0
 **/
public class bigerGroup {
    public static void main(String[] args) {
            String s = "abbxxxxzzy";
            List a = largeGroupPositions(s);
            System.out.println(a.toString());
    }
    public static List<List<Integer>> largeGroupPositions(String s) {
        s = s + "A";
        List<List<Integer>> answer = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i>=2&&s.charAt(i)!=s.charAt(j+1)){
                        List<Integer> group = new ArrayList<>();
                        group.add(i);
                        group.add(j);
                        answer.add(group);
                        i= j;
                    }
                }else {
                    i++;
                    j--;
                }
            }
        }
        return answer;
    }
}
