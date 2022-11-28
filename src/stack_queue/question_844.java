package stack_queue;
import java.util.Stack;

import static java.lang.Character.compare;

public class question_844 {
    public boolean backspaceCompare(String S, String T) {
       Stack<Character> Sstack=new Stack<>();
       Stack<Character> Tstack=new Stack<>();
       Sstack=makeStack(S,Sstack);
       Tstack=makeStack(T,Tstack);
       return StackCompaile(Sstack,Tstack);
    }
    public Stack<Character> makeStack(String a,Stack<Character> stack){
        char c,b;
        for (int i = 0;i<a.length();i++){
            c=a.charAt(i);
            if(0==compare(c, '#')) {
                if(!stack.empty())
                    stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack;
    }
    public boolean StackCompaile(Stack a,Stack b){
        if(a.size()!=b.size())
            return false;
        while(!a.isEmpty()){
            if(a.peek()!=b.peek()){
                return false;
            }
            a.pop();
            b.pop();
        }
        return true;
    }
}
