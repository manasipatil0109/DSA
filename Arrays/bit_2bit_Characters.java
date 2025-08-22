/*
 * 717. 1-bit and 2-bit Characters

We have two special characters:

The first character can be represented by one bit 0.
The second character can be represented by two bits (10 or 11).
Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.

 

Example 1:

Input: bits = [1,0,0]
Output: true
Explanation: The only way to decode it is two-bit character and one-bit character.
So the last character is one-bit character.
Example 2:

Input: bits = [1,1,1,0]
Output: false
Explanation: The only way to decode it is two-bit character and two-bit character.
So the last character is not one-bit character.

 */

package Arrays;

public class bit_2bit_Characters {
    public boolean isOneBitCharacter(int[] bits) {
        if(bits.length==1 && bits[bits.length-1]==0)
            return true;
        if(bits.length%2==0 && bits[bits.length-1]==0 && bits[bits.length-2]!=1)
            return true;
        int flag=0;
        for(int i=0;i<bits.length;){
            if(bits[i]==0){
                i++;
                flag=0;
            }
            else if(bits[i]==1){
                i=i+2;
                flag=1;
            }
        }
        return flag==1?false:true;
    }
}
