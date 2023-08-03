import java.util.Arrays;

public class SwapArr {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        int temp = 0;
        for(int i =0;i<arr.length;i++){
            for(int j=i+1;j< arr.length;j++){
                if(arr[i]<arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

        }
        //String arrStr = Arrays.toString(arr);
        System.out.println(Arrays.toString(arr));
    }
}