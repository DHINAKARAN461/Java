import java.util.*;


public class Decompress {
    class Solution {
        public int[] decompressRLElist(int[] nums) {
            ArrayList<Integer>list = new ArrayList<>();
            for(int i =0;i<nums.length/2;i++) {
                for (int aa : copy(nums[i * 2], nums[i * 2 + 1])){
                    list.add(aa);
                }
            }
            int [] a = new int[list.size()];

            for(int i=0; i<list.size();i++){
                a[i]= list.get(i);

            }
            return a;
        }
        public int[] copy  (int range, int value) {
            int store[] = new int[range];
            for (int i = 0; i < range; i++) {
                store[i] = value;

            }
            return store;
        }
    }
}
