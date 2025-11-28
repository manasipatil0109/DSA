package Strings;

public class Is_Subsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length())
            return false;
        int j=0;
        for(int i=0;i<t.length() && j<s.length();i++){
            while(i<t.length() && s.charAt(j)!=t.charAt(i)){
                i++;
            }
            if(i == t.length())
                return false;
            j++;
        }
        if(j == s.length())
            return true;
        else
            return false;
    }
}
