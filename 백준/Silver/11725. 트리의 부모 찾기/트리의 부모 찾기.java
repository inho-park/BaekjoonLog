import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int result [];
	static boolean bool [];
	static ArrayList<ArrayList<Integer>> arr =new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		result = new int [n + 1];
		bool = new boolean [n + 1];
		StringTokenizer st;
		
		for (int i = 0; i < n + 1; i++) {
			arr.add(new ArrayList<>());
		}
		
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.get(a).add(b);
			arr.get(b).add(a);
		}
		
		dfs(1);
		
		for (int i = 2; i < n + 1; i++) {
			System.out.println(result[i]);
		}
	}
	
	private static void dfs(int n) {
		bool[n] = true;
		
		arr.get(n).forEach(i -> {
			if (!bool[i]) {
				dfs(i);
				result[i] = n;
			}
		});
	}
}
