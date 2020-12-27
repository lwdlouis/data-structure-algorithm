package com.dml.hw.leetcode.array.easy.q35;

/**
 * 解题思路
 *
 * 标签：二分查找
 * 如果该题目暴力解决的话需要

 * O(n) 的时间复杂度，但是如果二分的话则可以降低到

 * O(logn) 的时间复杂度
 * 整体思路和普通的二分查找几乎没有区别，先设定左侧下标 left 和右侧下标 right，再计算中间下标 mid
 * 每次根据 nums[mid] 和 target 之间的大小进行判断，相等则直接返回下标，nums[mid] < target 则 left 右移，nums[mid] > target 则 right 左移
 * 查找结束如果没有相等值则返回 left，该值为插入位置
 * 时间复杂度：

 * O(logn)
 * 二分查找的思路不难理解，但是边界条件容易出错，比如 循环结束条件中 left 和 right 的关系，更新 left 和 right 位置时要不要加 1 减 1。
 *
 */
public class SearchInsert_ans {
    /**
     * 其实最让我学习到的是，二分查找其实完全可以用循环来做，不一定用递归。
     * 只要确定好 左右两个下表即可
     */

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
