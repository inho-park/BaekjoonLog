import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int sum = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (sum > temp) list.add(temp);
        }
		list.sort(null);
		
		int result = 0;
		int i = 0, j = list.size() - 1;
		while(i < j) {
			int x = list.get(i) + list.get(j);
			
			if(sum == x) result++;
			
			if(sum > x) {
				i++;
			}else {
				j--;
			}
		}
		System.out.print(result);
	}
}