public class p_멀쩡한사각형 {
    public static void main(String[] args) {
        int w =8;
        int h =12;
        System.out.println(solution(w,h));
    }
    public static long solution(int w, int h) {
        long answer = 1;

        long result =0;
        double a = (double)w/h;
        for(long i=1;i<h;i++) {
            result += Math.floor(a*i);
        }

        answer =result*2;
        return answer;
    }
}