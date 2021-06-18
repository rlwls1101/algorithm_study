import java.util.*;
public class p_베스트앨범 {

    public static HashMap<String, Integer> hashMap = new HashMap<>();
    public static Integer[] result;

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int []plays={500, 600, 150, 800, 2500};
        int[] tmp=solution(genres,plays);
        for(int t: tmp){
            System.out.println(t);
        }
    }

    public static int[] solution(String[] genres, int[] plays) {

        for(int i = 0 ; i < genres.length ; i++) {
            String g = genres[i];
            if(hashMap.containsKey(g)) {
                int sum = hashMap.get(g) ;
                hashMap.replace(g, sum + plays[i]);
            }
            else
                hashMap.put(g, plays[i]) ;
        }

        result = new Integer[genres.length];
        for(int i = 0 ; i < result.length ; i++)
            result[i] = i;

        Arrays.sort(result, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                String g1 = genres[num1];
                String g2 = genres[num2];
                if(hashMap.get(g1) > hashMap.get(g2))
                    return -1;
                else if(hashMap.get(g1) < hashMap.get(g2))
                    return 1;

                int play1 = plays[num1];
                int play2 = plays[num2];

                if(play1 > play2)
                    return -1;
                else if(play2 < play1)
                    return 1;

                if(num1 > num2)
                    return 1;
                else
                    return -1;
            }
        });

        List<Integer> answer_list = new ArrayList<>() ;

        answer_list.add(result[0]);
        String genre = genres[answer_list.get(0)];
        int size = 1 ;

        for(int i = 1 ; i < result.length ; i++)
        {
            if(genre.equals(genres[result[i]]))
            {
                if(size != 2) {
                    answer_list.add(result[i]);
                    size++;
                }
            }
            else
            {
                genre = genres[result[i]];
                answer_list.add(result[i]);
                size = 1 ;
            }

        }
        int[] answer = new int[answer_list.size()] ;

        int index = 0 ;
        for(int i : answer_list)
            answer[index++] = i;

        return answer;
    }
}
