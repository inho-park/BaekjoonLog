import java.util.ArrayList;
import java.util.Arrays;
class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> arr = new ArrayList<>();
		int idx = 0;
		while (true) {
			for (int i = idx; i < speeds.length; i++) {
				progresses[i] += speeds[i];
			}
			int temp = 0;
			for (int i = idx; i < speeds.length; i++) {
				if (progresses[i] >= 100) {
					temp++;
					idx++;
				} else {
					break;
				}
			}
			if (temp != 0) {
				arr.add(temp);
			}
			if (idx == speeds.length) {
				break;
			}
		}
		return arr.parallelStream().mapToInt(Integer::intValue).toArray();
	}
}