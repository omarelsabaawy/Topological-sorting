/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg62;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author omar mohamed adel elsabaawy
 */

public class Main {
    
    static Scanner s = new Scanner (System.in);
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        int n = s.nextInt(); // enter

        int m = s.nextInt();

        int r = s.nextInt();
    
        int [][] graph = new int[n+1][n+1];
        
        int s = fillTheAjdacencyMatrix(graph, m);

        topologicalSort t = new topologicalSort(s, m, n, r, graph);
        
        t.TopologicalSort();
        
    }
    
    public static int fillTheAjdacencyMatrix(int [][] g ,int m){
        int arOfIndex [] = new int[2*m];
        int index = 0;
        for (int i = 0; i < m; i++) {
            int u = s.nextInt();
            int v = s.nextInt();
            arOfIndex[i+index] = u;
            arOfIndex[i+(++index)] = v;
            g[u][v] = 1;
        }
        Arrays.sort(arOfIndex);
        return arOfIndex[0]; 
    }
    
}
