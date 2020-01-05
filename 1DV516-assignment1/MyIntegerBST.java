package assignment1AADS.assignment1;
import java.util.Iterator;

public class MyIntegerBST implements A1Tree {
	private TreeNode root;
	private int size = 0;
	private int depth = 0;
	int mostSim = 0;
	int compareSum = 0;

	@Override
	public void insert(Integer value) {
		// TODO Auto-generated method stub
		if (root == null) {
			root = new TreeNode(value,0,null);
			size++;
			depth = 0;
		}
		else {
			TreeNode compNode = root;
			while (compNode.getLeft() != null || compNode.getRight() != null) {
				if (value < compNode.getValue()) {
					if (compNode.getLeft() == null) {
						break;
					}
					compNode = compNode.getLeft();
				}
				else if (value > compNode.getValue()) {
					if (compNode.getRight() == null) {
						break;
					}
					compNode = compNode.getRight();
				}
				else if(value == compNode.getValue()) {
					break;
				}
			}	
			if (value < compNode.getValue()) {
				TreeNode newNode = new TreeNode(value, compNode.getLevel()+1 , compNode);
				compNode.setLeft(newNode);
				compareDepth(newNode);
				size++;
			}
			if (value > compNode.getValue()) {
				TreeNode newNode = new TreeNode(value, compNode.getLevel()+1 , compNode);
				compNode.setRight(newNode);
				compareDepth(newNode);
				size++;
			}

		}

	}

	@Override
	public Integer mostSimilarValue(Integer value) {
		mostSim = root.getValue();		// have to put this in case the root is actually the most similar one,
		compareSum = Math.abs(root.getValue() - value);
		
		if (value > root.getValue()) {
			visitForSimilar(root.getRight(), value);
		}
		if (value < root.getValue()) {
			visitForSimilar(root.getLeft(), value);
		}
		if (value == root.getValue()) {
			mostSim = root.getValue();
		}
		
		System.out.println("The most similar value for the Integer ("+value+") is : "+mostSim);
		return mostSim;
	}
	public void visitForSimilar(TreeNode node, Integer Value) {
		if (node.getLeft() != null) {
			visitForSimilar(node.getLeft(), Value);
		}
		int absolute = Math.abs(node.getValue()-Value);
		if(node.getValue() == Value) {
			compareSum= 0;
			mostSim = node.getValue();
		}

		else if(absolute < compareSum) {
			compareSum = absolute;
			mostSim = node.getValue();
		}
		if (node.getRight() != null) {
			visitForSimilar(node.getRight(), Value);
		}

	}

	@Override
	public void printByLevels() {
		// TODO Auto-generated method stub
		TreeIterator itr = new TreeIterator(size, depth ,root);
		itr.PrintLevels();


	}
	public void compareDepth(TreeNode node) {
		if (node.getLevel() > this.depth) {
			this.depth = node.getLevel();
		}
	}
	public void printAll() {
		TreeIterator itr = new TreeIterator(size, depth ,root);
		itr.printAllNodes();
	}
	public void visitAndCompare(TreeNode node) {  // rekursiv funktion för att kolla och jämnföra?

	}

}
class TreeNode {

	private int value;
	private TreeNode left;
	private TreeNode right;
	private TreeNode previous;
	private int level;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode getPrevious() {
		return previous;
	}

	public void setPrevious(TreeNode previous) {
		this.previous = previous;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}



	public TreeNode(int v, int l, TreeNode previous) {
		value = v;
		level = l;
		this.previous = previous;
	}

}
class ListNode{
	int value;
	ListNode next;

	public ListNode(int v) {
		this.value = v;
	}
}

// SKapa metoder för att sätta in saker i din ListNode array och så att dom traversar okej.

class TreeIterator implements Iterator{
	TreeNode[] Nodes;
	ListNode[] LevelArray;
	int i = 0;
	int itrCounter;

	public TreeIterator(int size, int depth, TreeNode root) {
		LevelArray = new ListNode[depth+1];
		Nodes = new TreeNode[size];
		Fill(root);
	}

	public void Fill(TreeNode node) {
		if (node.getLeft() != null) {
			Fill(node.getLeft());
		}
		Nodes[i] = node;
		i++;
		addToLevel(node);
		if (node.getRight() != null) {
			Fill(node.getRight());
		}
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return itrCounter<Nodes.length ;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		TreeNode node = Nodes[i];
		i++;
		return node;
	}
	public void addToLevel(TreeNode node) {
		int level = node.getLevel();
		if(LevelArray[level] == null) {
			LevelArray[level] = new ListNode(node.getValue());
		}
		else {
			ListNode temp = LevelArray[level];
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new ListNode(node.getValue());
		}
	}
	public void PrintLevels() {
		int counter = 0;
		ListNode lastNode = null;
		for (int j = 0; j < LevelArray.length; j++) {
			String printedStr = "Level "+j + ": ";
			if (LevelArray[j] != null) {
				lastNode = LevelArray[j];
			}
			while (lastNode != null) {
				printedStr += lastNode.value + " ";
				lastNode = lastNode.next;
			}
			System.out.println(printedStr);
		}

	}
	public void printAllNodes() {
		for (int j= 0; j<Nodes.length;j++) {
			System.out.println(Nodes[j].getValue());
		}
	}

}
