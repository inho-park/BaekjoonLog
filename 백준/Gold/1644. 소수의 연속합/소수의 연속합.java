import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
        	if (isPrime[i]) {
        		list.add(i);
        	}
        }
        list.sort(null);
        list.add(0);
        
		int i = 0, j = 0, sum = 0, cnt = 0;
		while(j < list.size() && i <= j) {
			if (sum < n) {
				sum += list.get(j++);
			} else {
				if (sum == n) {
					cnt++;
				}
				sum -= list.get(i++);
			}
		}
		System.out.print(cnt);
	}
}