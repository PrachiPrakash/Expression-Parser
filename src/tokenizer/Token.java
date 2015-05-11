package tokenizer;

public class Token 
{
	private String lexeme;
	private int type;
	
	public Token(String lexeme,int type)
	{
		this.lexeme = lexeme;
		this.type = type;
	}
	
	public String getLexeme() 
	{
		return lexeme;
	}
	
	public void setLexeme(String lexeme) 
	{
		this.lexeme = lexeme;
	}
	
	public int getType() 
	{
		return type;
	}
	
	public void setType(int type) 
	{
		this.type = type;
	}
	
	@Override
	public String toString()
	{
		return lexeme;
	}
	
}
