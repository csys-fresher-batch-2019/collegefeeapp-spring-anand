package com.chainsys.util;

public class Logger {

	public static Logger getInstance()
	{
	return new Logger();
	}
	
	public void debug(Object message)
	{
		System.out.println(message);
	}
	
	public void info(Object message)
	{
		System.out.println(message);
	}
	
	public void error(Object message)
	{
	System.err.println(message);	
	}

}
