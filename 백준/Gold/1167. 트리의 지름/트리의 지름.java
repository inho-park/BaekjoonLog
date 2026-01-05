import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Node> [] list;
	static boolean[] visited;
	static int max = 0;
	static int topNode;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		visited = new boolean [n + 1];
		StringTokenizer st;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			
			while(true) {
				int next = Integer.parseInt(st.nextToken());
				
				if (next == -1) break;
				int len = Integer.parseInt(st.nextToken());
				list[num].add(new Node(next, len));
			}
		}
		
		dfs(1, 0);
		visited = new boolean [n + 1];
		dfs(topNode, 0);
		System.out.print(max);
	}
	
	static class Node {
		int num;
		int len;
		
		public Node(int num, int len) {
			this.num = num;
			this.len = len;
		}
	}
	
	static void dfs(int num, int len) {
		if (len > max) {
			max = len;
			topNode = num;
		}
		
		visited[num] = true;
		
		for (int i = 0; i < list[num].size(); i++) {
			Node node = list[num].get(i);
			if (visited[node.num] == false) {
				dfs(node.num, node.len + len);
			}
		}
	}
}
