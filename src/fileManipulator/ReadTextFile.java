package fileManipulator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTextFile {

	public Integer[] readFile(File file) {
		Integer values[] = null;
		try {
			Scanner in = new Scanner(file);
			String[] s = in.useDelimiter("\\Z").next().split(",");
			in.close();
			values = new Integer[s.length];
			for (int i = 0; i < s.length; i++) {
				values[i] = Integer.parseInt(s[i]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return values;
	}
}