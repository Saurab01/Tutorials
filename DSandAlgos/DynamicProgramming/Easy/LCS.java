public class LCS
{
	public static int LCSlength(char[] X, char[] Y)
	{
		int m = X.length, n = Y.length;
		int[][] T = new int[m + 1][n + 1];

		// fill the lookup table in bottom-up manner
		for (int i = 0; i <= m; i++)
		{
			for (int j = 0; j <= n; j++)
			{
				if (i==0 || j==0)
					T[i][j]=0;
				else if (X[i - 1] == Y[j - 1]) {  //if matches
					T[i][j] = T[i - 1][j - 1] + 1;
				}
				else {  //if does not match
					T[i][j] = Integer.max(T[i - 1][j], T[i][j - 1]);
				}
			}
		}

		// LCS will be last entry in the lookup table
		return T[m][n]; 
	}

	public static void main(String[] args)
	{
		String X = "SAURABH", Y = "ARNAB";

		System.out.print("The length of LCS is " + LCSlength(X.toCharArray(), Y.toCharArray()));
	}
}
