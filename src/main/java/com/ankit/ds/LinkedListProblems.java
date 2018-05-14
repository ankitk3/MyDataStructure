package com.ankit.ds;

public class LinkedListProblems {

	public static Node node = getNode();
	public static void resetNode() {
		node = getNode();
	}
	public static int countSize() {
		int count=0;
		while(node!=null) {
			count++;
			node=node.next;
		}
		return count;
	}
	public static int countOccurence(int data) {
		int count=0;
		while(node!=null) {
			if(data==node.data) {
				count++;
			}
			node=node.next;
		}
		return count;
	}
	public static int getNthData(int index) {
		Node copy = node;
		int data=-1;
		if(index < 0) {
			return data;
		}
		while(copy!=null && index-- > 0) {
			copy=copy.next;
		}
		if(copy!=null) {
			return copy.data;
		}
		return data;
	}
	public static void deleteList() {
		System.out.println("size before deletion"+countSize());
		delete(node); //Set all next node to null recursively, to free memory;
		node=null; // Set the head to null
		System.out.println("size After deletion"+countSize());
	}
	private static void delete(Node node) {
		if(node==null) {
			return;
		}
		if(node !=null && node.next != null) {
			delete(node.next);
			node.next=null;
		}
		node.data=-1;
	}
	public static int pop() {
		if(node==null) {
			return -1;
		}
		int data = node.data;
		node = node.next;
		return data;
	}
	public static boolean insertNth(int data, int index) {
		if(node==null) {
			node=new Node(data);
			return true;
		}
		if(index==0) {
			Node newNode = new Node(data);
			newNode.setNext(node);
			node=newNode;
			return true;
		}
		Node copy = node;
		while(copy!=null && --index > 0) {
			copy = copy.next;
		}
		if(copy==null) {
			return false;
		} else {
			Node next = copy.next;
			copy.next=new Node(data);
			copy.next.next=next;
			return true;
		}
	}
	public static boolean sortedInsert(int data) {
		sortedInsert(node, data);
		return true;
	}
	public static Node sortedInsert(Node node, int data) {
		if(node==null) {
			node=new Node(data);
			return node;
		}
		Node copy = node;
		if(data < copy.data) {
			Node newNode = new Node(data);
			newNode.setNext(node);
			node=newNode;
			return node;
		}
		while(copy!=null) {
			Node previous = copy;
			copy=copy.next;
			if(copy == null || data <= copy.data) {
				Node newNode = new Node(data);
				previous.next=newNode;
				newNode.next=copy;
				return node;
			}
		}
		return node;
	}
	public static boolean sort() {
		if(node==null) {
			return false;
		}
		Node newNodeList=null;
		Node copy = node;
		while(copy!=null) {
			newNodeList = sortedInsert(newNodeList, copy.data);
			copy=copy.next;
		}
		node = newNodeList;
		return true;
	}
	public static Node append(Node a, Node b) {
		if(a == null && b == null) {
			return null;
		}
		if(b==null) {
			return a;
		}
		if (a == null) {
			return b;
		}
		Node previous=a;
		Node copy = a;
		while(copy!=null) {
			previous=copy;
			copy=copy.next;
		}
		previous.next=b;
		return a;
	}
	public static void frontBackSplit() {
		Node copy = node;
		Node slow = node;
		Node previous=node;
		boolean isChange=false;
		int totCount=0;
		while(copy!=null) {
			copy=copy.next;
			if(isChange) {
				previous=slow;
				slow=slow.next;
			}
			isChange = !isChange;
			totCount++;
		}
		System.out.println(totCount);
		System.out.println(slow.data+"::");
		Node newNode=null;
		if(totCount%2==0) {
			newNode = previous.next;
			previous.next=null;
		} else {
			newNode = slow.next;
			slow.next=null;
		}
		System.out.println("First node = "+node);
		System.out.println("Second node = "+newNode);
	}
	/**
	 * Pops node from a and adds to node b
	 * @param a
	 * @param b
	 */
	public static void moveNode(Node a, Node b) {
		System.out.println("Before "+a+"::"+b);
		Node copy = a;
		a=a.next;
		Node copy2 = b;
		Node previous2 = copy2;
		while(copy2!=null) {
			previous2=copy2;
			copy2=copy2.next;
		}
		previous2.next=copy;
		copy.next=null;
		System.out.println("After "+a+"::"+b);
	}
	public static void removeDuplicateFromSortedList() {
		node.getNext().getNext().getNext().getNext().getNext().setNext(new Node(25));
		Node copy = node;
		Node previous=node;
		while(copy!=null) {
			previous = copy;
			copy = copy.next;
			if(previous.data == copy.data) {
				copy = copy.next;
				previous.next=copy;
			}
		}
		System.out.println("Removing duplicates node is "+node);
	}
	public static void alternateSplit() {
		Node first=null,original=null;
		Node second=null,orig2=null;
		Node copy = node;
		int count = 0;
		while(copy!=null) {
			if(count%2==0) {
				if(first==null) {
					first=copy;
					original=first;
				}else {
					first.next=copy;
					first=first.next;
				}
				
			} else {
				if(second==null) {
					second=copy;
					orig2=second;
				} else {
					second.next=copy;
					second=second.next;
				}
			}
			copy=copy.next;
			count++;
		}
		System.out.println("Alternate split "+original+"::"+orig2);
	}
	public static Node appendTwoList(Node firstNode, Node secondNode) {
		if(firstNode==null && secondNode==null) {
			return null;
		}
		if(firstNode == null) {
			return secondNode;
		}
		if(secondNode == null) {
			return firstNode;
		}
		Node lastNode=null;
		Node copy = firstNode;
		while(copy!=null) {
			lastNode=copy;
			copy=copy.next;
		}
		lastNode.next = secondNode;
		return firstNode;
	}
	public static class Node{
		private int data;
		private Node next;
		
		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node(int data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
	}
	public static Node getNode() {
		Node node = new Node(5);
		node.setNext(new Node(10));
		node.getNext().setNext(new Node(10));
		node.getNext().getNext().setNext(new Node(15));
		node.getNext().getNext().getNext().setNext(new Node(20));
		node.getNext().getNext().getNext().getNext().setNext(new Node(25));
		return node;
	}
	public static Node getDescNode() {
		Node node = new Node(50);
		node.setNext(new Node(40));
		node.getNext().setNext(new Node(45));
		node.getNext().getNext().setNext(new Node(30));
		node.getNext().getNext().getNext().setNext(new Node(20));
		node.getNext().getNext().getNext().getNext().setNext(new Node(10));
		return node;
	}
}
