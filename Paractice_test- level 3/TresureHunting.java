import java.util.Scanner;

public class TresureHunting {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Grid Size: ");
        int m = s.nextInt();
        int n = s.nextInt();
        int[][] grid =new int[m][n];

        while(true){
            System.out.println("1. Find minPath.");
            System.out.println("2. Exit");
            int choice = s.nextInt();
            switch (choice) {
                case 1: System.out.println("Enter Gold Location(Location should me less than "+m+", "+n+")");
                        int x = s.nextInt();
                        int y = s.nextInt();
                        grid[x][y] = 1;
                        System.out.println("Enter Adeventurer Location(Location should me less than "+m+", "+n+")");
                        int i = s.nextInt();
                        int j = s.nextInt();
                        System.out.println(minPath(grid,i,j,x,y));
                case 2: System.exit(0);
                default : System.out.println("Invalid Choice");
            }
        }
    }

    private static int minPath(int[][] grid, int i, int j, int m, int n) {

        if (i >=m || j >=n || i < 0 || j < 0 ) {

            //System.out.println("in condition");
            return 0;
        }

        if (i == m && j == n) {
            return 0;
        }
        ////System.out.println("Starting of recursion");
        int down = minPath(grid, i + 1, j, m, n) + 1;
        int right = minPath(grid, i, j + 1, m, n) + 1;
        int up = minPath(grid, i - 1, j, m, n) + 1;
        int left = minPath(grid, i, j - 1, m, n) + 1;

        return 1 + Math.min(Math.min(down, right), Math.min(up, left));

    }

    
}
