import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

		Node root = new Node(Integer.parseInt(br.readLine()));
		while(true) {
			String input = br.readLine();
			if(input==null || input.equals("")){
				break;
			}
			root.insert(Integer.parseInt(input));
		}

		postOrder(root);
	}

	public static void postOrder(Node node) {
		if(node != null) {
			if(node.left != null){
				postOrder(node.left);
			}
			if(node.right != null){
				postOrder(node.right);
			}
			System.out.println(node.data);
		}
	}

	public static class Node{
		int data;
		Node left;
		Node right;

		Node(int data){
			this.data=data;
		}

		public void insert(int data){
			if(data<this.data){	// 왼
				if(this.left==null){
					this.left=new Node(data);
				}else{
					this.left.insert(data);
				}
			}else{
				if(this.right==null){ // 오
					this.right=new Node(data);
				}else{
					this.right.insert(data);
				}
			}
		}
	}
}