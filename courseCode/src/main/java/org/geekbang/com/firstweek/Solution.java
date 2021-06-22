package org.geekbang.com.firstweek;

public class Solution {
    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     *
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     *
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/plus-one
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] plusOne(int[] digits) {
        // 从数组后面开始遍历
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + 1; // 加1
            digits[i] = digits[i] % 10; // 求余数,如果加起来不是10，那就是原来；10取0
            if (digits[i] != 0) { //没有进位直接退出，计算结束
                return digits;
            }
        }
        // 走到这里说明原数字最高位有进位比如99之类的，需要多加一位，并且首位为0
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 如果有一个为null，返回另外一个
        if (l1 == null ) return l2;
        if (l2 == null) return l1;
        // 如果l1小，l1为头
        if (l1.val < l2.val) {
            // 下一个为 l1.next和l2中的最小值
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {// 其它的，l2为头
            // 下一个为 l2.next和l1中的最小值
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
