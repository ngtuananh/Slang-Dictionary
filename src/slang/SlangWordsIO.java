package slang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SlangWordsIO {
	private SlangWords slangWordList;
	
	public void read(String path) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			while(line != null) {
				String[] parts = line.split("`");
				String[] definitionPart = parts[1].split("\\|");
				ArrayList<String> definitions = new ArrayList<String>();
				for (String s : definitionPart) {
					s = s.trim();
					definitions.add(s);
				}
				this.slangWordList.setSlangWordList(parts[0].trim(), definitions);
			}
		}
		finally {
			if(br != null) {
				br.close();
			}
		}
	}
	
	
	
}
