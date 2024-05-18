package ds.array;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int rainWater(int[] heights) {
		int totalRainWater = 0;
		
		for (int i = 0; i < heights.length - 1; i++) {
			int leftHeight = heights[i];
			int rightHeight = heights[i + 1];
			
			if (leftHeight > rightHeight) {
				totalRainWater += (leftHeight - rightHeight);
			}
		}
		
		
		return totalRainWater;
	}

}
