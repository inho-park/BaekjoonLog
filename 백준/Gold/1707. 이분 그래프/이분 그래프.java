import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int k, V, e, check [];
	static List<List<Integer>> graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			graph = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			check = new int [V + 1];
			for (int j = 0; j <= V; j++) {
				graph.add(new ArrayList<>());
			}
			for (int j = 0; j < e; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				graph.get(from).add(to);
				graph.get(to).add(from);
			}
			boolean result = false;
			for(int j = 1; j <= V; j++) {
				if (check[j] == 0) {
					result = bfs(j, 1);
				}
				if (!result) break;
			}
			System.out.println(result ? "YES" : "NO");
		}

	}

	private static boolean bfs(int from, int color) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(from);
		check[from] = color;
		while(!queue.isEmpty()) {
			int temp = queue.poll();
			for (int i = 0; i < graph.get(temp).size(); i++) {
				int next = graph.get(temp).get(i);
				if (check[temp] == check[next]) return false;
				if (check[next] == 0) {
					check[next] = check[temp] * -1;
					queue.offer(next);
				}
			}
		}
		return true;
	}
}