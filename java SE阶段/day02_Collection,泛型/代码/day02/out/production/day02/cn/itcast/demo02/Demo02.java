// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Demo02.java

package cn.itcast.demo02;

import java.io.PrintStream;

public class Demo02
{

	public Demo02()
	{
	}

	public static void main(String args[])
	{
		int arr[] = new int[2];
		int ai[] = arr;
		int j = ai.length;
		for (int k = 0; k < j; k++)
		{
			int i = ai[k];
			System.out.println(i);
		}

	}
}
