package toutiao;

import java.util.*;

/**
 * Created by jinchuyang on 2018/3/24.
 */
public class main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if(k == 0){
            int [] nums = new int[n];
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                nums[i] = num;
            }
            Arrays.sort(nums);

            int ans = 0;
            for (int i = 0; i < nums.length - 1;i++) {
                if(nums[i] == nums[i - 1]){

                }
            }
            System.out.println(ans);
        }else {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                set.add(num);
            }
            int nums[] = new int[set.size()];
            Iterator<Integer> iterator = set.iterator();
            for (int i = 0; iterator.hasNext(); i++) {
                nums[i] = iterator.next();
            }
            Arrays.sort(nums);
            int slow = 0, fast = 0;
            int ans = 0;

            while (fast < nums.length) {
                if (nums[fast] == nums[slow] + k) {
                    ans++;
                    fast++;
                    slow++;
                    continue;
                }
                if (nums[fast] < nums[slow] + k) {
                    fast++;
                    continue;
                }
                if (nums[fast] > nums[slow] + k) {
                    slow++;
                    continue;
                }
            }

            System.out.println(ans);
        }
    }
//    void test(){
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int k = in.nextInt();
//        Set<Integer> list = new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            int num = in.nextInt();
//            if(!list.contains(num)){
//                list.add(num);
//            }
//        }
//        int ans = 0;
//        for(Integer integer : list){
//            if(list.contains(integer + k)){
//                ans++;
//            }
//        }
//        System.out.println(ans);
//    }


}
