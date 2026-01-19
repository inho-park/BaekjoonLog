import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, total = 1;
	static boolean visited [];
	static ArrayList<ArrayList<Integer>> graph;
	static ArrayList<Integer> nodes = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			if (n == 0 && m == 0) {
				break;
			} else {
				graph = new ArrayList<>();
				for (int i = 0; i < n + 1; i++) {
					graph.add(new ArrayList<>());
				}
				visited = new boolean [n + 1];
				for (int i = 0; i < m; i++) {
					st = new StringTokenizer(br.readLine(), " ");
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					graph.get(a).add(b);
					graph.get(b).add(a);
				}
				int cnt = 0;
				for (int i = 1; i < n + 1; i++) {
					if (!visited[i]) {
						if (dfs(i)) cnt++;
					}
				}
				
				sb.append("Case " + total + ": ");
				if (cnt > 1) {
					sb.append("A forest of " + cnt + " trees.");
				} else if (cnt == 1) {
					sb.append("There is one tree.");
				} else {
					sb.append("No trees.");
				}
				sb.append("\n");
			}
			total++;
		}
		System.out.print(sb);
		
	}
	
	static boolean dfs(int idx) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(idx);
		visited[idx] = true;
		int node = 0, first = 0;
		
		while(!queue.isEmpty()) {
			int i = queue.poll();
			node++;
			visited[i] = true;
			for (int next : graph.get(i)) {
				first++;
				if (!visited[next]) {					
					queue.add(next);
				}
			}
		}
		
		return 2*(node - 1) == first;
	}
}
