// Last updated: 2/4/2026, 12:58:07 PM
class Solution {
    public boolean isValid(String s) {
    Stack<Character> st1 = new Stack<>();
    for(int i =0;i<s.length();i++){
        if(s.charAt(i)=='('){
            st1.push(')');
        }
        else if(s.charAt(i)=='{'){
            st1.push('}');
        }
        else if(s.charAt(i)=='['){
            st1.push(']');
        }
        else if(!st1.isEmpty()&&(s.charAt(i)==')'||s.charAt(i)=='}'||s.charAt(i)==']')){
            if(st1.peek()==s.charAt(i)){
                st1.pop();
            }
            else return false;
        }
        else return false;
    }
    return st1.isEmpty();
    }
}