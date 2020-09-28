// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Demo01.java

package cn.itcast.demo02;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Demo01
{

	public Demo01()
	{
	}

	public static void main(String args[])
	{
		ArrayList list = new ArrayList();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		String s;
		for (Iterator iterator = list.iterator(); iterator.hasNext(); System.out.println(s))
			s = (String)iterator.next();

	}
}
