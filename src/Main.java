import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.IntStream;

public class Main {
    public static void main(String args[]) {
//        HashSet<lianxi6> q=new HashSet<>();
//        lianxi6 a=new lianxi6(1,"3");
//        lianxi6 a1=new lianxi6(2,"tt");
//        lianxi6 a2=new lianxi6(1,"3");
//        q.add(a);
//        q.add(a1);
//        q.add(a2);
//        System.out.println(q);
//        a.setId(999);
//        System.out.println("###############");
//        System.out.println(q);
//        System.out.println("??????????????????");
//        q.remove(a);
//        System.out.println(q);

        String name = "wang,xin (xw44696)";
//        System.out.println(rmLeftBracket(name));
//        System.out.println(rmLeftBracket2(name));

        Main main = new Main();
        main.maximumSwap(10909091);
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len = quality.length;
        int sumQ = 0;
        var id = IntStream.range(0, len).boxed().toArray(Integer[]::new);
        Arrays.sort(id, Comparator.comparingDouble(i -> (double) wage[i] / quality[i]));

        var queue = new PriorityQueue<Integer>((a, b) -> b - a);

//        for (int i = 0; i < k; i++) {
//            queue.offer(quality[id[i]]);
//            sumQ+=quality[id[i]];
//        }
        double result = sumQ * ((double) wage[id[k - 1]] / quality[id[k - 1]]);

        for (int i = 0; i < len; i++) {
            var q = quality[id[i]];
            sumQ += q;
            if (q < queue.peek()) {
                sumQ = sumQ - queue.poll() + q;
                queue.offer(q);
                result = Math.min(result, sumQ * ((double) wage[id[i]] / q));
            }
        }
        return result;
    }

    public int maximumSwap(int num) {
        String numStr = String.valueOf(num);
        char[] chars = numStr.toCharArray();
        var id = IntStream.range(0, numStr.length()).boxed().toArray(Integer[]::new);
        Arrays.sort(id, (i, j) -> chars[j] - chars[i]);

        for (int i = 0; i < id.length; i++) {
            if (chars[i] != chars[id[i]]) {
                int index = i;
                while (index < id.length) {
                    if (index + 1 < id.length && chars[id[index + 1]] == chars[id[index]]) {
                        index++;
                    } else {
                        break;
                    }
                }
                numStr = swap(numStr, id[index], i);
                return Integer.valueOf(numStr);
            }
        }
        return Integer.valueOf(numStr);
    }

    public String swap(String num, int source, int target) {
        char[] chars = num.toCharArray();
        char temp = chars[source];
        chars[source] = chars[target];
        chars[target] = temp;
        return String.valueOf(chars);
    }

    public int minOperations(String[] logs) {
        int result = 0;
        for (String path : logs) {
            String[] temp = path.split("/");
            for (String t : temp) {
                if (t.equals("..")) {
                    result--;
                } else if (t.equals(".")) {

                } else {
                    result++;
                }
            }
        }
        return result;
    }
    public double trimMean(int[] arr) {
        int totalCount = arr.length;
        int minsLen = (int) (totalCount * 0.05);
        System.out.println(totalCount);
        var maxQueue = new PriorityQueue<Integer>(minsLen,(a,b)->b-a);
        var minQueue = new PriorityQueue<Integer>(minsLen);
        int sum=0;
        for(int i:arr){
            sum+=i;
            if(maxQueue.size()==minsLen){
                if(i<maxQueue.peek()){
                    maxQueue.poll();
                    maxQueue.offer(i);
                }
            }else {
                maxQueue.offer(i);
            }

            if(minQueue.size()==minsLen){
                if(i>minQueue.peek()){
                    minQueue.poll();
                    minQueue.offer(i);
                }
            }else {
                minQueue.offer(i);
            }

        }

        for (Integer integer : maxQueue) {
            sum-=integer;
        }
        for (Integer integer : minQueue) {
            sum-=integer;
        }
        return sum/(totalCount-2*minsLen);
    }


    public static String rmLeftBracket(String a) {
        int index = a.indexOf("(");
        return a.substring(0, index);
    }

    public static String rmLeftBracket2(String a) {
        return a.split("\\(")[0];
    }

    static class lianxi6 {
        private int id;
        private String name;

        public lianxi6(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            lianxi6 lianxi6 = (lianxi6) o;
            return id == lianxi6.id && Objects.equals(name, lianxi6.name);
        }

        //        @Override
//        public int hashCode() {
//            return Objects.hash(id, name);
//        }
        @Override
        public String toString() {
            return "lianxi6{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public int rectangleArea(int[][] rectangles) {
        int result=0;
        var xList=new ArrayList<Integer>();
        for(int[] x:rectangles){
            xList.add(x[0]);
            xList.add(x[2]);
        }
        xList.sort(Comparator.comparingInt(Integer::valueOf));
        for (int i = 1; i < xList.size(); i++) {
            int x1=xList.get(i-1);
            int x2=xList.get(i);
            int width=x2-x1;
            if(width==0) continue;
            //height
            var occupyRe=new ArrayList<int[]>();
            for(int[] re:rectangles){
                if(re[0]<=x1 && re[2]>=x2){
                    occupyRe.add(new int[]{re[1],re[3]});
                }
            }
            occupyRe.sort((re1,re2)->{
                if(re1[0]==re2[0]){
                    return re1[1]-re2[2];
                }else {
                    return re1[0]-re2[0];
                }
            });
            int height=0,up=-1,down=-1;
            for (int[] curHight:occupyRe){
                if(curHight[0]>up){
                    height+=up-down;
                    down=curHight[0];
                    up=curHight[1];
                }else if(curHight[1]>up){
                    up=curHight[1];
                }
            }
            height+=up-down;
            result+=height*width;
            result %= (int)1e9+7;

        }

        return result;
    }

    public String reversePrefix(String word, char ch) {
        int indexReverse = word.indexOf(ch);
        if (indexReverse == -1) return word;
        String head = word.substring(0, indexReverse + 1);
        String tail = word.substring(indexReverse + 1);
        StringBuilder sb = new StringBuilder();

        for (int i = head.length() - 1; i > -1; i--) {
            sb.append(head.charAt(i));
        }
        sb.append(tail);
        return sb.toString();
    }

    public boolean canPartition(int[] nums) {
        CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        int sum = 0;
        for (int i : nums) {
            sum += i;
            copyOnWriteArraySet.add(i);
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        for (Integer i : nums) {
            copyOnWriteArraySet.forEach(it -> {
                copyOnWriteArraySet.add(it + i);
            });
        }
        return copyOnWriteArraySet.contains(target);
    }

    public long interchangeableRectangles(int[][] rectangles) {
        long result = 0;
        Map<BigDecimal, Long> tempMap = new HashMap<>();
        double resultArray[] = new double[rectangles.length];
        for (int i = 0; i < resultArray.length; i++) {
            BigDecimal lengthB = new BigDecimal(rectangles[i][0]);
            BigDecimal heightB = new BigDecimal(rectangles[i][1]);

            BigDecimal tempRes = lengthB.divide(heightB, 4, BigDecimal.ROUND_HALF_UP);
            if (tempMap.containsKey(tempRes)) {
                tempMap.put(tempRes, tempMap.get(tempRes) + 1);
            } else {
                tempMap.put(tempRes, 1L);
            }
        }

        for (BigDecimal aDouble : tempMap.keySet()) {
            long a = tempMap.get(aDouble);
            result += a * (a - 1) / 2;
        }
        return result;
    }
}

