import java.util.*;

public class Grid_MinCost_Travel {


    static int tabulation(int grid[][], int r, int c){

        int dp[][] = new int[r][c];

        for(int i=r-1; i>=0; i--){
            for(int j=c-1; j>=0; j--){
                if(i==r-1 && j==c-1){
                    dp[i][j] = grid[i][j];
                }
                
                else{
                    int down = (i + 1 < r) ? dp[i + 1][j] : Integer.MAX_VALUE;
                    int right = (j + 1 < c) ? dp[i][j + 1] : Integer.MAX_VALUE;
                    int rightDiagonal = (i + 1 < r && j + 1 < c) ? dp[i + 1][j + 1] : Integer.MAX_VALUE;

                    dp[i][j] = grid[i][j] + Math.min(down, Math.min(right, rightDiagonal));
                }
            }
        }

        return dp[0][0];
    }

    static int memoization(int grid[][], int i , int j , int[][]dp){

        if(i>=grid.length || j>=grid[0].length){
            return Integer.MAX_VALUE;
        }

        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }


        // down jaao
        int down  = memoization(grid, i+1,j, dp);
        
        // right jaao 
        int right = memoization(grid, i, j+1, dp);

        //right diagonal
        int rightDiagonal = memoization(grid, i+1, j+1, dp);


        // put in dp return it
        dp[i][j] =  grid[i][j] + Math.min(down, Math.min(right, rightDiagonal));

        return dp[i][j];

    }


    static int recursion(int grid[][], int i, int j){

        if(i>=grid.length || j>=grid[0].length){
            return Integer.MAX_VALUE;
        }

        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }


        // down jaao
        int down  = recursion(grid, i+1,j);
        
        // right jaao 
        int right = recursion(grid, i, j+1);

        //right diagonal
        int rightDiagonal = recursion(grid, i+1, j+1);


        // return min path 
        return grid[i][j] + Math.min(down, Math.min(right, rightDiagonal));
    }


    static int minCostPath(int cost[][], int m, int n){

        int i=0;
        int j =0;


        // return recursion(cost,i,j);

     
        // int dp[][] = new int[m][n];
        // for (int x = 0; x < m; x++) {
        //     Arrays.fill(dp[x], -1);
        // }
        // return memoization(cost, i, j, dp);


        return tabulation(cost, m , n);


      
      
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] grid = new int[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                int temp = sc.nextInt();
                grid[i][j] = temp;
            }
        }

        int ans = minCostPath(grid, r, c);

        System.out.println("Min Path : " +  ans);



        sc.close();

    }
    
}
