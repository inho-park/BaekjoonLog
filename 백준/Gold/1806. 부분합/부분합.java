import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int arr [] = new int [n + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int i = 0, j = 0, sum = 0, cnt = n + 1;
		while(j <= n && i <= j) {
			if (sum >= s) {
				cnt = Math.min(cnt, j - i);
				sum -= arr[i++];
			}
			else {
				sum += arr[j++];
			}
		}
		System.out.print(cnt == n + 1 ? 0 : cnt);
	}
}