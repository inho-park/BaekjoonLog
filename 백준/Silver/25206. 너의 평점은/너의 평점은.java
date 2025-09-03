import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		Map<String, Float> map = new HashMap<>();
		map.put("A+", 4.5f);
		map.put("A0", 4.0f);
		map.put("B+", 3.5f);
		map.put("B0", 3.0f);
		map.put("C+", 2.5f);
		map.put("C0", 2.0f);
		map.put("D+", 1.5f);
		map.put("D0", 1.0f);
		map.put("F", 0.0f);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		float numer = 0;
		float denom = 0;
		StringTokenizer st;
		for (int i = 0; i < 20; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String temp = st.nextToken();
			float point = Float.parseFloat(st.nextToken());
			String str = st.nextToken();
			if (str.equals("P")) 
				continue;
			denom += point;
			float score = map.get(str);
			numer += point * score;
		}
		float result = numer/denom;
		System.out.println(result);
	}
}