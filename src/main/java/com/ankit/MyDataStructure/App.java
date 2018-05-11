package com.ankit.MyDataStructure;

import java.util.Iterator;

import com.ankit.ds.LinkedListProblems;
import com.ankit.ds.LinkedListProblems.Node;
import com.ankit.ds.MyLinkedList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        //operation();
    	LinkedListProblems.resetNode();
    	System.out.println(LinkedListProblems.countOccurence(10));
    	System.out.println(LinkedListProblems.countOccurence(5));
    	System.out.println(LinkedListProblems.countOccurence(15));
    	LinkedListProblems.resetNode();
    	System.out.println(LinkedListProblems.getNthData(0));
    	System.out.println(LinkedListProblems.getNthData(4));
    	System.out.println(LinkedListProblems.getNthData(2));
    	LinkedListProblems.resetNode();
    	LinkedListProblems.deleteList();
    	LinkedListProblems.resetNode();
    	System.out.println(LinkedListProblems.pop());
    	System.out.println(LinkedListProblems.pop());
    	System.out.println(LinkedListProblems.pop());
    	LinkedListProblems.resetNode();
    	System.out.println(LinkedListProblems.node);
    	System.out.println(LinkedListProblems.insertNth(1, 0));
    	System.out.println(LinkedListProblems.insertNth(500, 3));
    	System.out.println(LinkedListProblems.insertNth(1000, 8));
    	System.out.println(LinkedListProblems.node);
    	LinkedListProblems.resetNode();
    	System.out.println("Before inserted sort "+LinkedListProblems.node);
    	System.out.println(LinkedListProblems.sortedInsert(4));
    	System.out.println(LinkedListProblems.sortedInsert(14));
    	System.out.println(LinkedListProblems.sortedInsert(1400));
    	System.out.println("After inserted sort "+LinkedListProblems.node);
    	LinkedListProblems.node=LinkedListProblems.getDescNode();
    	System.out.println("Before sort "+LinkedListProblems.node);
    	System.out.println(LinkedListProblems.sort());
    	System.out.println("After sort "+LinkedListProblems.node);
    	LinkedListProblems.resetNode();
    	System.out.println("Before merge "+LinkedListProblems.node);
    	System.out.println(LinkedListProblems.appendTwoList(LinkedListProblems.getNode(), LinkedListProblems.getDescNode()));
    }
    private static void operation() {
    	MyLinkedList list = new MyLinkedList();
        list.add("Ankit");
        list.add("Kalra");
        list.add("ccccc");
        list.add("dddd");
        list.add("beech me",3);
        list.add("start me",0);
        list.add("last me",6);
        list.add("Ankit");
        System.out.println(list);
        System.out.println(list.indexOf("beech me"));
        System.out.println(list.indexOf("start me"));
        System.out.println(list.indexOf("last me"));
        System.out.println(list.indexOf("Ankit"));
        System.out.println(list.lastIndexOf("Ankit"));
        System.out.println(list.pop());
        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
        	System.out.println(it.next());
        }
    }
}
