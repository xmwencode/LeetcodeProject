package com.xm.leetcode.everyday;

class Solution3635 {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // 可以先完成陆地设施，在完成水上设施
        return Math.min(
                solve(landStartTime, landDuration, waterStartTime, waterDuration),
                solve(waterStartTime, waterDuration, landStartTime, landDuration)
        );
    }

    private int solve(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // 假设先完成陆地设施，在完成水上设施，则陆地设施的最早完成标准是 start + duration 最早
        int minLandTime = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            minLandTime = Math.min(minLandTime, landStartTime[i] + landDuration[i]);
        }
        // 从最早陆地完成时间开始计算，水上最早完成标准是 max(minLandTime, start) + duration 最早
        int minWaterTime = Integer.MAX_VALUE;
        for (int i = 0; i < waterStartTime.length; i++) {
            minWaterTime = Math.min(minWaterTime, Math.max(minLandTime, waterStartTime[i]) + waterDuration[i]);
        }
        return minWaterTime;
    }
}