import java.util.Arrays;

public class countingp {

    public static int[] countingSort(int[] arr) {

       int n = arr.length;

       int max = 0;
       for(int num: arr){
        if(num>max) max=num;
       }

       int[] count = new int[max+1];

       for(int num: arr){
        count[num]++;
       }

       int[] sorted = new int[n];
       int index=0;

       for(int i=0;i<count.length;i++){
        while(count[i]>0){
            sorted[index]=i;
            index++;
            count[i]--;
        }
       }

       return sorted;
    }

    public static void main(String[] args) {

        int[] arr = {4, 2, 2, 8, 3, 3, 1};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));

        int[] sorted = countingSort(arr);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(sorted));
    }
}
