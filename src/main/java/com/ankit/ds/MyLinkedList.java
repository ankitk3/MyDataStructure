package com.ankit.ds;

import java.util.Iterator;

public class MyLinkedList implements Iterable<String>{

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
	public void addAll(String ...data) {
		for(String dataStr : data) {
			add(dataStr);
		}
	}
	public void clear() {
		synchronized (this) {
			this.head=null;
			this.tail=null;
			this.next=null;
		}
	}
	public int size() {
		return this.size;
	}
	public void addFirst(String data) {
		this.add(data,0);
	}
	public void addLast(String data) {
		this.add(data);
	}
	public int indexOf(String data) {
		MyLinkedList my = head;
		int index=0;
		do {
			if(my.data.equals(data)) {
				return index;
			}
			my = my.next;
			index++;
		}while(my!=null);
		return -1;
	}
	public int lastIndexOf(String data) {
		int lastIndex=-1;
		MyLinkedList my = head;
		int index=0;
		do {
			if(my.data.equals(data)) {
				lastIndex=index;
			}
			my = my.next;
			index++;
		}while(my!=null);
		return lastIndex;
	}
	public void push(String ...data) {
		for(String dataStr : data) {
			add(dataStr);
		}
	}
	public String getFirst() {
		return head.data;
	}
	public String getLast() {
		return tail.data;
	}
	//removes head;
	public String pop() {
		MyLinkedList dt = head;
		this.head=head.next;
		this.next=head;
		size--;
		return dt.data;
	}
	//removes tail
	public String remove() {
		return null;
	}
	public String remove(int index) {
		if(0 == index) {
			pop();
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
		return null;
	}
	@Override
	public String toString() {
		return "\nMyLinkedList [data=" + data + ", next=" + next + ", size=" + size + "]\n";
	}
	public Iterator<String> iterator() {
		return new Iterator<String>() {
			MyLinkedList cur = head;
			public String next() {
				cur=cur.next;
				return cur.data;
			}
			
			public boolean hasNext() {
				return cur.next!=null;
			}
		};
	}
}
