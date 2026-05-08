/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        return guessNum(1, n);
    }

    public int guessNum(int l, int r) {
        int g = l + (r - l) / 2;
        int ans = guess(g);
        if (ans == 0) return g;
        else if (ans == -1) return guessNum(l, g - 1);
        else return guessNum(g + 1, r);
    }
}