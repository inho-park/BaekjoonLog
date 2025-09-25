import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr [] = new int [n], lis [] = new int [n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		lis[0] = arr[0];
		int result = 1;
		for (int i = 1; i < n; i++) {
			int k = arr[i];
			if (lis[result - 1] < k) {
				result++;
				lis[result - 1] = k;
			} else {
				int low = 0, high = result;
				while(low < high) {
					int mid = (low + high) / 2;
					if (lis[mid] < k) low = mid + 1;
					else high = mid;
				}
				lis[low] = k;
			}
		}
		System.out.print(result);
	}
}
