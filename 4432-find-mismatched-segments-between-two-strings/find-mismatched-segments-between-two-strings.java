class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {

        List<List<String>> result = new ArrayList<>();

        int i = 0;
        while (i < s1.length()) {
           if (s1.charAt(i) == s2.charAt(i)) {
                i++;
                continue;
            }

            int start = i;
            while (i < s1.length() &&
                   s1.charAt(i) != s2.charAt(i)) {
                i++;
            }

            String sub1 = s1.substring(start, i);
            String sub2 = s2.substring(start, i);

            List<String> temp = new ArrayList<>();
            temp.add(sub1);
            temp.add(sub2);

            result.add(temp);
        }

        return result;
    }
}
