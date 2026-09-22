class Solution {
    int fun( int i , int j ,int[][] g ,int n , int m, int x ){
        if(i>= n || j>=m || i<0 || j<0 || g[i][j] == -1)
        return 0 ;
        if(g[i][j] == 2){
            if(x==-1){
                return 1;
            } else{
                return 0;
            }
        } 
        int temp = g[i][j];
        g[i][j] = -1;
        int a = fun(i+1 , j , g, n, m,x-1 );
        g[i][j] = temp ; 

        int temp2 = g[i][j];
        g[i][j] = -1;
        int b= fun(i,j+1,g,n,m,x-1);
        g[i][j] = temp2;

        int temp3 = g[i][j];
        g[i][j] = -1;
        int  c = fun(i-1,j,g,n,m,x-1);
        g[i][j] = temp3;

         int temp4 = g[i][j];
        g[i][j] = -1;
        int  d = fun(i,j-1,g,n,m,x-1);
        g[i][j] = temp4;

        return a+b+c+d;        
    }
    public int uniquePathsIII(int[][] g) {
        int n = g.length;
        int m = g[0].length;
         int ans = 0 ;
         int x =0 ;
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(g[i][j]==0){
                    x++;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(g[i][j]==1){
                    ans+=fun(i,j,g,n,m,x);
                }
            }
        }

       return ans ; 
    }
}