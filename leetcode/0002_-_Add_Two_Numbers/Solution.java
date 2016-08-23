public class Solution {
  public static class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { 
       val = x;
     }
  }

  public static ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode current = head;
    ListNode next;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    return prev;
  }

  public static void printList(ListNode a) {
    ListNode temp = a;
    while (temp != null) {
      System.out.print(temp.val + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode sentinel = new ListNode(0);
    ListNode p1 = l1, p2 = l2, p3 = sentinel;
    while (p1 != null || p2 != null) {
      if (p1 != null) {
        carry += p1.val;
        p1 = p1.next;
      }
      if (p2 != null) {
        carry += p2.val;
        p2 = p2.next;
      }
      p3.next = new ListNode(carry % 10);
      p3 = p3.next;
      carry /= 10;
    } 
    if (carry == 1)
      p3.next = new ListNode(1);

    return sentinel.next;
  }

  public static void main(String[] args) {
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(2);
    ListNode c = new ListNode(3);
    a.next = b;
    b.next = c;

    ListNode d = new ListNode(5);
    ListNode e = new ListNode(6);
    ListNode f = new ListNode(9);
    d.next = e;
    e.next = f;

    ListNode newHead = addTwoNumbers(a, d);
    printList(a);
    printList(d);
    System.out.println();
    printList(newHead);
  }
}
