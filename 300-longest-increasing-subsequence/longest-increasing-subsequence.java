class Solution {
    public int lengthOfLIS(int[] nums) {

        ArrayList<ArrayList<Integer>> v1 = new ArrayList<>();
        int i = 0;

        for (int a : nums){
            if(v1.size() == 0|| a> v1.get(v1.size() - 1).get(0)) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(a);
                temp.add(i);
                v1.add(temp);

            } else {
                
                int l=0;
                int h = v1.size() - 1;
                int id = -1;

                while(l <= h) {
                    int mid = (l+h)/2;
                    if(v1.get(mid).get(0) >= a) {
                        id = mid;
                        h = mid -1;

                    }else{
                        l = mid + 1;

                    }
                }

                if(i > v1.get(id).get(1)){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(a);
                    temp.add(i);
                     v1.set(id, temp);
                }
            }

            i++;
        }
         return v1.size();
            
    }
}