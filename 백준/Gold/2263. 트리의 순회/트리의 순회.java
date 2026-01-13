import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] in, post, pre;
	static int pos = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		in = new int [n];
		post = new int [n];
		pre = new int [n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");;
		for (int i = 0; i < n; i++) {
			in[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");;
		for (int i = 0; i < n; i++) {
			post[i] = Integer.parseInt(st.nextToken());
		}
		getPre(0, n - 1, 0, n - 1);
		
		for (int i : pre) System.out.print(i + " ");
	}
	
	
	static void getPre(int inStart, int inLast, int postStart, int postLast) {
		if (inStart <= inLast && postStart <= postLast) {
			pre[pos++] = post[postLast];
			int next = inLast;
			for (int i = inStart; i <= inLast; i++) {
				if (in[i] == post[postLast]) {
					next = i;
					break;
				}
			}
			
			getPre(inStart, next - 1, postStart, postStart - inStart + next - 1);
			getPre(next + 1, inLast, postStart + next - inStart, postLast - 1);
		}
	}
}
