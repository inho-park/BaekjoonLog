import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[n + 1];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
 
            list.get(first).add(last);
            indegree[last]++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int now = pq.poll();
            sb.append(now + " ");
            
            for (int next : list.get(now)) {
                indegree[next]--;
                
                if (indegree[next] == 0) {
                    pq.offer(next);
                }
            }
        }
        
        System.out.print(sb);
	}
}
