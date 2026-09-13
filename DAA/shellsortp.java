
import java.util.Arrays;

public class shellsortp {

    public static void shellSort(int[] arr) {

        int n = arr.length;

        for(int gap = n/2;gap > 0;gap/=2){
            for(int i=gap;i<n;i++){
                int temp = arr[i];
                int j=i;
                while(j>=gap && arr[j-gap]>temp){
                    arr[j]=arr[j-gap];
                    j-=gap;
                }
                arr[j]=temp;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {9, 8, 3, 7, 5, 6, 4, 1};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(arr));

        shellSort(arr);

        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(arr));
    }
}
