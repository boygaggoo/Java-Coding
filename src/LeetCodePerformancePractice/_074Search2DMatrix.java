package LeetCodePerformancePractice;

public class _074Search2DMatrix {
	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][]{
			{1,   3,  5,  7},
			{10, 11, 16, 20},
			{23, 30, 34, 50}
		}, 31));

	}
	public static boolean searchMatrix(int[][] matrix, int target) {
		int row=0,col=matrix[0].length-1;
		while(row<matrix.length && col>=0)
		{
			if(matrix[row][col]==target)
				return true;
			if(matrix[row][col]>target)
				col--;
			else
				row++;
		}
		return false;
	}

}
