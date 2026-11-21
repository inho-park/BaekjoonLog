import java.util.Arrays;

class Solution {
	boolean arr [];
    
    public int solution(int n, int[][] computers) {
    	arr = new boolean [computers.length];
    	int answer = 0;
    	for (int i = 0; i < n; i++) {
    		if (!arr[i]) {
    			arr[i] = true;
    			dfs(i, computers);
    			answer++;
    		}
    	}
        
        return answer;
    }
    
    public void dfs(int x, int[][] computers) {
    	arr[x] = true;
    	for (int i = 0; i < computers.length; i++) {
        	if (computers[x][i] == 1 && !arr[i] && x != i) {
        		dfs(i, computers);
        	} 
        }
    }
}