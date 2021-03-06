package PracticeLeetCode;

import java.util.PriorityQueue;

public class _215KthLargestElement {
	public static void main(String[] args) {
		System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
	}
	public static int findKthLargest(int[] nums, int k) {
		if(nums==null||nums.length==0)
			return -1;
		PriorityQueue<Integer> queue=new PriorityQueue<>();
		for (int i = 0; i < nums.length; i++) {
			queue.offer(nums[i]);
			if(queue.size()>k)
				queue.poll();
		}
		return queue.peek();
	}
}