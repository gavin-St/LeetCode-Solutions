# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        if not head or k == 1:
            return head
        original = ListNode(None)
        link = original
        cur = head
        front = cur
        while True:
            count = 0
            back = cur
            while back and count < k:
                count += 1
                back = back.next
            back = cur
            if count == k:
                prev = cur
                temp = cur.next
                prev.next = None
                cur = temp
                for i in range(k-1):
                    front = cur
                    temp = cur.next
                    front.next = prev
                    cur = temp
                    prev = front
                link.next = front
                link = back 
            else:
                link.next = cur
                return original.next
