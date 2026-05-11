import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < participant.length; i++) {
        	if (!map.containsKey(participant[i])) {
        		map.put(participant[i], 1);
        	} else {
        		map.put(participant[i], map.get(participant[i]) + 1);
        	}
        }
        
        for (int i = 0; i < completion.length; i++) {
        	if (map.get(completion[i]) > 1) {
        		map.put(completion[i], map.get(completion[i]) - 1);
        	} else {
        		map.remove(completion[i]);
        	}
        }
        answer = (String) map.keySet().toArray()[0];
        return answer;
    }
}