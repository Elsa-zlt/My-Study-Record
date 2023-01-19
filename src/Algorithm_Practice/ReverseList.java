package Algorithm_Practice;

/**
 * @ClassName : ReverseList  //类名
 * @Author : elsa //作者
 */

import java.util.List;

/**
 * 反转一个单链表
 * 输入: 1->2->3->4->5
 * 输出: 5->4->3->2->1
 *
 * 解法1：迭代，重复某一过程，每一次处理结果作为下一次处理的初始值，这些初始值类似于状态、每
 * 次处理都会改变状态、直至到达最终状态
 * 从前往后遍历链表，将当前节点的next指向上一个节点，因此需要一个变量存储上一个节点prev，当前
 * 节点处理完需要寻找下一个节点，因此需要一个变量保存当前节点curr，处理完后要将当前节点赋值给
 * prev，并将next指针赋值给curr，因此需要一个变量提前保存下一个节点的指针next
 *
 */
public class ReverseList {

    static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 1、将下一个节点指针保存到 next 变量 next = curr.next
    // 2、将下一个节点的指针指向 prev，curr.next = prev
    // 3、准备处理下一个节点，将 curr 赋值给 prev
    // 4、将下一个节点赋值为 curr，处理一个节点
    public static ListNode iterate(ListNode head) {
        ListNode prev = null, curr, next;
        curr = head;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 解法2：递归：以相似的方法重复，类似于树结构，先从根节点找到叶子节点，从叶子节点开始遍历
    // 大的问题(整个链表反转)拆成性质相同的小问题(两个元素反转)curr.next.next = curr
    // 将所有的小问题解决，大问题即解决
    // 只需每个元素都执行curr.next.next = curr，curr.next = null两个步骤即可
    // 为了保证链不断，必须从最后一个元素开始
    public static ListNode recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        // ListNode node = iterate(node1);
        ListNode node_1 = recursion(node1);
        System.out.println(node_1);
    }
}
