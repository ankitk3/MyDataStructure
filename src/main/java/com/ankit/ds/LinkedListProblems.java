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
