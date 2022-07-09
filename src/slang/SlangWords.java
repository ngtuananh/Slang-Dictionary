package slang;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Random;

public class SlangWords {
	private HashMap<String, ArrayList<String>> slangWordList;
	private LinkedList<String> historySlang;
	
	public SlangWords() {
		slangWordList = new HashMap<String, ArrayList<String>>();
		historySlang = new LinkedList<String>();
	}
	
	public void setHistorySlang(String slang) {
		this.historySlang.add(slang);
	}

	public LinkedList<String> getHistorySlang(){
		return this.historySlang;
	}
	
	public ArrayList<String> searchBySlang(String slang){
		this.setHistorySlang(slang);
		return this.slangWordList.get(slang);
	}
	
	public ArrayList<String> searchByDefinition(String definition){
		ArrayList<String> slangs = new ArrayList<String>();
		for (Entry<String, ArrayList<String>> entry : this.slangWordList.entrySet()) {			
			ArrayList<String> definitions = entry.getValue();
			ListIterator<String> listIterator = definitions.listIterator();
			while(listIterator.hasNext()) {
				String tempDefinition = listIterator.next();
				if (tempDefinition.toLowerCase().contains(definition.toLowerCase())) {
					slangs.add(entry.getKey());
					break;
				}
			}
		}		
		return slangs;
	}
	
	public void addSlangWord(String slang, String definition) {
		ArrayList<String> definitionList = new ArrayList<String>();
		definitionList.add(definition);
		this.slangWordList.put(slang, definitionList);
	}
	
	public void addDefinition(String slang, String definition) {
		this.slangWordList.get(slang).add(definition);
	}
	
	public boolean editSlangWord(String slang, String oldDef, String newDef) {
		ArrayList<String> definitionList = this.slangWordList.get(slang);
		if(definitionList != null) {			
			for (String def: definitionList) {
				if (def.trim().equals(oldDef.trim())) {
					definitionList.remove(oldDef);
					definitionList.add(newDef);
					return true;
				}
			}
		}
		return false;	
	}
	
	public void removeSlangWord(String slang) {
		this.slangWordList.remove(slang);
	}
	
	public String randomSlangWord() {
		Random rd = new Random();
		ArrayList<String> slangs = new ArrayList<String>(this.slangWordList.keySet());
		return slangs.get(rd.nextInt(slangs.size()));		
	}
	
	
}
