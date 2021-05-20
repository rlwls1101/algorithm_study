public class p_n으로표현 {
    public static void main(String[] args) {
        int N= 5;
        int number =12;
        System.out.println(solution(N,number));
    }
    static int n;
    static int target;
    static int answer = 123456789;

    public static int solution(int N, int number) {
        n = N;
        target = number;
        dfs(0, 0);
        return answer == 123456789 ? -1 : answer;
    }

    private static void dfs(int count, int prev) {
        if (count > 8) {
            answer = -1;
            return;
        }

        if (prev == target) {
            answer = Math.min(answer, count);
            return;
        }

        int tempN = n;

        for (int i = 0; i < 8 - count; i++) {
            int newCount = count + i + 1;
            dfs(newCount, prev + tempN);
            dfs(newCount, prev - tempN);
            dfs(newCount, prev / tempN);
            dfs(newCount, prev * tempN);

            tempN = tempN * 10 + n;
        }
    }
}