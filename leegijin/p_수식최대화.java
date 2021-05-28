import java.util.ArrayList;

public class p_수식최대화 {
    static char[] cal = { '+', '-', '*' };
    static boolean[] check = new boolean[3];
    static char[] tmp = new char[3];
    static ArrayList<Character> a = new ArrayList<Character>();
    static ArrayList<String> b = new ArrayList<String>();
    static long answer = 0;
    static String arr[];

    public static void main(String[] args) {
        String s="100-200*300-500+20";
        System.out.println(solution(s));
    }

    public static long solution(String s) {

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '-' || s.charAt(i) == '+' || s.charAt(i) == '*')
                a.add(s.charAt(i));
        }
        s = s.replace("-", " ");
        s = s.replace("*", " ");
        s = s.replace("+", " ");
        arr = s.split(" ");
        for (String arr1 : arr) {

            b.add(arr1);
        }

        dfs(0);
        return answer;

    }

    public static void dfs(int start) {
        if (start == 3) {
            // 수식을 돌린다

            long num = math();
            if (num < 0)
                num = num * -1;
            if (answer < num)
                answer = num;
        } else {
            for (int i = 0; i < 3; i++) {
                if (!check[i]) {
                    tmp[start] = cal[i];
                    check[i] = true;
                    dfs(start + 1);
                    check[i] = false;
                }
            }
        }
    }

    private static long math() {
        ArrayList<Character> k = new ArrayList<Character>();
        ArrayList<String> arr1 = new ArrayList<String>();
        k.addAll(a);
        arr1.addAll(b);

        while (k.size() != 0) {
            for (int i = 0; i < tmp.length; i++) {
                for (int j = 0; j < k.size(); j++) {
                    if (k.get(j) == tmp[i]) {
                        k.remove(j);


                        if (tmp[i] == '+') {
                            arr1.add(j, Long
                                    .toString(Long.parseLong(arr1.get(j)) + Long.parseLong(arr1.get(j + 1))));
                            arr1.remove(j + 1);
                            arr1.remove(j + 1);
                        }
                        if (tmp[i] == '-') {
                            arr1.add(j, Long
                                    .toString(Long.parseLong(arr1.get(j)) - Long.parseLong(arr1.get(j + 1))));
                            arr1.remove(j + 1);
                            arr1.remove(j + 1);
                        }
                        if (tmp[i] == '*') {
                            arr1.add(j, Long
                                    .toString(Long.parseLong(arr1.get(j)) * Long.parseLong(arr1.get(j + 1))));
                            arr1.remove(j + 1);
                            arr1.remove(j + 1);
                        }
                        j--;

                    }
                }
            }
        }

        return Long.parseLong(arr1.get(0));
    }
}
