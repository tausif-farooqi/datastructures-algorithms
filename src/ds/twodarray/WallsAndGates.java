package ds.twodarray;

public class WallsAndGates {
	private static final int WALL = -1;
	private static final int GATE = 0;
	private static final int INF = 2147483647;
	private static final int[][] DIRECTIONS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public void wallsAndGates(int[][] rooms) {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == GATE) {
					gateSteps(rooms, i, j, 0);
				}
			}
		}
	}

	private void gateSteps(int[][] rooms, int x, int y, int step) {
		rooms[x][y] = step;
		int nextStep = ++step;

		for (int i = 0; i < DIRECTIONS.length; i++) {
			int nextX = x + DIRECTIONS[i][0];
			int nextY = y + DIRECTIONS[i][1];

			if (nextX < 0 || nextY < 0 || nextX >= rooms.length || nextY >= rooms[0].length
					|| rooms[nextX][nextY] == WALL || rooms[nextX][nextY] == GATE || rooms[nextX][nextY] < step) {

				continue;
			}

			gateSteps(rooms, nextX, nextY, nextStep);
		}
	}

	private void printMatrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				System.out.print(matrix[row][col] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { INF, -1, 0, INF }, { INF, INF, INF, -1 }, { INF, -1, INF, -1 }, { 0, -1, INF, INF } };

		WallsAndGates wng = new WallsAndGates();
		wng.wallsAndGates(matrix);
		wng.printMatrix(matrix);
	}
}
