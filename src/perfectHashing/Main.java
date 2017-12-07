package perfectHashing;

import java.io.File;
import fileManipulator.ReadTextFile;

public class Main {
	
	public static void main(String[] args){
		String fileName = "//keys10000001000000.txt";
		File file = new File(System.getProperty("user.home")+fileName);
		ReadTextFile readTextFile = new ReadTextFile();
		Integer[] values = readTextFile.readFile(file);
		boolean chechValues = true;
		int n=values.length;
		
		/**
		 * TEST NN SPACE SOL
		 */
		
//		NNSpaceSol nnSpaceSol = new NNSpaceSol(values);
//		if (nnSpaceSol.hash()) {
//			System.out.println("DATA HASHED SUCCESSFULLY");
//		}
////		nnSpaceSol.printHTable();
//		
////		System.out.println("REBUILDING TRIALS :"+nnSpaceSol.getChangesNum());
//		

//		for (int i = 0; i < values.length && chechValues; i++) {
//			chechValues = nnSpaceSol.exist(values[i]);
//		}
//		if (chechValues) {
//			System.out.println("ALL ELEMENTS EXISTS");
//		}else{
//			System.out.println("FAILD TO FIND SOME ELEMENTS");
//		}
				
		
		System.out.println("================================");
		/**
		 * TEST N SPACE SOL.
		 */
		
		NSpaceSol nSpaceSol = new NSpaceSol(values);
		if (nSpaceSol.hash()){
			System.out.println("DATA HASHED SUCCESSFULLY");
		}
//		nSpaceSol.printHTable();
		
//		nSpaceSol.printRebuildingTrials();
		
		chechValues = true;
		for (int i = 0; i < values.length && chechValues; i++) {
			chechValues = nSpaceSol.exist(values[i]);
		}
		if (chechValues) {
			System.out.println("ALL ELEMENTS EXISTS");
			System.out.println(n+" elements take space "+nSpaceSol.getSpaceUsed());
		}else{
			System.out.println("FAILD TO FIND SOME ELEMENTS");
		}
	}
}