package Testpad_Sawaals;
import java.util.*;

public class Number_Of_Islands {

    static Boolean isValid(int mat[][], int i, int j, Boolean [][] visited){

        if(i>=mat.length || j>=mat[0].length || i<0 || j<0 || mat[i][j]==0 || visited[i][j]){
            return false;
        }

        return true;

    }


    static void dfs(int mat[][], int i, int j, Boolean visited[][]){

        if(!isValid(mat, i,j, visited)) return;

        if(!visited[i][j]){
            visited[i][j] = true;
        }

        // up
        dfs(mat, i-1, j, visited);

        // down
        dfs(mat, i+1, j, visited);

        // left
        dfs(mat, i, j-1, visited);

        // right
        dfs(mat, i, j+1, visited);

        

    }

    static int countIslands(int mat[][], int m, int n){
        
        if(m==0 || n==0) return 0;

        Boolean visited[][] = new Boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                visited[i][j] =false;
            }
        }

        int cnt = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && mat[i][j]==1){
                    dfs(mat, i, j, visited);
                    cnt++;
                }
            }
        }

        return cnt;


        
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int mat[][] = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = sc.nextInt();
            }
        }

        countIslands(mat, m, n);

        sc.close();

        

    }
    
}
