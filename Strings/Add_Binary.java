/*
 * 67. Add Binary
Given two binary strings a and b, return their sum as a binary string.
 
Example 1:
Input: a = "11", b = "1"
Output: "100"

Example 2:
Input: a = "1010", b = "1011"
Output: "10101"
 */

package Strings;

public class Add_Binary {
    public String addBinary(String a, String b) {
        if(b.equals("0"))
            return a;
        if(a.equals("0"))
            return b;
        int carry=0;
        StringBuilder sb = new StringBuilder("");
        int i,j;
        for(i=a.length()-1, j=b.length()-1;i>=0 && j>=0;i--,j--){
            char c1 = a.charAt(i);
            char c2 = b.charAt(j);
            if(c1=='1' && c2=='1'){
                if(carry==0){
                    sb.append("0");
                }else{
                    sb.append("1");
                }
                carry=1;
            } else if((c1=='0' && c2=='1') ||(c1=='1' && c2=='0')){
                if(carry==0){
                    sb.append("1");
                    carry=0;
                }else{
                    sb.append("0");
                    carry=1;
                }
            } else{
                if(carry==0){
                    sb.append("0");
                }else{
                    sb.append("1");
                }
                carry=0;
            }
        }
        while(i>=0){
            if(carry==1){
                char c1 = a.charAt(i);
                if(c1=='0'){
                    sb.append("1");
                    carry=0;
                } else{
                    sb.append("0");
                    carry=1;
                }
            }else{
                char c1 = a.charAt(i);
                if(c1=='0'){
                    sb.append("0");
                } else{
                    sb.append("1");
                }
                carry=0;
            }
            i--;
        }
        while(j>=0){
            if(carry==1){
                char c1 = b.charAt(j);
                if(c1=='0'){
                    sb.append("1");
                    carry=0;
                } else{
                    sb.append("0");
                    carry=1;
                }
            }else{
                char c1 = b.charAt(j);
                if(c1=='0'){
                    sb.append("0");
                } else{
                    sb.append("1");
                }
                carry=0;
            }
            j--;
        }
        if(carry==1)
            sb.append("1");
        return sb.reverse().toString();
    }
}
