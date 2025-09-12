/*
 * 374. Guess Number Higher or Lower

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked (the number I picked stays the same throughout the game).

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns three possible results:

-1: Your guess is higher than the number I picked (i.e. num > pick).
1: Your guess is lower than the number I picked (i.e. num < pick).
0: your guess is equal to the number I picked (i.e. num == pick).
Return the number that I picked.

 

Example 1:

Input: n = 10, pick = 6
Output: 6
Example 2:

Input: n = 1, pick = 1
Output: 1
Example 3:

Input: n = 2, pick = 1
Output: 1
 

Constraints:

1 <= n <= 231 - 1
1 <= pick <= n
 */


package General;

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Guess_Game {
    public int guessNumber(int n) {
        int l=1;
        int r=n;
        while(l<=r){
            int mid = l+(r-l)/2;
            int ra = guess(mid);
                                    if(ra==0)
                                        return mid;
                                    else if(ra==1)
                                        l=mid+1;
                                    else
                                        r=mid-1;
                                }
                                return -1;
                        
                                /*
                                 * This solution gave time limit exceeded issue
                                 */
                                // int r=(int)(Math.random()*n)+1;
                                // while(guess(r)!=0){
                                //     r = (int)(Math.random()*n)+1;
                                // }
                                // return r;
                            }
            
                /*
                 * Unnecessary code part
                 */
                private int guess(int mid) {
                    // TODO Auto-generated method stub
                    throw new UnsupportedOperationException("Unimplemented method 'guess'");
                }
}
