package leetcode;

import java.util.ArrayDeque;

public class Q934 {

//    [[1,1,1,1,1]
//    [1,0,0,0,1],
//    [1,0,1,0,1],
//    [1,0,0,0,1],
//    [1,1,1,1,1]]

    int[][] dest=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    ArrayDeque<int[]> map=new ArrayDeque<>();
    public int shortestBridge(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j]==1){
                    dfs(grid,i,j);
                    i=row;
                    break;
                }
            }
        }
        int minRes=0;
        while(map.size()>0){
            int n=map.size();
            minRes++;
            for (int i = 0; i < n; i++) {
                int[] ints=map.pollFirst();

                for (int[] ints1 : dest) {
                    int x = ints[0]+ints1[0];
                    int y = ints[1]+ints1[1];
                    if(isLegal(x,y,grid) && grid[x][y]==0){
                        map.add(new int[]{x, y});
                        grid[x][y] = 2;
                    }else if (isLegal(x, y,grid) && grid[x][y] == 1) return minRes;
                }
            }
        }
        return minRes;
    }

    public boolean isLegal(int x, int y,int[][]grid){
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
    public void dfs(int[][] grid,int x, int y){
        if(x<0||x>=grid.length||y<0||y>=grid[0].length ||grid[x][y]==2) return;
        if(grid[x][y]==0){
            grid[x][y]=2;
            map.add(new int[]{x,y});
        }
        if(grid[x][y]==1){
            grid[x][y]=2;
            for (int[] ints : dest) {
                dfs(grid,x+ints[0],y+ints[1]);
            }
        }
    }
}
