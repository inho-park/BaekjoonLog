import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [] arr = br.readLine().toCharArray();
		for (int i = 0; i < arr.length/2; i++) {
			if (arr[i] != arr[arr.length - 1 - i]) {
				System.out.print(0);
				System.exit(0);
			}
		}
		System.out.print(1);
	}
}