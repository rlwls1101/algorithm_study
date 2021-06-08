import java.util.ArrayList;

public class p_하노이의탑 {
    static ArrayList<int[]> seq;
    public static void main(String[] args) {
        int n=5;
        int[][] tmp = solution(n);
        for(int[] t: tmp){
            for(int p : t){
                System.out.print(p+" ");
            }
            System.out.println();
        }
    }
    public static int[][] solution(int n) {
        seq = new ArrayList<>();

        hanoi(n, 1, 3, 2);

        int[][] answer = new int[seq.size()][2];
        for(int i = 0 ; i < seq.size() ; ++i){
            int[] cmd = seq.get(i);
            answer[i][0] = cmd[0];
            answer[i][1] = cmd[1];
        }

        return answer;
    }

    private static void hanoi(int n, int from, int to, int via){
        int[] move = {from, to};

        if(n == 1) {
            seq.add(move);
        } else {
            hanoi(n - 1, from, via, to);
            seq.add(move);
            hanoi(n - 1, via, to, from);
        }
    }
}
