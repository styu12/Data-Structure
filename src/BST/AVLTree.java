package BST;

public class AVLTree implements IndexInterface<AVLNode> {
	private AVLNode root;
	static final AVLNode NIL = new AVLNode(null, null, null, 0);
	
	public AVLTree() {
		root = NIL;
	}
	
	public AVLNode search(Comparable x) {
		return root = searchItem(root, x);
	}
	
	private AVLNode searchItem(AVLNode tNode, Comparable x) {
		
		if(tNode == NIL) return NIL;
		else if(x.compareTo(tNode.item) == 0) return tNode;
		else if(x.compareTo(tNode.item) < 0) return searchItem(tNode.left, x);
		else return searchItem(tNode.right, x);
	}
	
	public void insert(Comparable x) {
		root = insertItem(root, x);
	}
	
	private AVLNode insertItem(AVLNode tNode, Comparable x) {
		if(tNode == NIL) tNode = new AVLNode(x);
		else if(x.compareTo(tNode.item) < 0) {
			tNode.left = insertItem(tNode.left, x);
			tNode.height = 1 + Math.max(tNode.left.height, tNode.right.height);
			int type = needBalance(tNode);
			if(type != NO_NEED) tNode = balanceAVL(tNode, type);
		}	else {
			tNode.right = insertItem(tNode.right, x);
			tNode.height = 1 + Math.max(tNode.left.height, tNode.right.height);
			int type = needBalance(tNode);
			if(type != NO_NEED) tNode = balanceAVL(tNode, type);
		}
		return tNode;
	}
	
	public void delete(Comparable x) {
		root = deleteItem(root, x);
	}
	
	private AVLNode deleteItem(AVLNode tNode, Comparable x) {
		if(tNode == NIL) {
			System.out.println("Not Found");
			return NIL;
		}	else {
			if(x.compareTo(tNode.item) == 0) tNode = deleteNode(tNode);
			else if(x.compareTo(tNode.item) < 0) {
				tNode.left = deleteItem(tNode.left, x);
				tNode.height = 1 + Math.max(tNode.left.height, tNode.right.height);
				int type = needBalance(tNode);
				if(type != NO_NEED) tNode = balanceAVL(tNode, type);
			}	else {
				tNode.right = deleteItem(tNode.right, x);
				tNode.height = 1 + Math.max(tNode.left.height, tNode.right.height);
				int type = needBalance(tNode);
				if(type != NO_NEED) tNode = balanceAVL(tNode, type);
			}
			return tNode;
		}
	}
	
	private AVLNode deleteNode(AVLNode tNode) {
		if(tNode.left == NIL && tNode.right == NIL) return NIL;
		else if(tNode.left == NIL) return tNode.right;
		else if(tNode.right == NIL) return tNode.left;
		else {
			returnPair rPair = deleteMinItem(tNode.right);
			tNode.item = rPair.item; tNode.right = rPair.node;
			tNode.height = 1 + Math.max(tNode.left.height, tNode.right.height);
			int type = needBalance(tNode);
			if(type != NO_NEED) tNode = balanceAVL(tNode, type);
			return tNode;
			
		}
	}
	
	private returnPair deleteMinItem(AVLNode tNode) {
		int type;
		if(tNode.left == NIL) {
			return new returnPair(tNode.item, tNode.right);
		}	else {
			returnPair rPair = deleteMinItem(tNode.left);
			tNode.left = rPair.node;
			tNode.height = 1+ Math.max(tNode.left.height, tNode.right.height);
			type = needBalance(tNode);
			if(type != NO_NEED) tNode = balanceAVL(tNode, type);
			rPair.node = tNode;
			return rPair;
		}
	}
	
	private class returnPair {
		private Comparable item;
		private AVLNode node;
		private returnPair(Comparable item, AVLNode node) {
			this.item = item;
			this.node = node;
		}
	}
	
	private AVLNode balanceAVL(AVLNode tNode, int type) {
		AVLNode returnNode = NIL;
		switch(type) {
		case LL:
			returnNode = rightRotate(tNode);
			break;
		case LR:
			tNode.left = leftRotate(tNode.left);
			returnNode = rightRotate(tNode);
			break;
		case RR:
			returnNode = leftRotate(tNode);
			break;
		case RL:
			tNode.right = rightRotate(tNode.right);
			returnNode = leftRotate(tNode);
			break;
		default:
			System.out.println("Impossible type!!");
			break;
		}
		return returnNode;
	}
	
	private AVLNode leftRotate(AVLNode t) {
		AVLNode RChild = t.right;
		if(RChild == NIL) {
			System.out.println("ERROR");
			return NIL;
		}
		AVLNode RLChild = RChild.left;
		RChild.left = t;
		t.right = RLChild;
		t.height = 1 +  Math.max(t.left.height, t.right.height);
		RChild.height = 1+ Math.max(RChild.left.height, RChild.right.height);
		return RChild;
	}
	
	private AVLNode rightRotate(AVLNode t) {
		AVLNode LChild = t.left;
		if(LChild == NIL) {
			System.out.println("ERROR");
			return NIL;
		}
		AVLNode LRChild = LChild.right;
		LChild.right = t;
		t.left = LRChild;
		t.height = 1 + Math.max(t.left.height, t.right.height);
		LChild.height = 1 + Math.max(LChild.left.height, LChild.right.height);
		return LChild;
	}
	
	private final int LL=1, LR=2, RR=3, RL=4, NO_NEED=0, ILLEGAL=-1;
	private int needBalance(AVLNode t) {
		int type = ILLEGAL;
		if(t.left.height + 2 <= t.right.height) {
			if(t.right.left.height <= t.right.right.height) type=RR;
			else type = RL;
		}	else if(t.left.height >= t.right.height + 2) {
			if(t.left.left.height >= t.left.right.height) type=LL;
			else type = LR;
		}	else type = NO_NEED;
		return type;
	}
	
	public boolean isEmpty() {
		return root == NIL;
	}
	
	public void clear() {
		root = NIL;
	}
}
