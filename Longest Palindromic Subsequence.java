class Solution {
    public int longestPalindromeSubseq(String s) 
    {
      int start=0,end=s.length()-1;
      int [][] dp=new int[s.length()+1][s.length()+1];
      for(int i=0;i<=s.length();i++)
      {
        for(int j=0;j<=s.length();j++)
        {
          dp[i][j]=-1;
        }
      }
      return lcs(s,start,end,dp);
    }
    public int lcs(String s,int start,int end,int [][] dp)
    {
      if(end<start)
      return 0;
      if (end==start)
      return 1;
      if(dp[start][end]!=-1) 
      return dp[start][end];
      if(s.charAt(end)==s.charAt(start))
       dp[start][end]=2+lcs(s,start+1,end-1,dp);
      else
       dp[start][end]=Math.max(lcs(s,start+1,end,dp),lcs(s,start,end-1,dp));
       return dp[start][end];

    }
}
