class Solution {
    public int maxWeightCell(int[] exits) 
    {
      int maxwt=-1;
      int maxindex=-1;
      int [] wt=new int[exits.length];
      for(int i=0;i<exits.length;i++)
      {
        if(exits[i]!=-1)
        {
          wt[exits[i]]+=i;
        }
      }
      for(int i=0;i<wt.length;i++)
      {
        if(maxwt<=wt[i])
        {
          maxwt=wt[i];
          maxindex=i;
        }
      }
      return maxindex;
    }
}
