

public class Task{

   public static  int[] arr1 ={2,4,3,1,6};
  public static  int[] arr2 ={4,0,3,2,0};

   
   public static int findMax(){
    int max =0;

    int start=0;
    int current = start;


    boolean[] visited = new boolean[arr1.length];
    // this is to prevent infinite loop and redundancy
    do{
            int n=arr1[start];
            int m = arr2[n];
          max =  Math.max(max, m);

            if(visited[m]== true){
                break;
            }
            visited[m] = true;
            current = m;
        }

            while(start!=current );{
               return max;


    }



}

   
    
    public static void main(String[] args) {
        int m =findMax();
        System.out.println("The maximum value is: " + m);

    }
}

