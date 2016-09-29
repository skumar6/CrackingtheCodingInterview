import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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

    //max depth of a binary tree
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return 1+(Math.max(l,r));
    }

    //find Minmum depth
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        //check if both nodes are present
        if(root.right != null && root.left != null){
            return 1+ Math.min(minDepth(root.left), minDepth(root.right));
        }else
            return 1+ Math.max(minDepth(root.left), minDepth(root.right));


    }

    //Binary tree level order list of list
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root != null)
            q.add(root);
        while(!q.isEmpty()){
            int count = q.size();
            List<Integer> tmpList = new LinkedList<Integer>();
            while(count-- > 0){
                if(q.peek().left != null) q.add(q.peek().left);
                if(q.peek().right != null) q.add(q.peek().right);
                tmpList.add(q.poll().val);
            }
            ls.add(tmpList);
        }
        return ls;
    }

    //levelorder bottom up list
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> ls = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Stack s = new Stack();
        if(root != null)
            q.add(root);
        while(!q.isEmpty()){
            int count = q.size();
            List<Integer> tmpList = new LinkedList<Integer>();
            while(count-- > 0){
                if(q.peek().left != null) q.add(q.peek().left);
                if(q.peek().right != null) q.add(q.peek().right);
                tmpList.add(q.poll().val);
            }

            s.push(tmpList);
        }
        while(!s.empty()){
            ls.add((List)s.pop());
        }
        return ls;
    }

    //find a different letter in two suffeled strings
    public char findTheDifference(String s, String t) {
        char  sums = 0;

        for(int i=0; i<s.length(); i++){
            sums = (char)(sums ^ s.charAt(i));
        }
        for(int i=0; i<t.length(); i++){
            sums = (char)(sums ^ t.charAt(i));
        }
        return sums;
    }

    //invert a binary tree
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;

    }












}
