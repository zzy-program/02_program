import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class my_file {

	private static final String FILENAME = "a.txt";

	public static boolean is_file_exist(String name) {
		File tmp = new File(name);

		if(tmp.exists() && tmp.isDirectory()) {
			return true;
		}

		return false;
	}

	public static void read_file () {
		BufferedReader br = null;
		FileReader fr = null;
		try {
			if(is_file_exist("/home/zzy")) {
				System.out.println("file /home/zzy exist\n");
			}
			if(!is_file_exist(FILENAME)) {
				System.out.println("file " + FILENAME + " not exist");
				return;
			}
			fr = new FileReader(FILENAME);
			if(fr == null) {
				System.out.println("file reader error!\n");
				return;
			}
			br = new BufferedReader(fr);
			if(br == null) {
				System.out.println("buffered reader error!\n");
				return;
			}

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		read_file();
	}
}
