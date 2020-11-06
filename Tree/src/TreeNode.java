import java.util.Stack;

;

public class TreeNode {

	int data;
	static int value=1;
	TreeNode left;
	TreeNode right;
	
	
	public TreeNode(int data, TreeNode left, TreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		right = null;
	}
	
	
	static TreeNode makingHeight(int height,int val) {
		if(height==0) return null;
		
		TreeNode n1= new TreeNode(TreeNode.value++);
		n1.left = makingHeight(height-1,val+1);
		n1.right = makingHeight(height-1,val+2);
		
		
		return n1;
		
	}
	
	
	static void printTree(TreeNode root,int space) {
	if(root==null) return ;
	
	space+=10;
	
	printTree(root.right, space);
	System.out.println();
	for (int i = 0; i < space; i++) {
		System.out.print(" ");
		
	}
	System.out.print(root.data);
	
	printTree(root.left, space);
	
		
}
	static int  heightOfTree(TreeNode root ,int init) {
		if(root==null) return 0;
		return Math.max(heightOfTree(root.left,init+1)+1, heightOfTree(root.right,init+1)+1);
	}
	
	static void preOrderIterative(TreeNode root) {
		if(root==null)System.out.println("null");
		Stack<TreeNode> s  = new Stack<TreeNode>();
		
		s.push(root);
		while(!s.isEmpty()) {
			TreeNode node  = s.pop();
			
			if(node!=null) {
				System.out.println(node.data+",");
				s.push(node.right);
				s.push(node.left);
			}
			
			
		}
	
	}
	
	
	static void postOrderIterative(TreeNode root) {
		Stack<TreeNode> s  = new Stack<TreeNode>();
		TreeNode node = root;
		while(true) {
			
		while(node!=null) {
			s.push(node.right);
			s.push(root);
			node=node.left;
			
			
			
		}
		if(s.isEmpty()) return;
		
		node = s.pop();
		if(!s.isEmpty()  && s.peek()==node) node = node.right;
		
		else {
			System.out.print(root.data + " , ");node=null;
		}
	
		}
		
		
		
	}
	
	
	static void inorder(TreeNode root) {
		if(root==null) return ;
		inorder(root.left);
		System.out.print(root.data +", ");
		inorder(root.right);
	}
	
	static void postorder(TreeNode root) {
		if(root==null) return ;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+", ");
		
	}
	
	static CheckBalanced isBalanced(TreeNode root) {
		if(root==null) return new CheckBalanced(true, -1);
		
		CheckBalanced left = isBalanced(root.left);
		if(!left.isBalanced) return left;
		
		CheckBalanced right = isBalanced(root.right);
		if(!right.isBalanced) return right;
		
		boolean testTree = Math.abs(right.height-left.height)<=1;
		int height = Math.max(right.height, left.height)+1;
		if(testTree) {
			CheckBalanced.setMacheight(CheckBalanced.maxHeight<=height?height:CheckBalanced.maxHeight);
		}
		return new CheckBalanced(testTree,height);
	}
	
	static boolean checkSymm(TreeNode root) {
		return root==null || checkSymmatricHelper(root.left,root.right);
	}
	private static boolean checkSymmatricHelper(TreeNode left, TreeNode right) {
		if(left==null && right==null) return true;
		
		if(left!=null && right!=null)return checkSymmatricHelper(left.left,right.right) && checkSymmatricHelper(left.right, right.left);
		
		return false;
	}

	
	static CheckLCA findLCA(TreeNode root , int r1, int r2) {
		
		if(root==null) return new CheckLCA();
		
		CheckLCA  left= findLCA(root.left, r1, r2);
		if(left.numOfNode==2) return left;
		CheckLCA right = findLCA(root.right, r1, r2);
		
		if(right.numOfNode==2) return right;
		
		int nON = (left.numOfNode+right.numOfNode );
		boolean tst = root.data==r1 ||  root.data==r2;
		nON+=(tst==true?1:0);
		
		System.out.println(root.data + " : " + (left.numOfNode) + " : "  + right.numOfNode + " : " + nON);
		
		return new CheckLCA(nON,nON==2?root:null);
		
	}
	
	static int sumtoLeaf(TreeNode root,int intermediate) {
		if(root==null)return 0;
		 intermediate = intermediate*10+root.data;
		if(root.left==null && root.right==null) return intermediate;
		
		return sumtoLeaf(root.left, intermediate)+sumtoLeaf(root.right, intermediate);
	}
	
	static boolean findSumExist(TreeNode root , int intermediate , int target) {
		if(root==null) return false;
		intermediate+=root.data;
		if(root.left==null && root.right==null) return intermediate==target;
		
		return findSumExist(root.left, intermediate, target) || findSumExist(root.right, intermediate, target);
	}
	
	
	static void inOrderIterative(TreeNode root) {
		
		Stack< TreeNode> st = new Stack<TreeNode>();
		
		if(root==null) System.out.println("null");
		TreeNode t = root;
		while(!st.isEmpty() || t!=null) {
			if(t!=null) {
				st.push(t);
				t=t.left;
			}
			else {
				t=st.pop();
				System.out.print(t.data + ",");
				t=t.right;
			}
			
		}
		
	}
}
class CheckBalanced{
	boolean isBalanced;
	int height;
	static int maxHeight;
	
	static void setMacheight(int staticMax) {
		maxHeight=staticMax;
	}
	
	public CheckBalanced(boolean isBalanced, int height) {
		super();
		this.isBalanced = isBalanced;
		this.height = height;
	}
	
	
}


class CheckLCA{
	int numOfNode;
	TreeNode ans =null;
	public CheckLCA() {
		numOfNode=0;ans=null;
	}
	public CheckLCA(int numOfNode, TreeNode ans) {
		
		this.numOfNode = numOfNode;
		this.ans = ans;
	}
	@Override
	public String toString() {
		
		return "CheckLCA [numOfNode=" + numOfNode + "";
	}
	
	
}
