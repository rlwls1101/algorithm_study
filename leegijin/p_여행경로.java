import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
//[["ICN", "SFO"], ["SFO", "ICN"], ["ICN", "SFO"], ["SFO", "QRE"]]
// ["ICN", "SFO", "ICN", "SFO", "QRE"]
//[["ICN", "COO"], ["ICN", "BOO"], ["COO", "ICN"], ["BOO", "DOO"]]
//
//[["ICN", "BOO"], ["ICN", "COO"], ["COO", "DOO"], ["DOO", "COO"], ["BOO", "DOO"], ["DOO", "BOO"], ["BOO", "ICN"], ["COO", "BOO"]]
// ["ICN", "BOO", "DOO", "BOO", "ICN", "COO", "DOO", "COO", "BOO"]
public class p_여행경로 {
    static ArrayList<trip>ans = new ArrayList<>();
    static class trip{
        String start;
        String end;

        public trip(String start, String end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        String[][] tickets ={{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}};
        String[]  ans = solution(tickets);
        for(String s: ans){
            System.out.println(s);
        }
    }
    public static String[] solution(String[][] tickets) {

        ArrayList<trip>tl = new ArrayList<trip>();
        ArrayList<trip>current = new ArrayList<trip>();
        for(String[] tmp : tickets){
            tl.add(new trip(tmp[0],tmp[1]));
        }
        Collections.sort(tl, new Comparator<trip>() {
            @Override
            public int compare(trip o1, trip o2) {
                if(o1.start.compareTo(o2.start)>0){
                    return 1;
                }
                else if(o1.start.compareTo(o2.start)<0){
                    return -1;
                }
                else{
                    if(o1.end.compareTo(o2.end)>=0){
                        return 1;
                    }
                    else
                        return -1;
                }
            }
        });
        boolean[] check = new boolean[tl.size()];
        for(int i =0; i<tl.size(); i++){
            if(tl.get(i).start.equals("ICN")){
                current.add(tl.get(i));
                check[i]=true;
                dfs(tl,current,check);
                check[i]=false;
                current.remove(current.size()-1);
            }
        }
        String[] answer = new String[tl.size()+1];
        answer[0]="ICN";
        for(int i=0 ; i<ans.size(); i++){
            answer[i+1]=ans.get(i).end;
        }
        return answer;
    }
    static void dfs(ArrayList<trip>tl,ArrayList<trip>current,boolean[] check){
        for(trip tt: current){
            System.out.println(tt.start+"  "+tt.end);
        }
        System.out.println("----------------------------------");
        if(current.size()==tl.size()){

            if(ans.isEmpty()){
                ans.addAll(current);
            }
            return;
        }
        for(int i =0; i<tl.size(); i++){
            if(!check[i]&&current.get(current.size()-1).end.equals(tl.get(i).start)){
                check[i]=true;
                current.add(tl.get(i));
                dfs(tl,current,check);
                check[i]=false;
                current.remove(current.size()-1);
            }
        }
    }
}
