package universalHashing;

import java.util.Random;

public class MatrixMethodUH {

	/**
	 * number of elements.
	 */
	private int hFLen = 0;
	
	/**
	 * hFunction
	 */
	private int[] hFunction;
	
	/**
	 * element size
	 */
	private int n;

	/**
	 * @param n is number of elements needed to be hashed
	 */
	public MatrixMethodUH(int n) {
		if(n>0) {
			this.n = n;
			hFLen = (int) (Math.floor((Math.log(n) / Math.log(2)))+1);
			hFunction = new int[hFLen];
		}
		generateHF();
	}
	
	/**
	 * generate a new hash function.
	 */
	public void generateHF(){
		Random r = new Random();
			for (int i = 0; i < hFLen; i++) {
				hFunction[i] = r.nextInt();
			}
	}
	
	
	/**
	 * @param value needed to be hashed
	 * @return the equivalent hashing
	 */
	public int hashing(int value){
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < hFLen; i++) {
			builder.append((Integer.bitCount(value & hFunction[i]))%2);
		}
		return (Integer.parseInt(builder.toString(),2)%n);
	}
}