package com.ankit.ds;

public class MyList<T> {

	private int threshold = 0;
	private int capacity = 5;
	private int curIndex=0;
	private Object arr[];
	public MyList() {
		this.arr = new Object[capacity];
	}
	public MyList(int capacity) {
		this.capacity = capacity;
		this.arr = new Object[capacity];
	}
	private void rebalance() {
		synchronized (this) {
			Object copy[] = new Object[capacity*2];
			for(int i =0;i<arr.length;i++) {
				copy[i]=arr[i];
			}
			arr = copy;
		}
	}
	public void add(T t) {
		if(threshold == capacity) {
			rebalance();
		}
		arr[curIndex++]=t;
		threshold++;
	}
	public void addAll(T ...tArr) {
		if(threshold == capacity) {
			rebalance();
		}
		while(capacity < tArr.length) {
			rebalance();
		}
		for(T t : tArr) {
			add(t);
		}
	}
	public T remove(int index) {
		if(index <0 || index > curIndex) {
			throw new RuntimeException("Index not present");
		}
		T t = (T)arr[index];
		shiftArray(index, curIndex);
		arr[curIndex-1]=null;
		curIndex--;
		threshold--;
		return t;
	}
	private void shiftArray(int fromIndex, int toIndex) {
		while(fromIndex < toIndex-1) {
			arr[fromIndex] = arr[fromIndex+1];
			fromIndex++;
		}
	}
	public int remove(T value) {
		int index=0;
		for(Object obj : arr) {
			T t = (T)obj;
			if(t == value) {
				remove(index);
				break;
			}
			index++;
		}
		return index;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(Object t : arr) {
			sb.append(t+" ");
		}
		return sb.toString();
	}
}
