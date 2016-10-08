package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _103BinaryTreeZigZaglOrderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(2);
		tn.left.left=new TreeNode(3);
		tn.right.right=new TreeNode(3);
		tn.right.left=new TreeNode(4);
		tn.left.right=new TreeNode(4);
		System.out.println(zigzagLevelOrder(tn));
		tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(2);
		tn.right.right=new TreeNode(3);
		tn.left.right=new TreeNode(3);
		System.out.println(zigzagLevelOrder(tn));
	}
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		int height=getHeight(root);
		List<List<Integer>> outputList=new ArrayList<>();
		boolean flag=true;
		for (int i = 0; i < height; i++) {
			List<Integer> list=new ArrayList<>();
			printNodes(root,i,list,flag);
			flag=!flag;
			outputList.add(list);
		}
		return outputList;
	}
	private static void printNodes(TreeNode root, int level, List<Integer> list,boolean flag) {
		if(root==null)
			return;
		if(level==0){
			list.add(root.val);
			return;
		}
		if(flag){
			printNodes(root.left, level-1, list,flag);
			printNodes(root.right, level-1, list,flag);
		}
		else
		{
			printNodes(root.right, level-1, list,flag);
			printNodes(root.left, level-1, list,flag);
		}
	}
	private static int getHeight(TreeNode root) {
		return root==null?0:1+Math.max(getHeight(root.left), getHeight(root.right));
	}
}
