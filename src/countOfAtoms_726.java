import java.util.*;

public class countOfAtoms_726 {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = calculateParenthesis(1, formula);
        StringBuilder res = new StringBuilder();
        Set<String> set = map.keySet();
        for (String key : set) {
            if (map.get(key) == 1) {
                res.append(key);
            } else {
                res.append(key);
                res.append(map.get(key));
            }
        }
        return res.toString();
    }

    // 参数multiplier代表着括号外面的数字
    private Map<String, Integer> calculateParenthesis(Integer multiplier, String formula) {
        List<Map<String, Integer>> list = new LinkedList<>();
        int i = 0;
        int len = formula.length();
        while (i < len) {
            // 有括号的字符串的处理
            if (String.valueOf(formula.charAt(i)).equals("(")) {
                int balance = 1;
                int j = i + 1;
                while (j < len && balance > 0) {
                    if (")".equals(String.valueOf(formula.charAt(j)))) {
                        balance++;
                    } else if (String.valueOf(formula.charAt(j)).equals(")")) {
                        balance--;
                    }
                    j++;
                }

                String str = formula.substring(i + 1, j - 1);
                int count = 1;
                if (j < len && Character.isDigit(formula.charAt(j))) {
                    int k = j + 1;
                    while (k < len && Character.isDigit(formula.charAt(k))) {
                        k++;
                    }
                    count = Integer.valueOf(formula.substring(j, k));
                    j = k;
                }
                //递归继续求括号里面的字符串
                list.add(calculateParenthesis(count, str));
                i = j;
            }
            // 没有括号的字符串的处理
            else if (Character.isUpperCase(formula.charAt(i))) {
                Map<String, Integer> map = new HashMap<>();
                int j = i + 1;
                while (j < len && Character.isLowerCase(formula.charAt(j))) {
                    j++;
                }
                String atom = formula.substring(i, j);
                Integer count = map.get(atom);
                if (count == null) {
                    count = 0;
                }
                if (j < len && Character.isDigit(formula.charAt(j))) {
                    int k = j + 1;
                    while (k < len && Character.isDigit(formula.charAt(k))) {
                        k++;
                    }
                    count += Integer.valueOf(formula.substring(j, k));
                    i = k;
                } else {
                    count = count + 1;
                    i = j;
                }
                map.put(atom, count);
                list.add(map);
            }
        }
        Map<String, Integer> map = new TreeMap<>(String::compareTo);

        for (Map<String, Integer> m : list) {
            Set<String> set = m.keySet();
            for (String key : set) {
                if (map.containsKey(key)) {
                    //乘multiplier相当于乘括号外面的数字
                    map.put(key, m.get(key) * multiplier + map.get(key));
                } else {
                    map.put(key, m.get(key) * multiplier);
                }
            }
        }
        return map;
    }
}
