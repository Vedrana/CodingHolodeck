package basics.variousproblems;

import java.util.Stack;

// Given a string of opening and closing parentheses, check
// whether it�s balanced. We have 3 types of parentheses:
// round brackets: (), square brackets: [], and curly brackets: {}.
// Assume that the string doesn�t contain any other character
// than these, no spaces words or numbers. Just to remind, balanced
// parentheses require every opening parenthesis to be closed in the
// reverse order opened. For example �([])� is balanced but �([)]� is not.
//
// http://www.ardendertat.com/2011/11/08/programming-interview-questions-14-check-balanced-parentheses/
public class CheckBalancedParentheses {

    private Stack<String> parenthStack;

    public CheckBalancedParentheses() {
        this.parenthStack = new Stack<String>();
    }

    public boolean check(String parentheses) {
        parenthStack.clear();
        for (int i = 0; i < parentheses.length(); i++) {
            String p = parentheses.substring(i, i + 1);
            if (p.equals("(") || p.equals("[") || p.equals("{")) {
                parenthStack.add(parentheses.substring(i, i + 1));
            } else {
                if (parenthStack.isEmpty())
                    return false;
                String stackP = parenthStack.pop();
                if ((p.equals(")") && !stackP.equals("(")) ||
                        (p.equals("]") && !stackP.equals("[")) ||
                        (p.equals("}") && !stackP.equals("{"))) {
                    return false;
                }
            }
        }
        if (!parenthStack.isEmpty())
            return false;
        return true;
    }

    public static void main(String[] args) {
        CheckBalancedParentheses checkParenth = new CheckBalancedParentheses();
        System.out.println(checkParenth.check("[{]}")); // should be false
        System.out.println(checkParenth.check("([])")); // should be true
        System.out.println(checkParenth.check("([)]")); // should be false
        System.out.println(checkParenth.check("((((())))))")); // should be false
        System.out.println(checkParenth.check("(((({})))")); // should be false
    }
}
