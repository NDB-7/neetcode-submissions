class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        int minLength = 200;

        for (String s : strs) {
            int len = s.length();
            if (len < minLength) minLength = len;
        }

        if (minLength == 0) return "";

        int i = 0;
        StringBuilder sb = new StringBuilder();

        String result = "";

        while (i < minLength) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != c) return result;
            }
            result = result + c;
            i++;
        }

        return result;
    }
}