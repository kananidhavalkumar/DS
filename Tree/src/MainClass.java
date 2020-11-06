

public class MainClass {
	public static void main(String[] a) {
		TreeNode root = TreeNode.makingHeight(3,0);
//		TreeNode.inorder(root);
//		TreeNode.printTree(root, 0);
		//root.left.left=null;
//		TreeNode.printTree(root, 10);
//		System.out.println();
//		TreeNode.postorder(root);
	//	TreeNode.postOrderIterative(root);
		System.out.println(TreeNode.findLCA(root, 5,6).ans.data);
	}
	
	
}
