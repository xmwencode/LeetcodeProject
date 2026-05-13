package com.xm.acwing.improve.search.shortestcircuitmodel;

import java.util.*;

public class Main1107 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(sc.nextInt());
        }
        String target = sb.toString();
        String start = "12345678";

        Map<String, String> map = new HashMap<>();
        Deque<String> queue = new ArrayDeque<>();
        map.put(start, "");
        queue.offer(start);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur.equals(target)) {
                String path = map.get(cur);
                System.out.println(path.length());
                System.out.println(path);
                return;
            }

            // A：交换上下两行
            String a = "" + cur.charAt(7) + cur.charAt(6) + cur.charAt(5) + cur.charAt(4)
                    + cur.charAt(3) + cur.charAt(2) + cur.charAt(1) + cur.charAt(0);
            // B：最右列插到最左边
            String b = "" + cur.charAt(3) + cur.charAt(0) + cur.charAt(1) + cur.charAt(2)
                    + cur.charAt(5) + cur.charAt(6) + cur.charAt(7) + cur.charAt(4);
            // C：中央4数顺时针旋转
            String c = "" + cur.charAt(0) + cur.charAt(6) + cur.charAt(1) + cur.charAt(3)
                    + cur.charAt(4) + cur.charAt(2) + cur.charAt(5) + cur.charAt(7);

            for (String[] next : new String[][]{{a, "A"}, {b, "B"}, {c, "C"}}) {
                if (!map.containsKey(next[0])) {
                    map.put(next[0], map.get(cur) + next[1]);
                    queue.offer(next[0]);
                }
            }
        }
    }
}
