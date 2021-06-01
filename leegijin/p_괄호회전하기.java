import java.util.Stack;

public class p_괄호회전하기 {
    public static void main(String[] args) {
        String s = "[](){}";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 0;
        for(int i=0; i<s.length(); i++){
            Stack<String> st = new Stack();
            s = s.substring(1,s.length())+s.substring(0,1);
            for(int j=0; j<s.length(); j++){
                String word = s.substring(j,j+1);
                if(st.isEmpty()){
                    st.push(word);
                    continue;
                }

                if(word.equals(")") && st.peek().equals("(")){
                    st.pop();
                }else if(word.equals("}") && st.peek().equals("{")){
                    st.pop();
                }else if(word.equals("]") && st.peek().equals("[")){
                    st.pop();
                }else{
                    st.push(word);
                }
            }

            if(st.isEmpty()){
                answer++;
            }

        }
        return answer;
    }
}
