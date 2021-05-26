public class p_2개이하로다른비트 {
    public static void main(String[] args) {
        long[] numbers ={2,7};
        long[] ans = solution(numbers);
        for(long tmp: ans){
            System.out.println(tmp);
        }
    }
    public static long[] solution(long[] numbers) {
        long[] answer =new long[numbers.length];
        for(int i=0; i<numbers.length ; i++){
            if(numbers[i]%2==0){
                answer[i]=numbers[i]+1;
            }
            else{
                String tmp="0"+Long.toBinaryString(numbers[i]);
                StringBuilder sb = new StringBuilder(tmp);
                int tm=sb.lastIndexOf("0");
                sb.setCharAt(tm,'1');
                sb.setCharAt(sb.indexOf("1",tm+1),'0');
                answer[i]=Long.parseLong(sb.toString(),2);
            }
        }
        return answer;
    }
}
