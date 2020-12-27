package com.dml.hw.leetcode.array.medium.q15;

import java.util.*;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * @author Louis
 * @version 1.0
 * @since 2019/12/12
 */
public class TreeSum {


    public static void main(String[] args) {

        int[] num = new int[]{-1, 0, 1, 2, -1, -4};

        List<List<Integer>> resultList = threeSum(num);

        resultList.stream().forEach(n -> System.out.println(Arrays.toString(n.toArray())));
    }

    private static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();

        Map<Integer, Map<Integer, Object>> map1 = new HashMap<>();

        Map<Integer, Integer> map3 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            if (map3.containsKey(nums[i])) {
                count = map3.get(nums[i]);
            }
            map3.put(nums[i], ++count);
        }

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (!map1.containsKey(x)) {
                map1.put(x, new HashMap<>());
            }

            map3.put(x, map3.get(x) - 1);

            for (int j = i+1; j < nums.length; j++) {
                int y = nums[j];
                map3.put(y, map3.get(y) - 1);
                int z = 0 - (x + y);
                if (!map1.get(x).containsKey(y) && !map1.get(x).containsKey(z)) {
                    if (map3.containsKey(z) && map3.get(z) > 0) {
                        Map<Integer, Object> mapX = map1.get(x);
                        mapX.put(y, null);
                        mapX.put(z, null);
                        map1.put(x, mapX);

                        Map<Integer, Object> mapY = map1.get(y);
                        if (null == mapY) {
                            mapY = new HashMap<>();
                        }
                        mapY.put(x, null);
                        mapY.put(z, null);
                        map1.put(y, mapY);

                        Map<Integer, Object> mapZ = map1.get(z);
                        if (null == mapZ) {
                            mapZ = new HashMap<>();
                        }
                        mapZ.put(x, null);
                        mapZ.put(y, null);
                        map1.put(z, mapZ);

                        List<Integer> match = new ArrayList<>();
                        match.add(x);
                        match.add(y);
                        match.add(z);
                        resultList.add(match);
                    }
                }
                map3.put(y, map3.get(y) + 1);
            }
            map3.put(x, map3.get(x) + 1);
        }

        return resultList;
    }

}
