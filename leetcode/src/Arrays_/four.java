package Arrays_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class four {

    public static void main(String[] args) {
        findMedianSortedArrays2(new int[]{1,5,6},new int[]{2,3,4});
    }


    //5ms
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            arrayList.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            arrayList.add(nums2[i]);
        }

        Collections.sort(arrayList);

        int size = arrayList.size();
        if (size % 2 != 0){
            return arrayList.get(size / 2);
        }else {
            return (arrayList.get(size / 2 - 1) +
                    arrayList.get(size / 2)) / 2.0;
        }
    }


    //2ms
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int i = 0,j = 0,k = 0;
        int[] res = new int[nums1.length + nums2.length];

        while (true){

            if (i == nums1.length || j == nums2.length){
                break;
            }

            if (nums1[i] < nums2[j]){
                res[k++] = nums1[i++];
            }else if (nums1[i] > nums2[j]){
                res[k++] = nums2[j++];
            }else {
                res[k++] = nums1[i++];
                res[k++] = nums2[j++];
            }
        }

        while (i != nums1.length){
            res[k++] = nums1[i++];
        }

        while (j != nums2.length){
            res[k++] = nums2[j++];
        }

        int length = res.length;
        if (length % 2 != 0){
           return res[length / 2];
        }else {
            return (res[length / 2 - 1] + res[length / 2]) / 2.0;
        }
    }
}
