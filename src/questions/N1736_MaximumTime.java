package questions;

/**
 * 给你一个字符串 time ，格式为  hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 * <p>
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 * <p>
 * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 */
class SolutionN1736 {
    public String maximumTime(String time) {
        char[] timeChars = time.toCharArray();
        if (timeChars[0] == '?') {
            timeChars[0] = timeChars[1] == '?' ? '2' : ( timeChars[1] >= '4' ? '1' : '2' );
        }
        if (timeChars[1] == '?') {
            timeChars[1] = timeChars[0] < '2' ? '9' : '3';
        }
        if (timeChars[3] == '?') {
            timeChars[3] = '5';
        }
        if (timeChars[4] == '?') {
            timeChars[4] = '9';
        }
        return new String(timeChars);
    }
}