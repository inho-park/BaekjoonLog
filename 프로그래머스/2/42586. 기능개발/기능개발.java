import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Integer> answerList = new ArrayList<>();
		
		for (int i = 0; i < progresses.length; i++) { 
			int date = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
			
			if (!queue.isEmpty() && queue.peek() < date) {
				answerList.add(queue.size());
				queue.clear();
			}
			
			queue.add(date);
		}
		
		answerList.add(queue.size());
		
		int answer [] = new int [answerList.size()];
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = answerList.get(i);
		}
		return answer;
    }
}