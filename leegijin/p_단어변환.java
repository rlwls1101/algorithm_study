public class p_단어변환 {
    public static void main(String[] args) {
        String [] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        String begin = "hit";
        String target ="cog";
        System.out.println(solution(begin,target,words));
    }
    static int ans =123456789;
    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visit = new boolean[words.length];
        dfs(words,begin,target,0,visit);
        answer =ans;
        if(answer==123456789)
            answer=0;
        return answer;
    }
    static void dfs(String[] words, String current, String target, int cnt,boolean[] visit){
        if(current.equals(target)){
            ans=Math.min(ans,cnt);
            return;
        }
        for(int i=0; i<words.length; i++){
            int tmp =0;
            for(int j=0; j<current.length(); j++){
                if(words[i].charAt(j)!=current.charAt(j))
                    tmp++;
            }
            if(tmp!=1)
                continue;
            else {
                if(!visit[i]) {
                    visit[i] = true;
                    dfs(words, words[i], target, cnt + 1, visit);
                    visit[i] = false;
                }
            }
        }
    }
}
