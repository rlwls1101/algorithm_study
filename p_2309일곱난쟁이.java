package leegijin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class p_2309일곱난쟁이 {
    //20
    //7
    //23
    //19
    //10
    //15
    //25
    //8
    //13
    static ArrayList <Integer> answer ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int []arr = new int [9];
        for(int i= 0 ; i<9 ; i++){
           arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        ArrayList<Integer> current = new ArrayList<>();
        boolean [] visit = new boolean[9];
        dfs(arr,current,visit,0,0);
        for(int tmp: answer){
            System.out.println(tmp);
        }
    }
    static void dfs(int[] arr, ArrayList<Integer> current, boolean visit[], int sum, int start){
        if(sum==100&&current.size()==7){
            Collections.sort(current);
           // answer = (ArrayList<Integer>) current.clone();
            answer=current;
        }
        for(int i=start; i<arr.length ; i++){
            if(!visit[i]) {
                current.add(arr[i]);
                visit[i]=true;
                start=start+1;
                dfs(arr, current, visit, sum +arr[i],start);
                current.remove(current.size()-1);
                visit[i]=false;
            }
        }
    }
}
