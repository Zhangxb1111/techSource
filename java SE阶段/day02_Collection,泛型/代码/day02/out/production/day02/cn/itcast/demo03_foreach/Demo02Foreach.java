// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Demo02Foreach.java

package cn.itcast.demo03_foreach;

import java.io.PrintStream;
import java.util.*;

public class Demo02Foreach
{

	public Demo02Foreach()
	{
	}

	public static void main(String args[])
	{
		Collection c1 = new ArrayList();
		c1.add("����");
		c1.add("����");
		c1.add("������");
		String str;
		for (Iterator iterator = c1.iterator(); iterator.hasNext(); System.out.println(str))
			str = (String)iterator.next();

	}
}
