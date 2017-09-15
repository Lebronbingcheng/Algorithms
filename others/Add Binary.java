public class Solution {
    /*
     * @param a: a number
     * @param b: a number
     * @return: the result
     */
    public String addBinary(String a, String b) {
        // write your code here
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        int lena = as.length;
        int lenb = bs.length;
        Stack<Character> stack = new Stack();
        int i = lena - 1;
        int j = lenb - 1;
        boolean more = false;
        while (i >= 0 && j >= 0) {
            if (as[i] == '0' && bs[j] == '0') {
                if (more) {
                    stack.push('1');
                    more = false;
                } else {
                    stack.push('0');
                }
            } else if (as[i] == '1' && bs[j] == '0' || as[i] == '0' && bs[j] == '1') {
                if (more) {
                    stack.push('0');
                } else {
                    stack.push('1');
                }
            } else {
                if (more) {
                    stack.push('1');
                } else {
                    stack.push('0');
                    more = true;
                }
            }
            i--;
            j--;
        }
        if (i >= 0) {
            while (i >= 0) {
                if (as[i] == '0') {
                    if (more) {
                        stack.push('1');
                        more = false;
                    } else {
                        stack.push('0');
                    }
                } else {
                    if (more) {
                        stack.push('0');
                    } else {
                        stack.push('1');
                    }
                }
                i--;
            }
        }

        if (j >= 0) {
            while (j >= 0) {
                if (bs[j] == '0') {
                    if (more) {
                        stack.push('1');
                        more = false;
                    } else {
                        stack.push('0');
                    }
                } else {
                    if (more) {
                        stack.push('0');
                    } else {
                        stack.push('1');
                    }
                }
                j--;
            }
        }
        if (more) {
            stack.push('1');
        }
        String result = "";
        while (!stack.empty()) {
            result = result + stack.pop().toString();
        }
        return result;
    }
}
