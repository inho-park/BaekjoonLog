import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list);

		int start = 1;
		int end = list.get(list.size() - 1) - list.get(0);
		int result = 0;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			int cnt = 1;
			int prev_house = list.get(0);
			
			for (int i = 1; i < n; i++) {
				if (list.get(i) - prev_house >= mid) {
					cnt++;
					prev_house = list.get(i);
				}
			}

			if (cnt >= c) {
				result = Math.max(result, mid);
				start = mid + 1;
			} else end = mid - 1;
		}
		System.out.print(result);
	}
}