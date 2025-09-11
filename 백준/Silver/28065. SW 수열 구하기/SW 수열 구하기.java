import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
        int k = 1;
        boolean flag = true;
        while (k <= n) {
            if (flag) sb.append(n--).append(" ");
            else sb.append(k++).append(" ");
            flag = !flag;
        }

        System.out.print(sb);
	}
}