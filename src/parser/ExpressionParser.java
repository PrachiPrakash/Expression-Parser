/**
 * this program handles matematical expression with +, -,*,/
 * this algorithm uses the following grammar
 * 
 * E->E+T|E-T|T
 * T->T*F|T/F|F
 * F->id|(E)
 * 
 * @author Prachi Prakash
 */
package parser;

import tokenizer.ExpressionTokenizer;
import tokenizer.Token;

public class ExpressionParser 
{
	private ExpressionTokenizer exp;
	
	public ExpressionParser(String ex)
	{
		exp = new ExpressionTokenizer(ex);
	}
	
	/**
	 * this method implements the E derivation in grammar
	 * @return result
	 */
	public double evlExp()throws ParseError
	{
		boolean negative = false;
		
		if(exp.peek() == '-'){
			negative = true;
			exp.getNextToken();
		}
		
		double eval = evlTerm();
		
		
		if(negative)
			eval = -eval;
		
		while(exp.peek() == '+' || exp.peek() == '-'){
			
			Token tk1 = exp.getNextToken();
			double nextVal = evlTerm();
			
			switch(tk1.getLexeme().charAt(0)){
				case '+':
					eval = eval + nextVal;
					break;
				case '-':
					eval -= nextVal;
					break;
			}
		}
		
		return eval;
	}
	/**
	 * implement the T derivation of the grammar
	 * @return eval
	 * @throws ParseError
	 */
	private double evlTerm()throws ParseError
	{
		double eval = evlFactor();
		
		while(exp.peek() == '*' || exp.peek() == '/'){
			
			Token tk = exp.getNextToken();
			double nextVal = evlFactor();
			
			switch(tk.getLexeme().charAt(0)){
				case '*':
					eval = eval * nextVal;
					break;
				case '/':
					eval = eval / nextVal;
					break;
			}
		}
		return eval;
	}
	
	private double evlFactor()throws ParseError
	{
		
		
		if (!exp.hasNextToken())
			throw new ParseError("operand expexted");
		
		Token tk = exp.getNextToken();
		
		if(tk.getType() == 3)
			return Double.parseDouble(tk.getLexeme());
		
		else if(tk.getLexeme().equals("(")){
			double eval = evlExp();
			if(exp.peek() != ')')
				throw new ParseError(") Missing!!!");
			exp.getNextToken();
			return eval;
		}
		
		else if(tk.getType() == 1)
			throw new ParseError("Unxepected operator "+tk.getLexeme());
		else
			throw new ParseError("Unexpected symbol");
		
	}
		

}
