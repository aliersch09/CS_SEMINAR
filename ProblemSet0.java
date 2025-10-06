import java.util.*;
public class ProblemSet0{
    public static void main(String []args){
        //count in range test
        int[] one = {2,7,5,9,3};
        System.out.println(countInRange(one,3,8));
        //clump test
        ArrayList<String> two = new ArrayList<>(Arrays.asList("hi","there","what","is","up?"));
        clump(two);
        System.out.println(two);
        //is magic square test
        int[][] twoD = {{2,7,6},{9,5,1},{4,3,8}};
        boolean x = isMagicSquare(twoD);
        System.out.println(x);
        //median test
        int y = median(one);
        System.out.println(y);
    }
    public static int countInRange(int[] arr, int min, int max){
        int num = 0; //number of elements in range
        for(int i = 0; i < arr.length; i++){
            if(arr[i]<=max&&arr[i]>=min){ //if the element is in range, add to num
                num++;
            }
        }
        return num; //return the number of elements in range
    }
    public static void clump(ArrayList<String> list){
        for(int i = 0; i<list.size()-1; i++){
            list.set(i,list.get(i)+" "+list.get(i+1)); //set the element equal to the element added to the element after
            list.remove(i+1);//remove the element added to the preceeding element
        }
    }
    public static boolean isMagicSquare(int[][] arr){
        boolean isMagic = false; //create boolean
        int sum = 0; //sum of elements in arr[0]
        for(int i = 0; i<arr[0].length; i++){
            sum+=arr[0][i];
        }
        int testSum = 0; //sum to compare to sum above
        for(int i = 0; i<arr.length;i++){ //test for rows
            for(int j=0; j<arr[i].length;j++){
                testSum += arr[i][j];
            }
            if(testSum==sum){ //if the sums are equal, boolean is changed to true
                isMagic = true;
            }else{
                return false; //if the sums are not equal, immediately return false
            }
            testSum = 0; //reset the test sum
        }
        for(int i = 0; i <arr.length; i++){ //test for columns
            for(int j = 0; j<arr[i].length; j++){
                testSum += arr[j][i];
            }
            if(testSum==sum){ //if the sums are equal, boolean is changed to true
                isMagic = true;
            }else{
                return false; //if the sums are not equal, boolean is false
            }
            testSum = 0; //reset the test sum
        }
        for(int i = 0; i <arr.length; i++){ //test for columns
            testSum += arr[i][i];
        }
        if(testSum==sum){ //if the sums are equal, boolean is changed to true
            isMagic = true;
        }else{
            return false; //if the sums are not equal, boolean is false
        }
        return isMagic;
    }
    public static int median(int[] arr){
        int median = 0;
        for(int i = 0; i<arr.length; i++){ //for each element in the array count how many are greater than and less than
            int less = 0;
            int more = 0;
            for(int j = 0; j<arr.length; j++){
                if(arr[i]<arr[j]){
                    more++;
                }
                if(arr[i]>arr[j]){
                    less++;
                }
            }
            if(less==more){ //if the same number of elements are greater than and less than - has to be the median
                median = arr[i];
            }
        }
        return median;
    }
}