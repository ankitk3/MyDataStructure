package com.ankit.MyDataStructure;

import java.util.Iterator;

import com.ankit.ds.MyLinkedList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
