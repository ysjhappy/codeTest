package TestOne;

import java.util.HashMap;
import java.util.Map;

/**
 *  无重复字符的最长子串
 */
public class StrSolution {
    /**
     * 标签：滑动窗口
     * 思路：
     * 1.定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
     * 2.我们定义不重复子串(map)的开始位置为 start，结束位置为 end
     * 3.随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，
     * 并更新 start，此时 [start, end] 区间内不存在重复字符
     * 4.无论是否更新 start，都会更新其 map 数据结构和结果ans
     * 实践复杂度：O(n)
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
    /*public static int myLengthOfLongestSubstring(String s) {
        //定义子串，用来存储不重复字符
        Map<Character,Integer> map = new HashMap<>();
        //定义不重复字串的长度
        int ans = 0;
        //遍历字符串参数s pwewkqw
        for (int start = 0,end = 0; end < s.length(); end++){
            // charAt() 获取当前索引的对应字符
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)){
                //当前字符在子串中，start节点右移（更新start），直到子串不包含此字符（更新到子串），更新ans,更新end
                start = Math.max(map.get(alpha), start);
                System.out.println(start);
            }
            //当前字符不在子串中，加入到子串，并且更新ans，更新end
            map.put(alpha,end+1);
            System.out.println("ans = "+ans);
            System.out.println("end-start+1 = "+(end-start+1));
            ans = Math.max(ans,end-start+1);
        }
        return ans;
    }*/

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();//获取开始时间
        int ans = lengthOfLongestSubstring("pwewkqw");
        long endTime = System.currentTimeMillis();//获取结束时间
        System.out.println("无重复字符的最长字串的长度 = "+ans);
        System.out.println("执行时间:"+(endTime-startTime)+"ms");

    }
}
