class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) 
    {
     int n=nums1.length;
     int m=nums2.length;
     int t=0;
     int ptr1=0,ptr2=0;
     int [][] merge=new int[m+n][2];
     while(ptr1<n && ptr2<m)
     {
        if(nums1[ptr1][0]==nums2[ptr2][0])
        {
         merge[t][0]=nums1[ptr1][0];
         merge[t][1]=nums1[ptr1][1]+nums2[ptr2][1];
         ptr1++;
         ptr2++;
        }
        else if(nums1[ptr1][0]>nums2[ptr2][0])
        {
          merge[t][0]=nums2[ptr2][0];
          merge[t][1]=nums2[ptr2][1];
          ptr2++;
        }
        else
        {
          merge[t][0]=nums1[ptr1][0];
          merge[t][1]=nums1[ptr1][1];
          ptr1++;
        }
        t++;
     }
     while(ptr1<n)
     {
          merge[t][0]=nums1[ptr1][0];
          merge[t][1]=nums1[ptr1][1];
          ptr1++; 
          t++;
     }
      while(ptr2<m)
     {
          merge[t][0]=nums2[ptr2][0];
          merge[t][1]=nums2[ptr2][1];
          ptr2++; 
          t++;
     }
      int [][] result=new int[t][2];
      for(int i=0;i<t;i++)
      {
       for(int j=0;j<2;j++) 
       result[i][j]=merge[i][j];
      }
       return result;
    }
}
