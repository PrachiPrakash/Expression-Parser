package test;

import parser.ExpressionParser;
import parser.ParseError;

public class TestClass 
{
	public static void main(String args[])
	{
		ExpressionParser pr = new ExpressionParser("-(2*10)+10");
		try{
			System.out.println(pr.evlExp());
		}
		catch(ParseError e){
			System.out.println(e);
		}
	}
}
