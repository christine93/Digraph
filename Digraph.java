import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Digraph
{
   private int v;
   private int e;
   private List<List<Integer>> adj;
   private Stack<Integer> path = new Stack<Integer>(); 
   
   public Digraph(int V) {
      path = new Stack<Integer>();
      this.v = V;
      this.e = 0;
      adj = new ArrayList<List<Integer>>();
      for (int i = 0; i < v; i++){
         adj.set(i, new ArrayList<Integer>());
      }
   }
   public int getV() {
      return this.v;
   }
   public List<List<Integer>> getAdj(){
      return this.adj;
   }
   
   public int getE() {
      return this.e;
   }
   public void addEdge(int v, int w) {
      adj.get(v).add(w);
      this.e++;
   }
   
   public Digraph digraphReverse() {
      Digraph R = new Digraph(this.v);
      for (int i = 0; i < this.v; i++) {
         for (int w: adj.get(i)) {
            R.addEdge(w, i);
         }
      }
      return R;
   }
   
   public boolean isVertexReachable(int start, int goal) {
      boolean [] isVisited = new boolean[this.v];
      if(!isVisited[start])
         dfs(start, goal, isVisited);
      return isVisited[goal];
   }
   
   public void printPath() {
      System.out.println("The path is: ");
      while (path.empty())
         System.out.print(path.pop() + " ");
      System.out.println();
   }
   
   private void dfs(int start, int goal, boolean [] isVisited) {
      isVisited[start] = true;
      path.push(start);
      for (int w: adj.get(start)) 
         if(!isVisited[w]) 
            dfs(w, goal, isVisited);  
   }

}

