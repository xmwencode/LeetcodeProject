package leetcode.ling.slidingwindow.fixedlength;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordNum = words.length;
        int wordLen = words[0].length(); // 一个单词的长度
        int winLen = wordLen * wordNum; // 滑动窗口的长度
        // 目标：滑动窗口中单词出现的次数与 words 中每个单词出现的次数一致
        Map<String, Integer> needCnt = new HashMap<>();
        for (String word : words) {
            needCnt.merge(word, 1, Integer::sum);
        }
        List<Integer> ans = new ArrayList<>();
        for (int start = 0; start < wordLen; start++) {
            // 统计窗口中当前每个目标单词的出现次数
            Map<String, Integer> winCnt = new HashMap<>();
            // 窗口左边界
            int left = start;
            // 遍历每一个可能单词的起始位置
            for (int right = left + wordLen; right <= s.length(); right += wordLen) {
                String curWord = s.substring(right - wordLen, right);
                // 当前单词不在目标列表，窗口全部作废
                if (!needCnt.containsKey(curWord)) {
                    winCnt.clear();
                    left = right;
                    continue;
                }
                // 单词是需要的单词，加入窗口
                winCnt.merge(curWord, 1, Integer::sum);
                // 单词数量超标，移动左边界，移出单词直到数量合法
                while (winCnt.get(curWord) > needCnt.get(curWord)) {
                    String leftWord = s.substring(left, left + wordLen);
                    winCnt.merge(leftWord, -1, Integer::sum);
                    left += wordLen;
                }

                // 窗口包含单词总个数一致则匹配成功
                if ((right - left) / wordLen == wordNum) {
                    ans.add(left);
                }
            }
        }
        return ans;
    }
}