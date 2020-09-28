// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Demo03Exception.java

package cn.itcast.demo05_exception;

import java.io.PrintStream;

// Referenced classes of package cn.itcast.demo05_exception:
//			Person

public class Demo03Exception
{

	public Demo03Exception()
	{
	}

	public static void main(String args[])
	{
		Person p;
		Throwable throwable;
		Exception exception1;
		p = new Person();
		throwable = null;
		try
		{
			System.out.println("try...÷¥––¡À");
		}
		catch (Throwable throwable2)
		{
			throwable = throwable2;
			throw throwable2;
		}
		finally
		{
			if (throwable == null) goto _L0; else goto _L0
		}
		if (throwable != null)
			try
			{
				p.close();
			}
			catch (Throwable throwable1)
			{
				throwable.addSuppressed(throwable1);
			}
		else
			p.close();
		break MISSING_BLOCK_LABEL_85;
		try
		{
			p.close();
		}
		catch (Throwable throwable3)
		{
			throwable.addSuppressed(throwable3);
		}
		break MISSING_BLOCK_LABEL_78;
		p.close();
		throw exception1;
		Exception exception;
		exception;
	}
}
