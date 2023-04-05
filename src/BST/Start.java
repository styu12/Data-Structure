package BST;

public class Start {
	public static void main(String[] args) {
		AVLTree avl = new AVLTree();
		avl.insert(10);
		avl.insert(20);
		avl.insert(5);
		avl.insert(80);
		avl.insert(90);
		avl.insert(75);
		avl.insert(30);
		avl.insert(77);
		avl.insert(15);
		avl.insert(40);
		System.out.println(avl.search(30).item);
		System.out.println(avl.search(10).left);
		
	}
}
