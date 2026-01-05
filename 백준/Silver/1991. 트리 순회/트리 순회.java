import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Node> arr =new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int i = 0; i < n; i++) {
			arr.add(new Node((char)(i + 65)));
		}
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int parent = st.nextToken().charAt(0) - 65; 
			int left = st.nextToken().charAt(0) - 65;
			int right = st.nextToken().charAt(0) - 65;
			if (left != -19) {
				arr.get(parent).left = arr.get(left);
			}
			if (right != -19) {
				arr.get(parent).right = arr.get(right);
			}
		}
		preorder(arr.get(0));
		System.out.println();
		inorder(arr.get(0));
		System.out.println();
		postorder(arr.get(0));
		System.out.println();
	}

	static class Node {
	    char value;
	    Node left;
	    Node right;

	    Node(char value) {
	        this.value = value;
	    }
	}
	
    static void preorder(Node node) {
        if (node == null) return;

        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    static void inorder(Node node) {
        if (node == null) return;
        
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    static void postorder(Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }
}
