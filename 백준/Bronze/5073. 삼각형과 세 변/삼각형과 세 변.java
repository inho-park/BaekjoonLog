import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = -1, b = -1, c = -1;
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if (a == 0 && b == 0 && c == 0) break;
			if (a + b + c - Math.max(Math.max(a, b), c) > Math.max(Math.max(a, b), c)) {
				if (a == b) {
					if (b == c) System.out.println("Equilateral");
					else System.out.println("Isosceles");
				} else {
					if (b == c) System.out.println("Isosceles");
					else { 
						if (a == c) System.out.println("Isosceles");
						else System.out.println("Scalene");
					}
				}
			} else System.out.println("Invalid");
		}
	}
}