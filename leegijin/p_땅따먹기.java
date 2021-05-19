public class p_땅따먹기 {
    public static void main(String[] args) {
        int [][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        System.out.println(solution(land));
    }
    static int solution(int[][] land) {
        int tmp=land.length;
        int [][] linesum = new int [land.length][4];
        int answer = 0;
        for(int i = 0; i<4; i++) {
            linesum[0][i]=land[0][i];
        }
        for(int i =1 ; i< land.length; i++) {
            linesum[i][0]=tmax(linesum[i-1][1],linesum[i-1][2],linesum[i-1][3])+land[i][0]; //1
            linesum[i][1]=tmax(linesum[i-1][0],linesum[i-1][2],linesum[i-1][3])+land[i][1]; //2
            linesum[i][2]=tmax(linesum[i-1][0],linesum[i-1][1],linesum[i-1][3])+land[i][2]; //3
            linesum[i][3]=tmax(linesum[i-1][0],linesum[i-1][1],linesum[i-1][2])+land[i][3]; //5
        }
        answer=Math.max(tmax(linesum[land.length-1][0],linesum[land.length-1][1],linesum[land.length-1][2]),linesum[land.length-1][3]);
        return answer;

    }
    private static int tmax(int a, int b, int c) {
        return Math.max(Math.max(a, b),c);
    }
}
