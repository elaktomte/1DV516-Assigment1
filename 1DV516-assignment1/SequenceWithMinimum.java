package assignment1AADS.assignment1;

public class SequenceWithMinimum implements A1SequenceWithMinimum{
	Node left = null;
	Node right = null;

	@Override
	public void insertRight(Integer value) {
		if (left == null && right == null) {
			left = new Node(value);
			right= left;
		}
		else {
			right.setNext(new Node(value));
			right.getNext().setPrevious(right);
			right = right.getNext();
		}

	}

	@Override
	public Integer removeRight() {
		int value;
		if (right == null) {
			System.out.println("there is no right node");
		}
		else if (left == right) {		// error handling if there is a single node left.
			value = right.getValue();
			left = null;
			right = null;
			return value;
		}
		else {
			value = right.getValue();
			right = right.getPrevious();
			right.setNext(null);
			return value;
		}
		value = (Integer) null;
		return value;
	}

	@Override
	public void insertLeft(Integer value) {
		if (left == null && right == null) {
			left = new Node(value);
			right= left;
		}
		else {
			left.setPrevious(new Node(value));
			left.getPrevious().setNext(left);
			left= left.getPrevious();
		}
	}

	@Override
	public Integer removeLeft() {
		int value;
		if (left == null) {
			System.out.println("There is no left node");
		}
		else if (left == right) {
			value = left.getValue();
			left = null;
			right = null;
			return value;
		}
		else {
			value = left.getValue();
			left = left.getNext();
			left.setPrevious(null);
			return value;
		}
		value = (Integer) null;
		return value;
	}

	@Override
	public Integer findMinimum() {
		int lowest = Integer.MAX_VALUE;
		if(left != null) {
		Node tempNode = left;
		while (tempNode.getNext() != null) {
			if (tempNode.getValue() < lowest) {
				lowest = tempNode.getValue();
			}
			tempNode = tempNode.getNext();
		}

		// TODO Auto-generated method stub
		return lowest;
		}
		else {
			return null;
		}
	}
	public void printList() {
		if (left == null) {
			System.out.println("There is no elements to print");
		}
		else {
			String str = "{";
			Node tempNode = left;
			while (tempNode.getNext() != null) {
				str = str +tempNode.getValue()+", ";
				tempNode = tempNode.getNext();
			}

			str +=+tempNode.getValue()+ "}";
			System.out.println(str);
		}
	}

	class Node {

		int Value;
		Node previous;
		Node next;

		public Node(int Value) {
			this.Value = Value;
		}

		public int getValue() {
			return Value;
		}

		public void setValue(int value) {
			Value = value;
		}

		public Node getPrevious() {
			return previous;
		}

		public void setPrevious(Node previous) {
			this.previous = previous;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}




	}
}

