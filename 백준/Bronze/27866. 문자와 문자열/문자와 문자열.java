import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [] arr = br.readLine().toCharArray();
		System.out.print(arr[Integer.parseInt(br.readLine()) - 1]);
	}
}
