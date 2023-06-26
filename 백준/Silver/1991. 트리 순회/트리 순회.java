import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static Node head = new Node("A", null, null);
	static StringBuilder sb =new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			String root=st.nextToken();
			String left=st.nextToken();
			String right=st.nextToken();

			Node.insert(head,root,left,right);
		}
		preorder(head);
		sb.append('\n');
		inorder(head);
		sb.append('\n');
		postorder(head);

		System.out.println(sb);
	}

	public static void preorder(Node node) {
		if(node == null){
			return;
		}
		sb.append(node.data);
		preorder(node.left);
		preorder(node.right);
	}
	public static void inorder(Node node) {
		if(node == null){
			return;
		}
		inorder(node.left);
		sb.append(node.data);
		inorder(node.right);
	}
	public static void postorder(Node node) {
		if(node == null){
			return;
		}
		postorder(node.left);
		postorder(node.right);
		sb.append(node.data);
	}
	static class Node{
		String data;
		Node left;
		Node right;

		public Node(String data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public static void insert(Node temp, String root, String left, String right) {
			// 부모 찾음
			if (temp.data.equals(root)) {
				temp.left = (left.equals(".") ? null : new Node(left,null,null));
				temp.right = (right.equals(".") ? null : new Node(right,null,null));
			}
			// 부모 찾으러 재귀
			else {
				if(temp.left != null) insert(temp.left, root, left, right);
				if(temp.right != null) insert(temp.right, root, left, right);
			}
		}
	}

}