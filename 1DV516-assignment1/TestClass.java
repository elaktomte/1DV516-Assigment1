package assignment1AADS.assignment1;

public class TestClass {

	public static void main(String[] args) {
		//TestTree();
		TestList();
	}

		public static void TestTree() {
			MyIntegerBST tree = new MyIntegerBST();
			tree.insert(10);
			tree.insert(20);
			tree.insert(25);
			tree.insert(7);
			tree.insert(4);
			tree.insert(9);
			tree.insert(8);

			//tree.printByLevels();
			//tree.printAll();
			tree.mostSimilarValue(18);
			tree.mostSimilarValue(21);
			tree.mostSimilarValue(24);
			tree.mostSimilarValue(1);
			tree.mostSimilarValue(9);
			tree.mostSimilarValue(15);
			tree.printAll();
			tree.printByLevels();
		}
		public static void TestList() {
			SequenceWithMinimum sqm = new SequenceWithMinimum();
			sqm.insertLeft(12);
			sqm.insertRight(14);
			sqm.insertLeft(13);
			sqm.printList();
			sqm.removeRight();
			sqm.printList();
			sqm.insertRight(17);
			sqm.printList();
			sqm.removeLeft();
			sqm.printList();
			System.out.println("Lowest value is: "+sqm.findMinimum());
			sqm.removeLeft();
			sqm.removeRight();
			sqm.printList();
			System.out.println(sqm.findMinimum());
		}
	
}
