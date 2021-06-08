import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p_줄서는방법 {
    static int cnt =0;
    static ArrayList<Integer>ans = new ArrayList<>();
    public static void main(String[] args) {
        int n = 3;
        long k = 5;
        int [] tmp = solution(n,k);
        for(int t: tmp){
            System.out.println(t +" ");
        }
    }
    /*public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer>nl = new ArrayList<>();
        ArrayList<Integer>cu = new ArrayList<>();
        for(int i =1 ; i<=n ; i++){
            nl.add(i);
        }
        boolean check[]= new boolean[n];
        dfs(nl,cu,check,k);
        for(int i=0; i<answer.length; i++){
            answer[i]=ans.get(i);
        }
        return answer;
    }
    static void dfs(ArrayList<Integer>nl,ArrayList<Integer>cu,boolean[] check,long k){
        System.out.println("------------");
        if(cu.size()==nl.size()){
            cnt++;
            if(cnt==k){
                ans.addAll(cu);
            }
            return;
        }
        for(int i=0; i<nl.size(); i++){
            if(!check[i]){
                check[i]=true;
                cu.add(nl.get(i));
                dfs(nl,cu,check,k);
                check[i]=false;
                cu.remove(cu.size()-1);
            }
        }
    }*/
    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> res = new ArrayList<>();
        List<Integer> list = fillList(n);
        long dp[] = totalCount(n);

        while(true){
            long num = dp[n-1];

            if(k % num == 0){
                res.add(list.remove((int) ((k/num)-1)));
                break;
            }else{
                res.add(list.remove((int) ((k/num))));
                k %= num;
            }
            n--;
        }
        if(!list.isEmpty()){
            for(int i=list.size()-1; i>=0; i--)
                res.add(list.get(i));
        }

        for(int i=0;i<res.size();i++){
            answer[i] = res.get(i);
        }

        return answer;
    }

    private static List<Integer> fillList(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }

        return list;
    }

    private static long[] totalCount(int n) {
        long dp[] = new long[n+1];

        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] * i;
        }

        return dp;
    }
}
