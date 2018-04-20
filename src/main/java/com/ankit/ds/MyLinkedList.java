package com.ankit.ds;

public class MyLinkedList {

	private String data;
	private MyLinkedList next;
	private MyLinkedList head;
	private MyLinkedList tail;
	int size;
	public MyLinkedList() {
		
	}
	private MyLinkedList(String data) {
		this.data=data;
	}
	public void add(String data) {
		MyLinkedList newNode = new MyLinkedList(data);
		if(head == null) {
			next = newNode;
			head = newNode;
			tail = newNode;
		} else {
			tail.next=newNode;
			tail = newNode;
		}
		size++;
	}
	public void add(String data, int index) {
		if(0 == index) {
			MyLinkedList newNode = new MyLinkedList(data);
			MyLinkedList nextOne = head;
			head = newNode;
			next = newNode;
			newNode.next=nextOne;
		} else if(size == index) {
			add(data);
		} else {
			MyLinkedList newNode = new MyLinkedList(data);
			MyLinkedList current = this.head;
			int i=1;
			while(i<index) {
				current = current.next;
				i++;
			}
			MyLinkedList next = current.next;
			current.next=newNode;
			newNode.next=next;
		}
		size++;
	}
	@Override
	public String toString() {
		return "\nMyLinkedList [data=" + data + ", next=" + next + ", size=" + size + "]\n";
	}
}
