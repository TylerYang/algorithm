public class GraphCircle {
    boolean[] onStack; 
    boolean[] mark; 
    public boolean hasCircle(boolean[][] graph) {
        mark = new boolean[graph.length];
        onStack = new boolean[graph.length];
        
        
        for(int i = 0; i < graph.length; i++) {
            if(!mark[i] && dfs(graph, i) == false) {
                return true;
            }
        }
        return true;
    }
    private boolean dfs(boolean[][] graph, int i) {
        mark[i] = true;
        onStack[i] = true;
        for(int j = 0; j < graph[0].length; j++) {
            if(mark[j] == false) {
                dfs(graph, j);
            } else if(onStack[j] == true) {
                return false;
            }
        }
            
        onStack[i] = false;
        return true;
    }
    public static void main(String[] args) {
        GraphCircle gc = new GraphCircle();
        boolean[][] graph = {
            {false, true, false, false},
            {false, false, true, false},
            {false, false, false, true},
            {false, true, false, false}
        };
        System.out.println("has circle: " + gc.hasCircle(graph));
    }
}
