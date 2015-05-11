package parser;

public class ParseError extends Exception 
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8558997043961123104L;

	public ParseError(String msg)
	{
		super(msg);
	}
	
	@Override
	public String toString()
	{
		return getMessage();
	}
	
	
}
