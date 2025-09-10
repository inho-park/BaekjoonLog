import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new LinkedList<>();
		boolean check = false;
		
		for (int i = n; i >= 1; i--) {
			if (!check) {
				deque.addLast(i);
			} else {
				deque.addFirst(i);
			}
			
			check = !check;
		}
		while (!deque.isEmpty()) {
			sb.append(deque.poll()).append(" ");
		}
		System.out.print(sb);
		br.close();
	}
}