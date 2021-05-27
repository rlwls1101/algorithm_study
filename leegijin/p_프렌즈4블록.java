
public class p_프렌즈4블록 {
    static char[][] boardC;
    static boolean[][] marked;
    static boolean finalFlag = true;

    public static void main(String[] args) {
        String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(4, 5, board));
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        boardC = new char[m][n];
        marked = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            boardC[i] = board[i].toCharArray();
        }


        while (finalFlag) {
            finalFlag = false;
            checkBlock(m, n);
            answer += processBlock(m, n);
            rearrangeBlock(m, n);
        }


        return answer;
    }

    static void checkBlock(int m, int n) {
        int[] dx = {0, 1, 1};
        int[] dy = {1, 0, 1};

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (boardC[i][j] == ' ') {
                    continue;
                }
                boolean flag = false;
                for (int k = 0; k < 3; k++) {
                    int x = i + dy[k];
                    int y = j + dx[k];
                    if (x >= 0 && y >= 0 && x < m && y < n) {
                        if (boardC[i][j] != boardC[x][y]) {
                            flag = true;
                            break;
                        }
                    }
                }

                if (!flag) {
                    finalFlag = true;
                    marked[i][j] = true;
                    for (int k = 0; k < 3; k++) {
                        int mx = i + dx[k];
                        int my = j + dy[k];
                        marked[mx][my] = true;
                    }
                }
            }
        }
    }

    static int processBlock(int m, int n) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (marked[i][j]) {
                    boardC[i][j] = ' ';
                    count += 1;
                }
            }
        }
        return count;
    }

    static void rearrangeBlock(int m, int n) {
        String tmpStr = "";
        for (int j = 0; j < n; j++) {
            tmpStr = "";
            for (int i = 0; i < m; i++) {
                tmpStr += boardC[i][j];
            }
            tmpStr = tmpStr.replaceAll(" ", "");

            for (int i = 0; i < tmpStr.length(); i++) {
                boardC[m - 1 - i][j] = tmpStr.charAt(tmpStr.length() - 1 - i);
                marked[m - 1 - i][j] = false;
            }

            if (m > tmpStr.length()) {
                int loop = m - tmpStr.length();
                for (int i = loop - 1; i >= 0; i--) {
                    boardC[i][j] = ' ';
                    marked[i][j] = false;
                }
            }

        }

    }


}