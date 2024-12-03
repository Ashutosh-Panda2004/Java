// ismein grid input hoga

import java.util.*;

public class Pacific_Atlatic_waterFlow_BFS {

    public static void main(String args[]){

        int grid[][] = {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> pacific_queue = new LinkedList<>();
        Queue<int[]> atlantic_queue = new LinkedList<>();


        /*
        Understanding the Initialization:
            Pacific Ocean Borders:
                Top Row: All cells in the top row can flow into the Pacific Ocean.
                Leftmost Column: All cells in the leftmost column can flow into the Pacific Ocean.

            Atlantic Ocean Borders:
                Bottom Row: All cells in the bottom row can flow into the Atlantic Ocean.
                Rightmost Column: All cells in the rightmost column can flow into the Atlantic Ocean.
        */

        // Loop 1: Add all cells in the top row to Pacific Queue
        for(int j = 0; j < cols; j++){
            pacific_queue.offer(new int[] {0, j});
        }

        // Loop 2: Add all cells in the leftmost column to Pacific Queue
        for(int i = 0; i < rows; i++){
            pacific_queue.offer(new int[] {i, 0});
        }

        // Loop 3: Add all cells in the bottom row to Atlantic Queue
        for(int j = 0; j < cols; j++){
            atlantic_queue.offer(new int[] {rows - 1, j});
        }

        // Loop 4: Add all cells in the rightmost column to Atlantic Queue
        for(int i = 0; i < rows; i++){
            atlantic_queue.offer(new int[] {i, cols - 1});
        }

        ArrayList<ArrayList<Boolean>> pacific_ans = bfs(grid, pacific_queue, rows, cols);
        ArrayList<ArrayList<Boolean>> atlantic_ans = bfs(grid, atlantic_queue, rows, cols);

        ArrayList<int []> fin_ans= new ArrayList<>();

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(pacific_ans.get(i).get(j) && atlantic_ans.get(i).get(j)){
                    fin_ans.add(new int[] {i,j});
                }
            }
        }

        for(int i=0; i<fin_ans.size(); i++){
            System.out.print("{");
            for(int j=0; j<fin_ans.get(i).length; j++){
                System.out.print(fin_ans.get(i)[j] + " ");
            }
            System.out.print("} ");
        }

    }

    static ArrayList<ArrayList<Boolean>>  bfs(int[][] grid, Queue<int[]> qu, int rows, int cols){

        int [][] dirn = { {0,-1}, {-1,0}, {1,0},  {0,1}};

        ArrayList<ArrayList<Boolean>> visited = new ArrayList<>();
        
        for(int i=0; i<rows; i++){
            ArrayList<Boolean> row =  new ArrayList<>();
            for(int j=0; j<cols; j++){
                row.add(false);
            }
            visited.add(row);
        }

        

        while(!qu.isEmpty()){

            int cell[] = qu.poll();
            
            int curr_row = cell[0];
            int curr_col = cell[1];

            if(!visited.get(curr_row).get(curr_col)) {
                visited.get(curr_row).set(curr_col, true);
            }

            for(int i=0; i<4; i++){
                int new_row  = curr_row+dirn[i][0];
                int new_col = curr_col+dirn[i][1];

                if(new_row<0 || new_col<0 || new_row>=rows || new_col>=cols){
                    continue;
                }
                if(visited.get(new_row).get(new_col)) continue;
                if(grid[new_row][new_col]<grid[curr_row][curr_col]) continue;

                qu.offer(new int []{new_row, new_col});
                visited.get(new_row).set(new_col, true); // Mark as visited
                

            }


        }

        return visited;



    }


    
}
