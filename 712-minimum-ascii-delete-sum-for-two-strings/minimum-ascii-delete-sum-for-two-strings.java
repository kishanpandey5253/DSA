class Solution{
    
    int[][]dp = new int[1001][1001];
    int[]p1 = new int[1001];
    int[]p2 = new int[1001];

int fun(int i, int j, String s, String t) {

        if(i >= s.length()) 
        return p2[j];

        if(j >= t.length()) 
        return p1[i];

        if(dp[i][j] != -1)
        return dp[i][j];
        
        if(s.charAt(i) == t.charAt(j)) 
            return dp[i][j] = fun(i + 1, j + 1, s, t);
        

        int a = s.charAt(i) + fun(i + 1, j, s, t);
        int b = t.charAt(j) + fun(i, j + 1, s, t);

        return dp[i][j] = Math.min(a, b);


}
        
    public int minimumDeleteSum(String s1, String s2) {

        for(int i = 0;i < 1001; i++)
            for(int j =0;j<1001; j++)
                dp[i][j] = -1;

         for(int i = s1.length() - 1; i >= 0; i--)
            p1[i] = p1[i + 1] + s1.charAt(i);

        for(int j = s2.length() - 1; j >= 0; j--)
            p2[j] = p2[j + 1] + s2.charAt(j);


        return fun(0,0,s1,s2);
        
    }

}
