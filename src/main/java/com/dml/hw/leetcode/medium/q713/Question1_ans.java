package com.dml.hw.leetcode.medium.q713;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Louis
 * @version 1.0
 * @since 2019/11/8
 */

public class Question1_ans {


    /**
     * 双指针
     *
     * 分析
     *
     * 对于每个 \mathrm{right}right，我们需要找到最小的 \mathrm{left}left，满足 \prod_{i=\mathrm{left}}^\mathrm{right} \mathrm{nums}[i] < k∏
     * i=left
     * right
     * ​
     *  nums[i]<k。由于当 \mathrm{left}left 增加时，这个乘积是单调不增的，因此我们可以使用双指针的方法，单调地移动 \mathrm{left}left。
     *
     * 算法
     *
     * 我们使用一重循环枚举 \mathrm{right}right，同时设置 \mathrm{left}left 的初始值为 0。
     * 在循环的每一步中，表示 \mathrm{right}right 向右移动了一位，将乘积乘以 \mathrm{nums}[\mathrm{right}]nums[right]。
     * 此时我们需要向右移动 \mathrm{left}left，直到满足乘积小于 kk 的条件。
     * 在每次移动时，需要将乘积除以 \mathrm{nums}[\mathrm{left}]nums[left]。
     * 当 \mathrm{left}left 移动完成后，对于当前的 \mathrm{right}right，
     * 就包含了 \mathrm{right} - \mathrm{left} + 1right−left+1 个乘积小于 kk 的连续子数组。
     *
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/subarray-product-less-than-k/solution/cheng-ji-xiao-yu-kde-zi-shu-zu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     */

    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1)
            return 0;

        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];

            while (prod >= k) {
                int leftNums = nums[left++];
                prod /= leftNums;
            }
            ans += right - left + 1;
        }
        return ans;
    }


    public static void main(String[] args) {

//        int[] num = new int[]{10,5,2,6};
//        int k = 100;

//        int[] num = new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3};
//        int k = 19;

        int[] num = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int k = 6;

        System.out.println(numSubarrayProductLessThanK(num, k));
    }

}
