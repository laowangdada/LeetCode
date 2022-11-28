package List;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[][] grid=new int[][]{{0,3},{1,0},{1,3},{2,0},{3,0},{3,2}};
//        int[]nums=new int[]{1,-15,3,14,-1,4,35,36};
//        int[] nums2=new int[]{-15,32,20,9,33,4,-1,-5};
        int[]nums=new int[]{5,10,16,-6,15,11,3};
        int[] nums2=new int[]{16,22,23,23,25,3,-16};
        Solution so=new Solution();
        int a=so.temperatureTrend(nums,nums2);
        String[] p=new String[]{".....","..E..",".WO..","....."};
        so.ballGame(5,p);
        so.lengthOfLongestSubstring("bbb");
//        int i = so.largestIsland(grid);
//        so.frequencySort2(nums);
    }

    public int lengthOfLongestSubstring(String s) {
        int res=0;

        int start=0,end=0;
        int map[]=new int[128];
        for(end=0;end<s.length();end++){
            if(map[s.charAt(end)-' ']!=0){
                do{
                    map[s.charAt(start)-' ']--;
                    start++;
                }while (s.charAt(start)!=s.charAt(end));
            }
            map[s.charAt(end)-' ']++;
            res=Math.max(res,end-start+1);
        }
        return res;
    }

    int[][] destination=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    char[][] plateChar;
    public int[][] ballGame(int num, String[] plate) {
        plateChar=new char[plate.length][plate[0].length()];
        for(int i=0;i<plate.length;i++){
            plateChar[i]=plate[i].toCharArray();
        }

        int row=plate.length;
        int col=plate[0].length();
        ArrayList<int[]> result=new ArrayList<>();
        // up
        for(int j=1;j<col-1;j++){
            if(plateChar[0][j]=='.'&& dfs(0,j,num,1)){
                int[] temp=new int[2];
                temp[0]=0;
                temp[1]=j;
                result.add(temp);
            }
        }

        //down
        for(int j=1;j<col-1;j++){
            if(plateChar[row-1][j]=='.'&& dfs(row-1,j,num,3)){
                int[] temp=new int[2];
                temp[0]=row-1;
                temp[1]=j;
                result.add(temp);
            }
        }
        //left
        for(int i=1;i<row-1;i++){
            if(plateChar[i][0]=='.'&& dfs(i,0,num,0)){
                int[] temp=new int[2];
                temp[0]=i;
                temp[1]=0;
                result.add(temp);
            }
        }
        //right
        for(int i=1;i<row-1;i++){
            if(plateChar[i][col-1]=='.'&& dfs(i,col-1,num,2)){
                int[] temp=new int[2];
                temp[0]=i;
                temp[1]=col-1;
                result.add(temp);
            }
        }
        int[][] r=new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            r[i]=result.get(i);
        }
        return r;
    }

    public boolean dfs(int x, int y, int steps,int dest){
        if(x<0 || x>=plateChar.length || y<0 || y>=plateChar[0].length) return false;
        if(steps<0) return false;
        if(plateChar[x][y]=='O') return true;
        if(plateChar[x][y]=='E'){
            dest=(dest+1)%4;
        }
        if(plateChar[x][y]=='W'){
            dest=dest-1;
            if(dest==-1) dest=3;
        }
        return dfs(x+destination[dest][0],y+destination[dest][1],steps-1,dest);
    }

    public int transportationHub(int[][] path) {
        int[] allNum=new int[1001];
        int target=0,times=0;
        Map<Integer,Integer> placeNum=new HashMap();
        for(int[]p: path){
            if(placeNum.containsKey(p[1])){
                int cur=placeNum.get(p[1]);
                placeNum.put(p[1],placeNum.get(p[1])+1);
                if(cur+1>times){
                    times=cur+1;
                    target=p[1];
                }
            }else{
                placeNum.put(p[1],1);
            }
            allNum[p[1]]=1;
            allNum[p[0]]=1;
        }
        int sum=0;
        for(int i=0;i<allNum.length;i++){
            if(allNum[i]==1){
                sum++;
            }
        }
        if(times==sum-1){
            return target;
        }

        return -1;
    }



    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int res=0;
        int temp=0;
        for(int i=1;i<temperatureA.length;i++){
            if(compare(temperatureA[i],temperatureA[i-1]) == compare(temperatureB[i],temperatureB[i-1])){
                temp++;
                res=Math.max(res,temp);
            }else{

                temp=0;
            }
        }
        return res;
    }
    public int compare(int a, int b){
        if(a-b>0) return 1;
        if(a-b==0) return 0;
        if(a-b<0)  return -1;
        return 0;
    }





    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        UnionFind uf=new UnionFind(n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    for(int[] di:dirs){
                        int x=i+di[0];
                        int y=j+di[1];

                        if(x>=0 && x<n && y>=0 && y<n && grid[x][y]==1){
                            uf.union(i*n+j,x*n+y);
                        }
                    }
                }
             }
        }
        int result=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    result=Math.max(result,uf.size[i*n+j]);
                }else{
                    int tot=1;
                    Set<Integer> set=new HashSet<>();
                    for (int[] di : dirs) {
                        int x = i + di[0],y = j + di[1];
                        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 0) continue;
                        int root = uf.find(x*n + y);
                        if (set.contains(root)) continue;
                        tot += uf.size[root];
                        set.add(root);
                    }
                    result=Math.max(result,tot);
                }
            }
        }

        return result;
    }
    public int[] frequencySort(int[] nums) {
        //index 100=0 200=100
        int[] map=new int[201];
        Integer[] id=new Integer[201];
        int[] res=new int[nums.length];
        for(int i=0;i<201;i++){
            id[i]=i;
        }
        for(int i:nums){
            map[i+100]++;
        }
        Arrays.sort(id,(a,b)->{
            if(map[a]==map[b]){
                return a-b;
            }else{
                return map[b]-map[a];
            }
        });
        int index=0;
        for(int i:id){
            for(int j=0;j<map[i];j++){
                res[index]=i-100;
                index++;
            }
        }
        return res;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if(sum%k!=0) return false;
        int target=sum/k;
        Arrays.sort(nums);
        if(nums[nums.length-1]>target) return false;

        int[] arr=new int[k];
        Arrays.fill(arr,target);
        return dfs(nums,nums.length-1,arr,k);
    }

    public boolean dfs(int[]nums, int cur, int[]arr,int k){
        if(cur<0) return true;
        //遍历k个桶
        for(int i = 0; i < k; i++){
            //如果正好能放下当前的数或者放下当前的数后，还有机会继续放前面的数（剪枝）
            if(arr[i] == nums[cur] || (cur > 0 && arr[i] - nums[cur] >= nums[0])){
                //放当前的数到桶i里
                arr[i] -= nums[cur];
                //开始放下一个数
                if(dfs(nums, cur - 1, arr, k)){
                    return true;
                }
                //这个数不该放在桶i中
                //从桶中拿回当前的数
                arr[i] += nums[cur];
            }
        }
        return false;
    }
    public int[] frequencySort2(int[] nums) {
        //index 100=0 200=100
        int[] map=new int[201];
        for(int i:nums){
            map[i+100]++;
        }
        var list=new ArrayList<Integer[]>();
        for(int i=0;i<201;i++){
            if(map[i]!=0){
                var ints=new Integer[2];
                ints[0]=i-100;
                ints[1]=map[i];
                list.add(ints);
            }
        }
        list.sort((a,b)->{
            if(a[1]==b[1]){
                return b[0]-a[0];
            }else {
                return a[1]-b[1];
            }
        });
        int[]res=new int[nums.length];
        int index=0;
        for(Integer[] pair:list){
            for(int j=0;j<pair[1];j++){
                res[index]=pair[0];
                index++;
            }
        }
        return res;
    }

}

class UnionFind {
    int[] parent;
    int[] size;

    UnionFind(int nums){
        this.parent=new int[nums];
        this.size=new int[nums];
        for (int i = 0; i < nums; i++) {
            this.parent[i]=i;
            this.size[i]=1;
        }
    }

    public void union(int p, int q){
        int rootP=find(p);
        int rootQ=find(q);
        if(rootP==rootQ) return;

        if(size[p]<=size[q]){
            this.parent[rootP]=rootQ;
            this.size[rootQ]+=this.size[rootP];
        }else {
            this.parent[rootQ]=rootP;
            this.size[rootP]+=this.size[rootQ];
        }
    }

    public boolean connected(int p, int q){
        return find(p)==find(q);
    }

    public int find(int p){
        while (this.parent[p]!=p){
            // 路径压缩
            this.parent[p]=this.parent[this.parent[p]];
            p=this.parent[p];
        }
        return p;
    }
}