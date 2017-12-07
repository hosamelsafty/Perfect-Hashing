package perfectHashing;

import universalHashing.MatrixMethodUH;

public class NNSpaceSol {

	private Integer[] values, hTable;
	private int n, changesNum;
	private boolean collision;
	MatrixMethodUH hFunction;

	public NNSpaceSol(Integer[] values) {
		this.values = values;
		n = values.length;
		changesNum = 0;
		collision = true;
		this.hFunction = new MatrixMethodUH(n * n);
	}

	public boolean hash() {
		if (n == 1) {
			hTable = new Integer[1];
			hTable[0] = values[0];
		} else {

			while (collision) {
				collision = false;
				hTable = new Integer[n * n];

				hFunction.generateHF();

				for (int i = 0; i < n; i++) {
					int idx = hFunction.hashing(values[i]);

					if (hTable[idx] != null && !hTable[idx].equals(values[i])) {
						System.out.println("COLLISION, AT HASHING :" + values[i] + ", TO INDEX: " + idx);
						changesNum++;
						collision = true;
						break;
					}
					hTable[idx] = values[i];
					// System.out.println(values[i]+" >> mapped to index >>
					// "+idx);
				}
			}
		}
		return true;
	}

	public int getChangesNum() {
		return changesNum;
	}

	public boolean exist(int value) {
		if (n == 0) {
			return false;
		}
		if (n == 1) {
			if (hTable[0] == value) {
				return true;
			}
			return false;
		}
		if (hTable[hFunction.hashing(value)] != null) {
			return true;
		}
		return false;
	}

	/**
	 * ====================PRINT=======================
	 */

	public void printHTable() {
		StringBuilder printer = new StringBuilder();
		printer.append('[');
		for (int i = 0; i < hTable.length; i++) {
			if (hTable[i] == null) {
				printer.append("-,");
			} else {
				printer.append(hTable[i] + ",");
			}
		}
		if (!printer.toString().contains(",")) {
			printer = new StringBuilder();
		} else {
			printer.deleteCharAt(printer.length() - 1);
			printer.append(']');
		}
		System.out.println(printer);
	}

	public int getSpaceUsed() {
		return (n * n) + n;
	}
}
