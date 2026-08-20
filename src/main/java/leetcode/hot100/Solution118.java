package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(List.of(1)));
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            cur.add(1);
            List<Integer> list = res.get(i - 1);
            for (int j = 1; j < i; j++) {
                cur.add(list.get(j - 1) + list.get(j));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
}