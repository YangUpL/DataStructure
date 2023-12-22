package Arrays_;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class one {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{1, 2, 3}, 9);

        System.out.println(Arrays.toString(ints));
    }



    //1ms
    public static int[] twoSum(int[] nums, int target) {

        //哈希表
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {//遍历整个数组

            //如果哈希表里有满足条件的数,就直接返回
            if(hashMap.containsKey(target - nums[i])){

//                返回数组  第一个数是满足条件值的下标  第二个数是当前下标
                return new int[]{hashMap.get(target - nums[i]),i};
            }

            //没有就将当前数放入到哈希表中
            hashMap.put(nums[i],i);
        }

//        没有返回默认值
        return new int[0];
    }
}
