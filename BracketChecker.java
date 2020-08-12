import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
	
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
}

class BracketChecker {
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();
    	
    	

        //creates stack
        //loops through string
        //stores char into variable
        Stack<Bracket> opening_brackets_stack = new Stack<Bracket>();
        for (int position = 0; position < text.length(); ++position) {
            char next = text.charAt(position);

            
            //opening bracket adds to stack
            if (next == '(' || next == '[' || next == '{') {
                // Process opening bracket, write your code here
            	Bracket bracket = new Bracket(next, position);
            	opening_brackets_stack.push(bracket);
            	
            	//checks if there is a closing bracket left in string
            	if(!text.substring(position).contains(")") || text.substring(position).contains("}") || 
            			text.substring(position).contains("]")){
            		System.out.println("Fail at position" + (position + 1));
            		return;
            	}
            }

            else if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
            	Bracket top = opening_brackets_stack.pop();
            	
            	//checks if closing bracket is correct
            	if(!top.Match(next)) {
            		System.out.println("Failure, look at position" + (position + 1));
            		return;
            	}
            }
        }

        // Printing answer, write your code here
        if(opening_brackets_stack.empty()) {
        	System.out.println("Success");
        }else {
        	System.out.println("Failure at position" + opening_brackets_stack.pop().position);
        }
    }
}
