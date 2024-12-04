import java.util.*;

public class Matrix_01_nearest_0_MulitsourceBFS {

    public static int[][] computeDistanceToNearestZero(int[][] mat) {
        
        if(mat == null || mat.length == 0) {
            System.out.println("Empty matrix provided.");
            return new int[0][0];
        }

        int rows = mat.length;
        int cols = mat[0].length;

        // Initialize distance matrix with maximum values
        int[][] distance = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        // Enqueue all 0's and set their distance to 0
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(mat[i][j] == 0){
                    distance[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Directions for adjacent cells: up, down, left, right
        int[][] directions = { {-1,0}, {1,0}, {0,-1}, {0,1} };

        // Perform BFS from all 0's simultaneously
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int currentRow = current[0];
            int currentCol = current[1];

            for(int[] dir : directions){
                int newRow = currentRow + dir[0];
                int newCol = currentCol + dir[1];

                // Check boundaries
                if(newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols){
                    continue;
                }

                // If the new distance is greater than current distance + 1, update it
                if(distance[newRow][newCol] > distance[currentRow][currentCol] + 1){
                    distance[newRow][newCol] = distance[currentRow][currentCol] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return distance;
    }


    public static void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int val : row){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        // Grid input
        int[][] grid = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };

        System.out.println("Input Matrix:");
        printMatrix(grid);

        int[][] distanceMatrix = computeDistanceToNearestZero(grid);

        System.out.println("\nOutput Distance Matrix:");
        printMatrix(distanceMatrix);

        // Additional Example
        int[][] grid2 = {
            {0,0,0},
            {0,1,0},
            {1,1,1}
        };

        System.out.println("\nInput Matrix 2:");
        printMatrix(grid2);

        int[][] distanceMatrix2 = computeDistanceToNearestZero(grid2);

        System.out.println("\nOutput Distance Matrix 2:");
        printMatrix(distanceMatrix2);
    }
    
}
