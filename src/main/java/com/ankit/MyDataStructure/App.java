package com.ankit.MyDataStructure;

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
        System.out.println(list);
    }
}
