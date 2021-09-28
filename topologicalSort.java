/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg62;

import java.util.Arrays;

/**
 *
 * @author omar mohamed adel elsabaawy
 */

public class topologicalSort {
    final private int m;
    final private int n;
    final private int r;
    final private int [][] graph;
    final private Stack InDegree = new Stack();
    final private Stack OutDegree = new Stack();
    private final int SmallestNumber; 
    int [] inDegree;
    int [] outDegree;
    public topologicalSort(int s , int m , int n , int r , int[][] graph) {
        this.SmallestNumber = s;
        this.m = m;
        this.n = n;
        this.r = r;
        this.graph = graph;
    }
     
    public void TopologicalSort(){
     inDegree = CalculateTheIndegree();
     outDegree = CalculateTheOutdegree();
     
        int IndegreeIndex = -1;
        int outdegreeIndex = -1;
        int index = -1;
        
        for (int i = r ; i <= m ; i++) {
            if (inDegree[i+1] > inDegree[i]) {
                IndegreeIndex = i+1;
            }
            if (outDegree[i+1] < outDegree[i]) {
                outdegreeIndex = i+1;
            }
        }
        if (IndegreeIndex == outdegreeIndex) {
            
            System.out.println(outdegreeIndex);
            
        }else if(IndegreeIndex != outdegreeIndex){
            int [] ar = new int[m*2];
            int x = 0;
            for (int i = SmallestNumber ; i < m ; i++) {
                if (outDegree[i] == 0) {
                    ar[x++] = i;
                }
            }
            for (int i = 0; i < 2; i++) {
                System.out.print(ar[i]+" ");
            }
        }
        
    }
    
    public int [] CalculateTheIndegree(){
        int ar [] = new int[n*2];
        
        int sum = 0;
        for (int i = 0; i < n+1 ; i++) {
            for (int j = 0; j < n+1; j++) {
                sum += graph[j][i];
                }
            ar[i] = sum;
            sum = 0;
        }
        for (int x = 0; x < n; x++) { 
            int max = -1;
            int index = -1;
            for (int i = SmallestNumber; i < ar.length; i++) {
                if (max < ar[i] ) {
                    max = ar[i];
                    index = i;
                }
            }
            
            InDegree.push(index);
            
            ar[index] = max;

        }
        return ar;
    }
    
    public int [] CalculateTheOutdegree(){
        int ar [] = new int[n*2];
        
        int sum = 0;
        for (int i = 0; i < n+1 ; i++) {
            for (int j = 0; j < n+1; j++) {
                sum += graph[i][j];
                }
            ar[i] = sum;
            sum = 0;
        }
        
        for (int x = 0; x < n; x++) { 
            int max = Integer.MAX_VALUE;
            int index = Integer.MAX_VALUE;
            for (int i = SmallestNumber; i < ar.length; i++) {
                if (max > ar[i] ) {
                    max = ar[i];
                    index = i;
                }
            }
            
            OutDegree.push(index);
            ar[index] = max;
        
        }    
        return ar;
    }
    
}
