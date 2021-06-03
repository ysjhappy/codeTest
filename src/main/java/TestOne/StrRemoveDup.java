package TestOne;

import java.util.Stack;

/**
 * 去除重复字母
 * 难度：中等
 */
public class StrRemoveDup {
    /**
     * 输入：s = "cbacdcbc"
     * 输出："acdb"
     * 解题思路：
     *      1 定义存放去重结果的栈
     *      2 遍历字符串s
     *          2.1 若当前字母不在栈中,则插入栈顶并标记为存在
     *          2.2 若当前字母在栈中，直接跳过
     */
    public static String removeDuplicateLetters(String s) {

        //存放去重的结果
        Stack<Character> stk = new Stack<>();
        // 维护一个计数器记录字符串中字符的数量；因为输入为 ASCII 字符，大小 256 够用了
        int[] count = new int[256];
        for(int i = 0;i< s.length(); i++){
            //s.charAt(i)得到的值是某个字符；count[字符]相当于count[此字符对应的ascii码值]，例如count[c]=count[99],遍历s时，出现一次此字符，对应的值就加1记录一下
            count[s.charAt(i)]++;
        }
        //记录栈中是否存在某个字符，布尔数组初始值默认为false,输入字符均为ascii字符，所以大小256够用了
        boolean[] inStack = new boolean[256];
        for (char c:s.toCharArray()){
            // 每遍历过一个字符，都将对应的计数减一
            count[c]--;
            if (inStack[c]){
                continue;
            }
            while (!stk.empty() && stk.peek() > c){
                // 若之后不存在栈顶元素了，则停止 pop
                if (count[stk.peek()] == 0){
                    break;
                }
                //若之后还有，则可以pop
                inStack[stk.pop()]=false;
            }
            stk.push(c);
            inStack[c] = true;
        }
        //把存放去重字母的栈内容存放到stringbuilder中
        StringBuilder sb = new StringBuilder();
        while (!stk.empty()){
            sb.append(stk.pop());
        }
        //栈中元素插入顺序是反的，需要reverse一下
        return sb.reverse().toString();
    }

    /**
     * note:
     *  1.如何定义栈
     *  2.什么时候使用栈,push，pop,peek的使用场景和特点,参考：https://blog.csdn.net/xdc17824032252/article/details/94118980
     *  3.如何定义布尔数组(达到去重目的)
     *  4.什么时候使用布尔数组
     *  5.字符char的了解，toCharArray()使用场景，转char的方法有哪些
     *  6.reverse()方法的使用
     *  7.因为输入为 ASCII 字符，大小 256 够用了
     *      *A-Z 65-90
     * 	    *a-z 97-122
     */

    public static void main(String[] args) {
        String ans = removeDuplicateLetters("cbacdcbc");
//        String ans = removeDuplicateLetters("bcabc");
        System.out.println(ans);
    }

}
