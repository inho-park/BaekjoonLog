import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Node root = new Node(Integer.parseInt(br.readLine()));
		while (true) {
			String str = br.readLine();
			if (str == null || str.equals("")) {
				break;
			}
			int node = Integer.parseInt(str);
			root.set(node);
		}
		
		postOrder(root);
	}
	
	static class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
		
		void set(int n) {
			if (n < value) {
				if (left == null) {
					left = new Node(n);
				} else {
					left.set(n);
				}
			} else {
				if (right == null) {
					right = new Node(n);
				} else {
					right.set(n);
				}
			}
		}
	}
	
	static void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.value);
	}
}
