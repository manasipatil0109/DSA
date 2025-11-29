package Strings;

public class Max_Number_of_Vowels_in_Substring {

    /*
    Solution 1 
    */
    public int maxVowels(String s, int k) {
        String vowels = "aeiou";
        int max=0;
        char[] ch = s.toCharArray();
        int i=0;
        while(i<k){
            if(vowels.indexOf(ch[i])>=0)
                max++;
            i++;
        }
        if(max==k)
            return k;
        int curr = max;
        while(i<ch.length){
            if(vowels.indexOf(ch[i-k])>=0)
                curr-=1;
            if(vowels.indexOf(ch[i])>=0)
                curr+=1;
            max = Math.max(max, curr);
            if(max==k)
                return k;
            i++;
        }
        return max;
    }

    /*
    Solution 2 - very faster 
    */
   public int maxVowels1(String s, int k) {
        boolean[] isVowel = new boolean[26];
        isVowel['a' - 'a'] = true;
        isVowel['e' - 'a'] = true;
        isVowel['i' - 'a'] = true;
        isVowel['o' - 'a'] = true;
        isVowel['u' - 'a'] = true;

        char[] ch = s.toCharArray();
        int max = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel[ch[i] - 'a']) max++;
        }

        int current = max;
        if (max == k) return k;

        for (int i = k; i < ch.length; i++) {
            if (isVowel[ch[i - k] - 'a']) current--;
            if (isVowel[ch[i] - 'a']) current++;

            max = Math.max(max, current);
            if (max == k) return k;
        }

        return max;
    }
}
