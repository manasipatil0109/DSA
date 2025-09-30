/*
 * 171. Excel Sheet Column Number

Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnTitle = "A"
Output: 1
Example 2:

Input: columnTitle = "AB"
Output: 28
Example 3:

Input: columnTitle = "ZY"
Output: 701
 

Constraints:

1 <= columnTitle.length <= 7
columnTitle consists only of uppercase English letters.
columnTitle is in the range ["A", "FXSHRXW"].
 */


package General;

public class Excel_Sheet_Column {
    public int titleToNumber(String columnTitle) {
        int result=0;
        for(int i=columnTitle.length()-1,j=0;i>=0;i--,j++){
            result+=Math.pow(26,j)*(columnTitle.charAt(i)-'A'+1);
        }
        return result;
    }
}
