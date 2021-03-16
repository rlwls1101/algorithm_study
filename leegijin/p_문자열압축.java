package leegijin;

public class p_문자열압축 {
    public static void main(String[] args) {
        String s = "abcabcabcabcdededededede";
        System.out.println(solution(s));
    }
    public static int solution(String s) {
        int min = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {

            int count = 1;
            String compress_string = "";  //압축한 스트링
            String sub = ""; // 비교스트링

            for (int j = 0; j <= s.length() + i; j += i) {

                String current;  //압축할스트링

                if (j >= s.length()) {  //스트링의길이가 넘어간경우 다음스트링이 없다
                    current = "";
                } else if (s.length() < j + i) {  //마지막인경우 스트링 j위치부터 끝까지
                    current = s.substring(j);
                } else {
                    current = s.substring(j, j + i);  // 평범할경우
                }

                if (j != 0) {
                    if (current.equals(sub)) { // 똑같으면
                        count++;
                    } else if (count >= 2) { // 다를경우 그동안 count가 2이상일때 count+sub 을 더해준다
                        compress_string += count + sub;
                        count = 1;
                    } else { // 압축이 하나도 안됬을경우
                        compress_string += sub;
                    }
                }
                
                sub = current; // 그다음 비교할거 갱신 문자열이 같다면 깉을것이고 다르면 새로운 문자열이 될것이다.
            }
            min = Math.min(min, compress_string.length()); // Math.min를 통해 각각 문자열중에 가장 작은 문자열의 갯수 뽑아내기
        }

        return min;
    }
}
