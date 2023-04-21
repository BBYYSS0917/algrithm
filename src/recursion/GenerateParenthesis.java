package recursion;
import java.util.*;

public class GenerateParenthesis{

// result = []
// def backtrack(路径, 选择列表):
//     if 满足结束条件:
//         result.add(路径)
//         return
    
//     for 选择 in 选择列表:
//         做选择
//         backtrack(路径, 选择列表)
//         撤销选择

    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> track=new LinkedList<>();
        boolean[] used=new boolean[nums.length];
        backtrack(res, nums, track, used);




        return res;
    }

    public static void backtrack(List<List<Integer>> res,int[] nums,LinkedList<Integer> track,boolean[] used){
        if(track.size()==nums.length){
            res.add(new ArrayList<>(track));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            track.add(i);
            used[i]=true;
            backtrack(res, nums, track, used);
            //取消选择？
            track.removeLast();
            used[i]=false;
        }


    }


    public static void main(String[] args) {
        int[] nums=new int[]{0,1,2};
        List<List<Integer>> res=permute(nums);
        for(List<Integer> item:res){
            for (int i = 0; i < nums.length; i++) {
                System.out.print(item.get(i));
                if(i==item.size()-1){
                    System.out.println("===================");
                }
            }
        }
        
    }
}