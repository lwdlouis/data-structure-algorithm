package com.dml.hw.leetcode.array.easy.q27;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
//        int[] nums = new int[]{1};
//        int val = 1;

//        int len = removeElement(nums, val);
        int len = removeElement_best_2(nums, val);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int removeElement(int[] nums, int val) {

        int backward = nums.length - 1;
        int forward = 0;
        boolean forwardReady = false;
        boolean backwardReady = false;
        int length = 0;

        for (int i = 0; i < nums.length; i++) {

            if (forward >= backward) {
                if (nums[forward] != val) {
                    length = forward + 1;
                } else {
                    length = forward;
                }
                break;
            }

            if (nums[forward] == val) {
                forwardReady = true;
            } else {
                forward ++;
            }

            if (nums[backward] != val) {
                backwardReady =true;
            } else {
                backward --;
            }

            if (forwardReady && backwardReady) {
                int temp = nums[forward];
                nums[forward] = nums[backward];
                nums[backward] = temp;
                forwardReady = false;
                backwardReady = false;
                forward ++;
                backward --;
            }

        }
        return length;
    }

    /**
     * 不用两头往中间走，不管三七二十一，前指针符合的全都丢到后面，
     * 然后后面的指针往前走一个。
     */
    public static int removeElement_best_1(int[] nums, int val) {

        int ans = nums.length - 1;

        for (int i = 0; i < ans;) {
            if (nums[i] == val) {
                nums[i] = nums[ans];
                ans--;
            } else {
                i++;
            }
        }
        return ans;
    }

    /**
     * 这是我原来思路的简化，前指针先走，符合条件停下。
     * 然后后指针开始走，符合条件交换。
     */
    public static int removeElement_best_2(int[] nums, int val) {

        int ans = nums.length - 1;

        for (int i = 0; i < ans;) {
            if (nums[i] != val) {
                i ++;
            } else {
                if (nums[ans] == val) {
                    nums[i] = nums[ans];
                    nums[ans] = val;
                }
                ans --;
            }
        }
        return ans;
    }
}
