// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Demo01Foreach.java

package cn.itcast.demo03_foreach;

import java.io.PrintStream;
import java.util.Arrays;

public class Demo01Foreach
{

	public Demo01Foreach()
	{
	}

	public static void main(String args[])
	{
		int intArr[] = {
			11, 22, 33, 44, 55
		};
		for (int i = 0; i < intArr.length; i++)
			System.out.println(intArr[i]);

		System.out.println("----------------------");
		double doubleArr[] = intArr;
		int j = doubleArr.length;
		for (int k = 0; k < j; k++)
		{
			int num = doubleArr[k];
			System.out.println(num);
		}

		System.out.println("----------------------");
		doubleArr = (new double[] {
			10.1D, 20.199999999999999D, 30.300000000000001D, 40.399999999999999D, 50.5D
		});
		int arr[] = doubleArr;
		int l = arr.length;
		for (int i1 = 0; i1 < l; i1++)
		{
			double num = arr[i1];
			System.out.println(num);
		}

		System.out.println("----------------------");
		arr = (new int[] {
			10, 20, 30, 40, 50
		});
		int ai[] = arr;
		int j1 = ai.length;
		for (int k1 = 0; k1 < j1; k1++)
		{
			int num = ai[k1];
			num += 2;
		}

		System.out.println(Arrays.toString(arr));
	}
}
