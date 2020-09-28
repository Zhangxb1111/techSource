// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Demo02Generic.java

package cn.itcast.demo04_generic;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Demo02Generic
{

	public Demo02Generic()
	{
	}

	public static void main(String args[])
	{
		ArrayList list = new ArrayList();
		list.add("你好");
		list.add("我好");
		list.add("大家好");
		String str;
		for (Iterator iterator = list.iterator(); iterator.hasNext(); System.out.println(str))
			str = (String)iterator.next();

	}
}
