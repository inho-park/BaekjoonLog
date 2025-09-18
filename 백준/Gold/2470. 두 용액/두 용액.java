import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int arr [] = new int [n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int i = 0, j = n - 1, min = Integer.MAX_VALUE;
		int I = n - 1, J = 0;
		while(i < j) {
			int x = arr[i] + arr[j];
			int abs = Math.abs(x);
			
			if(min > abs) {
				I = i;
				J = j;
				if (abs == 0) break;
				min = abs;
			}
			
			if (x < 0) i++;
			else j--;
		}
		System.out.print(arr[I] + " " + arr[J]);
	}
}
