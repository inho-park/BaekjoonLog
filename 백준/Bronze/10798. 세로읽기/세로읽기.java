import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char [][] arr = new char [5][15];
		int top = -1;
		for (int i = 0; i < 5; i++) {
			char [] chArr = br.readLine().toCharArray();
			if (top < chArr.length) top = chArr.length;
			for (int j = 0; j < chArr.length; j++) {
				arr[i][j] = chArr[j];
			}
		}
		String str = "";
		for (int i = 0; i < top; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[j][i] != 'a' - 'a')
				str += arr[j][i];
			}
		}
		
		System.out.print(str);
	}
}