package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class JavaStreams {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>(75);
        String str="BINGO";
     int start =1;
        for(char ch : str.toCharArray()) {
            for(int j=start;j<start+15;j++) {

                list.add(""+ch + j);
                                System.out.println(""+ch+j);

                
                
            }
                start+=15;
                

        }
        Collections.shuffle(list);

        //List<String> subList = list.subList(0, 15);
        List<String> subList = new ArrayList<>(list.subList(0, 15));
        System.out.println("Sublist: " + subList);
        subList.sort(Comparator.naturalOrder());
        System.out.println("Sorted Sublist: " + subList);
        subList.replaceAll(s -> {
            if( s.charAt(0)=='G' || s.charAt(0)=='O') {
                String updated= s.charAt(0)+"-"+s.substring(1);
                return updated;
            }
            return s; 
            });
            System.out.println(subList);

            list.stream().limit(15).filter(s-> s.charAt(0)=='G' || s.charAt(0)=='O').map(s->s.charAt(0)+"-"+s.substring(1)).forEach(s->System.out.println(s+""));

            String[] arr = {"float", "flower", "flight"};
       var stream1=     Arrays.stream(arr).sorted(Comparator.naturalOrder());
               

           String[] arr1 = {"dog", "cat", "cow", "racecar", "car"};
         var stream2=     Arrays.stream(arr1).sorted(Comparator.reverseOrder()).map(s-> s.toUpperCase());
                


                Stream.concat(stream1, stream2).forEach(System.out::println);
                //terminator code is defined here

                Map<Character, int[]> map = new LinkedHashMap<>();

                for(char ch : str.toCharArray()) {
                    int[] arr2 = new int[15];
                    for(int j=start;j<start+15;j++) {
                        arr2[j-start] = j;
                    }
                    map.put(ch, arr2);
                    start+=15;
                }
                map.entrySet().stream().map(s-> s.getKey()+""+s.getValue()[0]).forEach(System.out::println);
        }


        



        
    }

