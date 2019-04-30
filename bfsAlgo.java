import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class bfsAlgo {

    // Complete the bfs function below.
    static int[] bfs(int n, int m, int[][] edges, int s) {
        int out[]=new int[n+1];
        for(int i=1;i<=n;i++){
            out[i]=-1;
        }
        //creating an adjacency matrix for storing graph
        int adj[][]=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                adj[i][j]=0;
            }
        }
        //if there is an edge between two nodes i am placing 1 else 0
        for(int i=0;i<m;i++){
                adj[edges[i][0]][edges[i][1]]=1;
        }
        //Initialization of queue and traversing based on given constraints
        LinkedList<Integer> queue=new LinkedList<Integer>();
        queue.add(s);
        out[s]=0;
        while(queue.size()!=0){
            int p=queue.poll();    
            //inserting all nodes to queue whose has edge with p node    
            for(int i=1;i<=n;i++){
                //if there is edge and it is not visited then only move to that path
                if(adj[p][i]!=0 & out[i]==-1 ){
                    queue.add(i);
                    out[i]=out[p]+6;
                }
                //it is bidirection so i am checking vice vers condition
                else if(adj[i][p]!=0 & out[i]==-1){
                    queue.add(i);
                    out[i]=out[p]+6;
                }
            }
        }
        return out;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(n, m, edges, s);

            for (int i = 0; i < result.length; i++) {
                if(result[i]!=0){
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }}
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
