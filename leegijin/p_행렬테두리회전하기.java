public class p_행렬테두리회전하기 {

    static int[][] matrix;

    public static void main(String[] args) {
        int rows =6;
        int colums =6;
        int [][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        int [] tmp =solution(rows,colums,queries);
        for(int t: tmp){
            System.out.println(t);
        }
    }
    public static int[] solution(int rows, int columns, int[][] queries) {
        matrix = new int[rows][columns];  // 행렬 생성
        int[] answer = new int[queries.length]; // 정답 배열

        for(int i = 0; i < rows; i++){  // 행렬 초기화
            for(int j = 0; j < columns; j++){
                matrix[i][j] = i*columns + j + 1;
            }
        }

        for(int i = 0; i < queries.length; i++){ // 회전하고 최솟값 answer에 저장
            answer[i] = rotate(queries[i]);
        }

        return answer;
    }

    public static int rotate(int[] query){
        int r1 = query[0]-1;
        int c1 = query[1]-1;
        int r2 = query[2]-1;
        int c2 = query[3]-1;

        int temp = matrix[r1][c1]; // 시작위치 값 임시저장
        int min = temp;                 // min값 초기화
        for(int i = r1; i < r2; i++){ // 회전의 1번
            matrix[i][c1] = matrix[i+1][c1];
            if(min > matrix[i][c1]) min = matrix[i][c1];
        }
        for(int i = c1; i < c2; i++){ // 회전의 2번
            matrix[r2][i] = matrix[r2][i+1];
            if(min > matrix[r2][i]) min = matrix[r2][i];
        }
        for(int i = r2; i > r1; i--){ // 회전의 3번
            matrix[i][c2] = matrix[i-1][c2];
            if(min > matrix[i][c2]) min = matrix[i][c2];
        }
        for(int i = c2; i > c1; i--){ // 회전의 4번
            matrix[r1][i] = matrix[r1][i-1];
            if(min > matrix[r1][i]) min = matrix[r1][i];
        }
        matrix[r1][c1+1] = temp; // 임시저장한 값 저장

        return min;
    }
}
