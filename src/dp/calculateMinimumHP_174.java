package dp;

public class calculateMinimumHP_174 {
    int[][] direction={{0,1},{1,0}};
    int[][] dpMemo;
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        dpMemo=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dpMemo[i][j]=Integer.MAX_VALUE;
            }
        }
        dpMemo[m-1][n-1]=dungeon[m-1][n-1]>=0? 0:dungeon[m-1][n-1];
        int minsBlood=helper(0,0,dungeon);
        return Math.abs(minsBlood)+1;
    }


    public int helper(int x, int y, int[][] dungeon){
        if(dpMemo[x][y]<Integer.MAX_VALUE) return dpMemo[x][y];

        int temp=Integer.MIN_VALUE;
        for(int i=0;i<2;i++){
            int nextRow=x+direction[i][0];
            int nextCol=y+direction[i][1];
            if(nextRow>=dungeon.length||nextCol>=dungeon[0].length) continue;
            temp=Math.max(temp,helper(nextRow,nextCol,dungeon));
        }
        if(temp>=0){
            dpMemo[x][y]=Math.min(dungeon[x][y],0);
        }else {
            dpMemo[x][y]=(dungeon[x][y]+temp)>0? 0:(dungeon[x][y]+temp);
        }
        return dpMemo[x][y];
    }

    public static void main(String[] args) {
        calculateMinimumHP_174 ca=new calculateMinimumHP_174();
        int[][] test={{-2,-3,3},{-5,-10,1},{10,30,-5}};
//        int[][] test={{2,0,-1}};
//        int[][] test={{100}};
        int a=ca.calculateMinimumHP(test);

        System.out.printf(String.valueOf(a));
    }
}
