class Solution {

    List<String> answer = new ArrayList<>();
    void combination(String digits, int i, String temp, Map<Integer,String> map){
        if(i>=digits.length()){
            answer.add(temp);
            return;
        }
        int curr = digits.charAt(i) - '0';
        String str = map.get(curr);
        for(int j =  0;j<str.length();j++) {

            temp += str.charAt(j);
            combination(digits,i+1,temp,map);
            temp = temp.substring(0,temp.length()-1);

        }
    }
    public List<String> letterCombinations(String digits) {

        Map<Integer, String> map = new HashMap<>();

        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        answer.clear();

        if(digits.length() ==  0){
            return answer;
        }

        combination(digits,0, "", map);

        return answer;

        
    }
}