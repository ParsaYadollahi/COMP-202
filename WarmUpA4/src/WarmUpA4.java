import java.util.Arrays;

public class WarmUpA4 {

	public static void main(String[] args) {
		double[][] x = {{1,1,1}, {3,3}};
		System.out.println(Arrays.toString(largestAverage(x)));

	}
	//A method that determines which subArray has the most elements
	public static int longestSubArray(int[][] a) {
		//assume that the first subArray is the largest
		int length = a[0].length;
		//Loop through all subArrays
		for(int i=1;i<=a.length-1; i++) {
			//if array at index i is larger than that at 0
			//replace variable length by that
			if(a[i].length >= length){
				length = a[i].length;
			}
			//Else return the same length at at index 0
		}
		return length;
	}
	
	public static boolean subArraySame(int[][] a) {
		//loop going through all subArrays
		for(int i = 0; i < a.length; i++) {
			//loop going through all elements of the subArrays
			for(int j = 0; j< a[i].length-1; j++) {
				//Contradiction
				if(a[i][j] != a[i][j+1]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static double[] largestAverage(double[][] a) {
		int idx = 0;
		double max = Double.MIN_VALUE + 1;
		
		for (int i = 0; i < a.length; i++) {
			double sum = 0;
			for (int j = 0; j < a[i].length; j++) {
				sum += a[i][j];
			}
			double avg = sum / a[i].length;
			if (avg > max) {
				idx = i;
				max = avg;
			}
		}
		return a[idx];
		
//		double valueOfFirst = 0;
//		double valueOfNext = 0;
//		//loop through all SubArrays
//		for(int j = 0; j < a[0].length; j++) {
//			valueOfFirst += a[0][j];
//		}
//		double largestvalue1 = valueOfFirst/a[0].length;
//		double[] largestarray = a[0];
//		for(int i = 0; i < a.length; i++) {
//			for(int k = 0; k < a[i].length; k++) {
//				valueOfNext += a[i][k];
//			}
//			double largestvalue2 = valueOfNext/a[i].length;
//			if(largestvalue2 > largestvalue1) {
//				largestvalue1 = largestvalue2;
//				a[0] = a[i];
//			}
//		}
//		return a[0];
	}
}
			
			