package com.dml.hw.leetcode.array.easy.q35;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 */
public class SearchInsert {

    public static void main(String[] args) {
        List<TestEntity> testList = new ArrayList<>();

        testList.add(new TestEntity(new int[]{1,3,5,6}, 5, 2));
        testList.add(new TestEntity(new int[]{1,3,5,6}, 2, 1));
        testList.add(new TestEntity(new int[]{1,3,5,6}, 7, 4));
        testList.add(new TestEntity(new int[]{1,3,5,6}, 0, 0));
        testList.add(new TestEntity(new int[]{1}, 0, 0));
        testList.add(new TestEntity(new int[]{1,3,5}, 4, 2));

        testList.stream().forEach(e -> {
            int result = searchInsert(e.nums, e.target);
            System.out.println(result + "," + e.expect + " = " + String.valueOf(result==e.expect));
        });

    }

    private static int searchInsert(int[] nums, int target) {
        return binarySearch_2(nums, 0, nums.length, target);
    }

    private static int binarySearch(int[] nums, int begin, int end, int target) {
        int binInx = (begin + end) / 2;
        int result = 0;

        if (binInx <= 0) {
            result = nums[binInx] >= target ? binInx : binInx + 1;
        } else if (binInx == begin + 1 && nums[begin] > target) {
            result = begin;
        } else if (binInx == end - 1 && nums[binInx] < target) {
            result = end;
        } else if (nums[binInx] == target
                || (nums[binInx] > target && nums[binInx - 1] < target)) {
            result = binInx;
        } else if (nums[binInx] < target && nums[binInx + 1] > target) {
            result = binInx + 1;
        } else if (nums[binInx] < target) {
            result = binarySearch(nums, binInx, end, target);
        } else {
            result = binarySearch(nums, begin, binInx, target);
        }
        return result;
    }


    private static int binarySearch_2(int[] nums, int begin, int end, int target) {
        int binInx = (begin + end) / 2;

        if (nums[binInx] == target
                || end - begin == 1) {
            if (nums[binInx] < target) {
                return end;
            } else {
                return binInx;
            }
        } else if (nums[binInx] < target) {
            return binarySearch_2(nums, binInx, end, target);
        } else {
            return binarySearch_2(nums, begin, binInx, target);
        }
    }


}

class TestEntity {
    public int[] nums;
    public int target;
    public int expect;

    public TestEntity(int[] nums, int target, int expect) {
        this.nums = nums;
        this.target = target;
        this.expect = expect;
    }
}
