package com.xm.leetcode.everyday;

class Solution3633 {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(
                solve(landStartTime, landDuration, waterStartTime, waterDuration),
                solve(waterStartTime, waterDuration, landStartTime, landDuration)
        );
    }

    private int solve(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // 假设先完成陆地项目，在完成水上项目，则陆地项目 start + duration 越早越好
        int minFinishTime = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            minFinishTime = Math.min(minFinishTime, landStartTime[i] + landDuration[i]);
        }
        int res = Integer.MAX_VALUE;
        // 此时再完成水上项目，只需要 max(minFinishTime, 水上项目开始时间) + 水上项目持续时间 最小即可
        for (int i = 0; i < waterStartTime.length; i++) {
            res = Math.min(res, Math.max(minFinishTime, waterStartTime[i]) + waterDuration[i]);
        }
        return res;
    }
}