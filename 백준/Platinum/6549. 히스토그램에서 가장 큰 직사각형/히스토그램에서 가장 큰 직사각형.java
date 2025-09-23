import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int [] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			if (n == 0) break;
			arr = new int [n];
			
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			sb.append(recursion(0, n - 1)).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static long recursion(int low, int high) {
		if (low == high) return arr[low];
		
		int mid = (low + high) / 2;
		long left = recursion(low, mid);
		long right = recursion(mid + 1, high);
		
		long result = right > left ? right : left;
		long extent = getArea(low, high, mid);
		return result > extent ? result : extent;
	}
	
	static long getArea(int low, int high, int mid) {
		int left = mid;
		int right = mid;
		long height = arr[mid];
		
		long result = height;
		
		while(low < left && right < high) {
			if (arr[left - 1] >= arr[right + 1]) {
				left--;
				height = height > arr[left] ? arr[left] : height;
			} else {
				right++;
				height = height > arr[right] ? arr[right] : height;
			}
			long temp = (right - left + 1) * height;
			result = result > temp ? result : temp;
		}
		
		while(low < left) {
			left--;
			height = height > arr[left] ? arr[left] : height;
			long temp = (right - left + 1) * height;
			result = result > temp ? result : temp;
		}
		while(right < high) {
			right++;
			height = height > arr[right] ? arr[right] : height;
			long temp = (right - left + 1) * height;
			result = result > temp ? result : temp;
		}
		
		return result;
	}
}
