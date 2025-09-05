import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> list = new LinkedList<>();
	static int n, m, line [];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		line = new int [n + 1];
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			line[b]++;
		}
		bfs();
	}
	
	static void bfs() {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= n; i++) {
			if(line[i] == 0) {
				queue.offer(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int pos = queue.poll();
			
			sb.append(pos+" ");
			for(int next : list.get(pos)) {
				line[next]--;
				if(line[next]==0) {
					queue.offer(next);
				}
			}
		}
		
		System.out.print(sb);
	}
}