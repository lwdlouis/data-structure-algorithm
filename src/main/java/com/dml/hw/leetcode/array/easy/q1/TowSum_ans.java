package com.dml.hw.leetcode.array.easy.q1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 时间复杂度 O(n)
 *
 *
 * @author Louis
 * @version 1.0
 * @since 2019/11/19
 */
public class TowSum_ans {


    public static void main(String[] args) {

//        int[] nums = new int[]{2, 7, 11, 15};
//        int target = 9;

        int[] nums = new int[]{-3,4,3,90};
        int target = 0;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }


    /**
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     * 关键：将所有数放到 map 里面，然后遍历的时候找找 target - num 的值有没有在 map 里面。
     *
     */
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        // 遍历一遍数组
        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            // target - num 的值， 看看 map 里面有没有
            Integer match = map.get(target - num);

            // 如果有就 return
            if (null != match) {
                return new int[]{match, i};
            }

            // 如果没有就 put 到map里面 <value, index> ，注意如果数字相同，取第一个put 进 map 的数。
            map.putIfAbsent(num, i);
        }
        return null;
    }
}
