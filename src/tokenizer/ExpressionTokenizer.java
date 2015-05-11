package tokenizer;

public class ExpressionTokenizer 
{
	private String expr;
	private int curr;

	public ExpressionTokenizer(String expr) 
	{
		// TODO Auto-generated constructor stub
	
		this.expr = expr;
		curr = 0 ;
	}
	public boolean hasNextToken()
	{
		if (curr < expr.length())
			return true;
		else 
			return false;
	}
	
	public Token getNextToken()
	{
		String lexeme = "";
		
		while(expr.charAt(curr) == ' ')
			curr++;
		
		if (expr.charAt(curr) =='(' || expr.charAt(curr) == ')')
				return new Token(""+expr.charAt(curr++),0);
		
		if(expr.charAt(curr) =='+' || expr.charAt(curr) =='-' ||
				expr.charAt(curr) == '*' || expr.charAt(curr) == '/'
				) 
			return new Token(expr.charAt(curr++)+"", 1);
		
		
		while(curr < expr.length() && expr.charAt(curr) !='+' && expr.charAt(curr) !='-' &&
				expr.charAt(curr) != '*' && expr.charAt(curr) != '/' &&
				expr.charAt(curr) !='(' && expr.charAt(curr) != ')' &&
				expr.charAt(curr) != ' '){
			
			
			lexeme += expr.charAt(curr);
			curr++;
			
			
					
		}
		return new Token(lexeme,3);
			
			
	}
	
	public char peek()
	{
		if(curr < expr.length())
			return expr.charAt(curr);
		else
			return '0';
	}
}
