import java.util.*;

class addTwoNumbers {
    public static void main(String args[]) {
        ListNode l1 = new ListNode( 9, new ListNode(9));
        ListNode l2 = new ListNode(9);
        System.out.println(addTwoNumbers(l1, l2).next.next.val);
        
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       
        ListNode Ans = new ListNode((l1.val + l2.val) % 10);
        int carry = (l1.val + l2.val) / 10;
        while(l1.next != null || l2.next != null){
            if(l1.next == null) {
                Ans = new ListNode((l2.next.val + carry)%10, Ans);
                carry = (l2.next.val + carry) / 10;
                l2 = l2.next;
            }
            else if(l2.next == null) {
                Ans = new ListNode((l1.next.val + carry)%10, Ans);
                carry = (l1.next.val + carry) / 10;
                l1 = l1.next;
            }
            else{
                Ans = new ListNode((l1.next.val + l2.next.val + carry)%10, Ans);
                carry = (l1.next.val + l2.next.val + carry) / 10;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        if(carry == 1) Ans = new ListNode(1,Ans);
        return reverse(Ans, new ListNode(Ans.val));
    }

    public static ListNode reverse(ListNode a, ListNode b){
        if(a.next == null) return b;
        return reverse(a.next,new ListNode(a.next.val, b));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}