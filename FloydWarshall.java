class Solution {
    public void shortestDistance(int[][] mat) 
    {
        for(int i=0;i<mat.length;i++)
        {
         for(int j=0;j<mat.length;j++)
         {
           if(mat[i][j]==-1)
           mat[i][j]=(int) 1e9;
           if(i==j)
           mat[i][j]=0;
         }
        }
        for(int k=0;k<mat.length;k++)
        {
         for(int i=0;i<mat.length;i++)
        {
         for(int j=0;j<mat.length;j++)
         {
           mat[i][j]=Math.min(mat[i][j],mat[i][k]+mat[k][j]);
         }
        }
       }
       for(int i=0;i<mat.length;i++)
        {
         for(int j=0;j<mat.length;j++)
         {
           if(mat[i][j]==(int) 1e9)
           mat[i][j]=-1;
         }
        }
        
    }
}
