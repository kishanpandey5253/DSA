class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    void solve(int s, int n , int k, List<Integer> list) {
        if(list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = s; i <= n; i++) {
            list.add(i);
            solve(i+1, n , k , list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {

        solve(1,n,k,new ArrayList<>());
        return ans;
        
    }
}