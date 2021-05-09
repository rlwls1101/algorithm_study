package leegijin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class p_2210숫자판점프 {
    //1 1 1 1 1
    //1 1 1 1 1
    //1 1 1 1 1
    //1 1 1 2 1
    //1 1 1 1 1
    static int dx [] = {1,0,-1,0};
    static int dy [] = {0,1,0,-1};
    static HashMap<String, Integer> testData = new HashMap<String, Integer>();
    public static void main(String[] args) throws IOException {
        String[][] arr= new String [5][5];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<5; i++){
            StringTokenizer s = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<5; j++){
                arr[i][j]= s.nextToken();
            }
        }
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                search(arr,i,j,"");
            }
        }

        System.out.println(testData.size());
    }
    static void search(String arr[][], int x, int y, String current){
        current=current+arr[x][y];
        if(current.length()==6){
            testData.put(current, 1);
            return;
        }
        for(int i =0 ; i<4; i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 &&nx<5&&ny>=0&&ny<5){
                search(arr,nx,ny,current);
            }
        }
    }
}
