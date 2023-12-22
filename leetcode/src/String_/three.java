package String_;

import java.util.*;

public class three {

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring1(" "));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }

    //80ms
    public static int lengthOfLongestSubstring1(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        int count = 0;
        int j = 0;


        for (int i = 0; i < s.length();i++) {

            if(!hashMap.containsKey(s.charAt(i))){
                hashMap.put(s.charAt(i),++count);
            }else{
                arrayList.add(count);
                count = 0;
                hashMap.clear();
                i = j++;
                continue;
            }
        }

        arrayList.add(count);

        Collections.sort(arrayList);
        if (s.length() != 0){
            return (int) arrayList.toArray()[arrayList.size() - 1];
        }

        return 0;
    }


    //2ms
    public static int lengthOfLongestSubstring2(String s) {
        int[] arr = new int[128];//根据Ascii码记录字母上一次出现的位置
        int res = 0;//最终结果

        //i是右窗口
        //j是左窗口
        for (int i = 0,j = 0; i < s.length(); i++) {

            //每次更新左窗口至  重复元素出现的上一个位置的下一个位置(无重复则不动)
            j = Math.max(j, arr[s.charAt(i)]);

            //每次更新结果
            res = Math.max(res, i - j + 1);

            //每次更新Ascii数组的值为真实位置 + 1(去除" "Ascii为0的影响)
            arr[s.charAt(i)] = i + 1;
        }

        return res;
    }
}
