package ds.array;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] heights = {4, 8, 1, 2, 3, 9};
		System.out.println("Max area = " + getMaxArea(heights));

	}
	
	public static int getMaxArea(int[] heights) {
		int i = 0;
		int j = heights.length - 1;
		int maxArea = 0;
		
		while (i < j) {
			int height = Math.min(heights[i], heights[j]);
			int width = j - i;
			int area = height * width;
			maxArea = Math.max(maxArea, area);
			
			if (heights[i] < heights[j]) {
				++i;
			} else {
				--j;
			}
		}
		
		return maxArea;
	}

}
