class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        String newString = "";

        for (String s : strs) {
            newString += s.length();
            newString += ";";
        }

        newString += "#";

        for (String s : strs) {
            newString += s;
        }

        return newString;
    }

    public List<String> decode(String str) {
        if (str.length() == 0) return new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();

        int i = 0;

        while (str.charAt(i) != '#') {
            String currString = "";
            while (str.charAt(i) != ';') {
                currString += str.charAt(i);
                i++;
            }

            sizes.add(Integer.valueOf(currString));
            i++;
        }

        i++;

        List<String> res = new ArrayList<>();

        for (int size : sizes) {
            res.add(str.substring(i, i + size));
            i += size;
        }

        return res;
    }
}
