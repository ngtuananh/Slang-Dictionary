package slang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map.Entry;

public class SlangWordsIO {
	
	public static void read(HashMap<String, ArrayList<String>> slangWordList, String pathFile) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(pathFile));
			String line;
			while((line = br.readLine()) != null) {
				String[] parts = line.split("`");
				if (parts.length == 2) {
					String[] definitionPart = parts[1].split("\\|");
					ArrayList<String> definitions = new ArrayList<String>();
					for (String s : definitionPart) {
						s = s.trim();
						definitions.add(s);
					}
					slangWordList.put(parts[0].trim(), definitions);
				}
			}
			if(br != null) {
				br.close();
			}
		} 
		catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void write(HashMap<String, ArrayList<String>> slangWordList, String pathFile) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(pathFile));
			for (Entry<String, ArrayList<String>> entry : slangWordList.entrySet()) {
				String slang = entry.getKey();
				ArrayList<String> definitions = entry.getValue();
				ListIterator<String> li = definitions.listIterator();
				String str = li.next();
				while(li.hasNext()) {
					str += "| " + li.next();
				}
				bw.write(slang + "`" + str + "\n");
				
			}		
			bw.close();
		}
		catch (IOException e) {
            e.printStackTrace();
        }
	}

	
}
