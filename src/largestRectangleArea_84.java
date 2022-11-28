import java.util.Stack;
//当遇到矮的柱子时候，开始计算面积
public class largestRectangleArea_84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<> ();
        int maxArea =0;
        stack.push(-1);
        //最后一位为零来触发面积的计算
        int[] myHeights = new int[heights.length+1];
        System.arraycopy(heights, 0, myHeights, 0, heights.length);

        for(int i=0;i<myHeights.length;i++){
            while(stack.peek()!=-1&&myHeights[stack.peek()]>myHeights[i]){
                int cur=stack.pop();
                maxArea = Math.max(maxArea,(i-stack.peek()-1)*myHeights[cur]);
            }
            stack.push(i);
        }
        return maxArea;

    }
}
