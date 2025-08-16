import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		if(n == 1 && m == 1) {
			System.out.println(1);
			System.exit(0);
		}
		arr = new int[n][m];
		for (int i = 0; i < arr.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < arr[i].length; j++) {
				int num = str.charAt(j) - '0';
				if (num == 1) {
					arr[i][j] = num;
				}
			}
		}
		System.out.println(bfs());

	}

	private static int bfs() {
		int[][][] check = new int[2][n][m];

		// 동서남북
		int[] ax = {0, 0, -1, 1};
		int[] ay = {-1, 1, 0, 0};

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {0, 0, 0});
		check[0][0][0] = 1;

		while (true) {

			int[] node = queue.poll();
			if (node == null) {
				return -1;
			}
			int w = node[0];
			int x = node[1];
			int y = node[2];

			for (int i = 0; i < 4; i++) {
				int nx = x + ax[i];
				int ny = y + ay[i];
				if (nx >= n || nx < 0 || ny >= m || ny < 0) {
					continue;
				}

				if (w == 0) {
					if (arr[nx][ny] == 0 && check[0][nx][ny]==0) { 
						
						queue.offer(new int[] {0, nx, ny});
						check[0][nx][ny] = check[0][x][y] + 1;
					} else if(arr[nx][ny] == 1 && check[0][nx][ny]==0){
						if (check[1][nx][ny] == 0) {

							queue.offer(new int[] {1, nx, ny});
							check[1][nx][ny] = check[0][x][y] + 1;
						}
					}
				} else {
					if (arr[nx][ny] == 0) { 
						if (check[1][nx][ny] == 0) {

							queue.offer(new int[] {1, nx, ny});
							check[1][nx][ny] = check[1][x][y] + 1;
						}
					}
				}
				if (nx == n - 1 && ny == m - 1) {
					return Math.max(check[0][nx][ny], check[1][nx][ny]);
				}

			}

		}

	}
}