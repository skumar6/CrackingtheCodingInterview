/**
 * Created by Sanjeev on 9/28/2016.
 */
public class LeetCodeProblems {

    public static void main(String[] args){

    }

    //reverse a string
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i =s.length(); i>0; i--){
            sb.append(s.charAt(i-1));
        }
        return sb.toString();
    }

    //sum without -/+
    public int getSum(int a, int b) {
        //bit manipulation could be used here.
        while(b != 0){
            int carry = a & b;
            a = a ^b;
            b = carry <<1;
        }
        return a;
    }

    //single number
    public int singleNumber(int[] nums) {
        int sum =0;
        for(int i =0; i<nums.length; i++){
            sum = sum^nums[i];
        }
        return sum;

    }
}
