package com.ankit.MyDataStructure;

import com.ankit.ds.MyList;

public class ListMain {

	public static void main(String[] args) {
		MyList<Integer> list = new MyList<>();
		list.add(10);
		list.add(10);
		list.add(10);
		list.add(30);
		list.add(40);
		System.out.println(list);
		list.add(50);
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
	}
}
