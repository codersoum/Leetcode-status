public class DLL{
    public DLL right;
    public DLL left;
    public int key;
    public int val;
    public DLL(int key,int val)
    {
      this.key=key;
      this.val=val;
      this.right=null;
      this.left=null;

    }
}

class LRUCache {
   Map<Integer,DLL>mp;
   int cap;
   DLL head ,tail;
    public LRUCache(int capacity) 
    {
       this.head=new DLL(-1,-1);
       this.tail=new DLL(-1,-1);
      this.head.right=this.tail;
      this.tail.left=this.head;  
      this.cap=capacity;
      this.mp=new HashMap<>();
    }
  public void insertAthead(DLL node)
  {     
         head.right.left = node;
        node.right = head.right;
        node.left = head;
        head.right = node;
  }
  public void deletenode(DLL node)
  {
   node.left.right=node.right;
   node.right.left=node.left;
  }
    public int get(int key) 
    {
       if (!mp.containsKey(key)) {
            return -1; // Key not found
        }
        DLL node=mp.get(key);
        deletenode(node);
        insertAthead(node);
        return node.val;
        
    }
    
    public void put(int key, int value) 
    {
      if(mp.size()>=cap && !mp.containsKey(key))
      {
         DLL newnode= new DLL(key,value);
         DLL node=tail.left;
         deletenode(mp.get(node.key));
         insertAthead(newnode);
         mp.remove(node.key);
         mp.put(key,newnode);
      }
      else
      { 
        if(mp.containsKey(key))
        {
          DLL node=mp.get(key);
          node.val=value;
          deletenode(node);
          insertAthead(node);
        }
        else
        {
          DLL node=new DLL(key,value);
          insertAthead(node); 
          mp.put(key,node);
        }
      }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
