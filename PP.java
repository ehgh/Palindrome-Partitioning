import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

class PP{
	public static void main(String args[]){
		Scanner scanner  = new Scanner(System.in);
		String S;
		S = scanner.next();
		int len = S.length();
		int[][] memo = new int[len][len];
		for (int i = 0; i< len; i++){
			Arrays.fill(memo[i], -1);
		}
		scanner.close();
		System.out.println(score(S, 0, len-1, memo));
		Random rng = new Random();
		String rand = generateString(rng, "abcd", 1000);
		System.out.println(rand);

	}

	private static int score(String S, int i, int j, int[][] memo){
		if (memo[i][j] != -1)
			return memo[i][j];
		if (palindrome(S, i, j))
			return 0;
		int value = j - i;
		int temp;
		for (int k = i; k<j; k++){
			temp = 1 + score(S, i, k, memo) + score(S , k+1, j, memo);
			if (temp < value)
				value = temp;
		}
		memo[i][j] = value;
		return value;
	}

	private static boolean palindrome(String S, int i, int j){
		String temp = S.substring(i, j+1);
		String sReverse = new StringBuilder(temp).reverse().toString();
		if (sReverse.equals(temp)){
			return true;
		}
		else
			return false;
	}
	
	public static String generateString(Random rng, String characters, int length)
	{
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(rng.nextInt(characters.length()));
	    }
	    return new String(text);
	}

}
