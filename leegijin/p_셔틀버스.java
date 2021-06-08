import java.util.*;
public class p_셔틀버스 {
    static HashMap<Integer, Stack<Integer>> map;
    static Queue<Integer> queue;
    static int[] keys;
    static int[] times;
    public static void main(String[] args) {
        int n =2;
        int t =10;
        int m=2;
        String[] timetable = {"09:10", "09:09", "08:00"};
        String ans = solution(n,t,m,timetable);
        System.out.println(ans);
    }
    public static String solution(int n, int t, int m, String[] timetable) {
        map = new HashMap<>();
        queue = new LinkedList<>();
        keys = new int[n];
        times = new int[timetable.length];
        for(int i = 0; i < times.length; i++){
            times[i] = changeTimeToInt(timetable[i]);
        }
        Arrays.sort(times);
        for(int time: times){
            queue.add(time);
        }

        for(int i = 0; i < n; i++){
            map.put(540 + t * i, new Stack<>());
            keys[i] = 540 + t * i;
        }

        int key_cnt = 0;
        while (key_cnt < n){
            if(queue.isEmpty())
                break;
            if(keys[key_cnt] >= queue.peek() && map.get(keys[key_cnt]).size() < m){
                map.get(keys[key_cnt]).push(queue.poll());
            }else{
                key_cnt++;
            }
        }

        if(map.get(keys[keys.length-1]).size() < m){
            return changeTimeToString(keys[keys.length-1]);
        }
        else{
            return changeTimeToString(map.get(keys[keys.length-1]).peek()-1);
        }
    }
    static int changeTimeToInt(String time){
        return Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3,5));
    }

    static String changeTimeToString(int time){
        String hours = Integer.toString(time/60);
        String minutes = Integer.toString(time%60);
        hours = hours.length() < 2 ? "0"+hours : hours;
        minutes = minutes.length() < 2 ? "0"+minutes : minutes;
        return hours+":"+minutes;
    }
}
