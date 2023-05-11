package backtrack;
import java.util.*;
public class BackTrack{
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new LinkedList<>();
        LinkedList<Integer> track=new LinkedList<>();

        boolean[] used=new boolean[nums.length];
        backtrack(res,nums,track,used);

        return res;
    }

    public void backtrack(List<List<Integer>> res,int[] nums,LinkedList<Integer> track,boolean[] used){
        if(track.size()==nums.length){
            res.add(new LinkedList(track));
            return;
        }
        for(int i=0;i<nums.length;i++){
            //如果被使用了就换下个数
            if(used[i]){
                continue;
            }
            track.add(nums[i]);
            // if(track.size()==nums.length){
            //     res.add(track);
            //     track.clear();
            // }
            used[i]=true;
            backtrack(res,nums,track,used);
            // System.out.println("track做选择====");
            // track.stream().forEach(x->System.out.println(x));;
            track.removeLast();
            // System.out.println("track取消选择====");
            // track.stream().forEach(x->System.out.println(x));;
            used[i]=false;
        }
    }


    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3};
        BackTrack backTrack=new BackTrack();

        List<List<Integer>> res=backTrack.permute(nums);
        for(List<Integer> items:res){
            items.stream().forEach(System.out::println);
            System.out.println("==============");
        } 
    }
}