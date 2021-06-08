import java.util.Arrays;

public class p_입국심사 {
    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        long tmp = solution(n, times);
        System.out.println(tmp);
    }

    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long right = (long)times[times.length-1]*(long)n;  // right 주의 !!
        answer=binarysearch(1,right,times,n);
        return answer;
    }

    public static long binarysearch(long left, long right ,int[] times,int n){
        long tmp =Long.MAX_VALUE;
        while(left<=right){
            long mid =(left+right)/2;
            if(check(mid,times,n)){
                if(tmp>mid){
                    tmp=mid;
                }
                right=mid-1;
            }
            else
                left=mid+1;
        }
        return tmp;

    }
    public static boolean check(long mid,int [] times,int n){
        long count=0;
        for(int i=0; i<times.length; i++){
            count=count+mid/times[i];
        }
        if(count>=n)
            return true;
        else
            return false;
    }
}
