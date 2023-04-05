package BST;

public class BinarySearchTree implements IndexInterface<TreeNode> {
	private TreeNode root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public TreeNode search(Comparable searchKey) {
		return searchItem(root, searchKey);
	}
	
	private TreeNode searchItem(TreeNode tNode, Comparable searchKey) {
		if(tNode == null) return null;
		else if(searchKey.compareTo(tNode.key) == 0) return tNode;
		else if(searchKey.compareTo(tNode.key) > 0) return searchItem(tNode.right, searchKey);
		else return searchItem(tNode.left, searchKey);
		
	}
	
	public void insert(Comparable newKey) {
		root = insertItem(root, newKey);
	}
	
	private TreeNode insertItem(TreeNode tNode, Comparable newKey) {
		if(tNode == null) {
			tNode = new TreeNode(newKey);
		}	else if(newKey.compareTo(tNode.key) > 0) {
			tNode.right = insertItem(tNode.right, newKey);
		}	else {
			tNode.left = insertItem(tNode.left, newKey);
		}
		return tNode;
	}
	
	public void delete(Comparable searchKey) {
		root = deleteItem(root, searchKey);
	}
	
	private TreeNode deleteItem(TreeNode tNode, Comparable searchKey) {
		if(tNode == null) return null;
		else {
			if(searchKey.compareTo(tNode.key) == 0) {
				tNode = deleteNode(tNode);
			}	else if(searchKey.compareTo(tNode.key) > 0) {
				tNode.right = deleteItem(tNode.right, searchKey);
			}	else {
				tNode.left = deleteItem(tNode.left, searchKey);
			}
		}
		return tNode;
	}
	
	private TreeNode deleteNode(TreeNode tNode) {
		if(tNode.left == null && tNode.right == null) {
			tNode = null;
		}	else if(tNode.right == null) {
			tNode = tNode.left;
		}	else if(tNode.left == null) {
			tNode = tNode.right;
		}	else {
			returnPair rPair = deleteMinItem(tNode.right);
			tNode.key = rPair.key; tNode.right = rPair.node;
		}
		return tNode;
	}
	
	private returnPair deleteMinItem(TreeNode tNode) {
		if(tNode.left == null) {
			return new returnPair(tNode.key, tNode.right);
		}	else {
			returnPair rPair = deleteMinItem(tNode.left);
			tNode.left = rPair.node;
			rPair.node = tNode;
			return rPair;
		}
	}
	
	private class returnPair {
		private Comparable key;
		private TreeNode node;
		private returnPair(Comparable key, TreeNode node) {
			this.key = key;
			this.node = node;
		}
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void clear() {
		root = null;
	}
	
}
