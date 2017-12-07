package perfectHashing;

import java.util.ArrayList;
import universalHashing.MatrixMethodUH;

public class NSpaceSol {

	private Integer[] values;
	private NNSpaceSol[] hashTable;
	private int size;
	private MatrixMethodUH hashFunction;

	public NSpaceSol(Integer[] values) {
		this.values = values;
		size = values.length;
		hashFunction = new MatrixMethodUH(size);
	}

	public boolean hash() {
		hashTable = new NNSpaceSol[size];
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] distributedData = new ArrayList[size];
		for (int i = 0; i < distributedData.length; i++) {
			distributedData[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < size; i++) {
			int idx = hashFunction.hashing(values[i]);
			if (!distributedData[idx].contains(values[i])) {
				distributedData[idx].add(values[i]);
			}
		}

		boolean finish = true;
		for (int i = 0; i < size && finish; i++) {
			Integer[] data = new Integer[distributedData[i].size()];
			data = distributedData[i].toArray(data);
			hashTable[i] = new NNSpaceSol(data);
			finish = hashTable[i].hash();
		}
		return finish;
	}

	public boolean exist(int value) {
		if (hashTable[hashFunction.hashing(value)] == null) {
			return false;
		}
		return hashTable[hashFunction.hashing(value)].exist(value);
	}

	/**
	 * ====================PRINT=======================
	 */

	public void printHTable() {
		for (int i = 0; i < hashTable.length; i++) {
			System.out.print("INDEX:" + i + " >> ");
			hashTable[i].printHTable();
		}
	}

	public void printRebuildingTrials() {
		for (int i = 0; i < hashTable.length; i++) {
			System.out.println("REBUILDING TRIALS AT INDEX:" + i + " >> " + hashTable[i].getChangesNum());
		}
	}

	public int getSpaceUsed() {
		int space = 0;
		for (int i = 0; i < hashTable.length; i++) {
			space += hashTable[i].getSpaceUsed();
		}
		space += size;
		return space;
	}
}