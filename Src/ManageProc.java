package Functionality;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

import CFG.CFGNode;
import CFG.CFGTree;
import MainModule.MainFile;
import ParserToZ3.Parser;


// code to manage the IF statement 
public class ManageProc {
	
	public static void mainfunction(String lbl) throws IOException
	{	
		if (lbl.contains("Main")){
		}
		else{
			String words[] = lbl.split("VAR");
			int n = MainFile.map.size();
			ArrayList<String> pars = new ArrayList<String>();
			for(int i=1;i<words.length;i++){
				//System.out.println(words[i].length() +" " + words[i]);
				String var[] = words[i].split(" ");
				for(int j=0;j<var.length;j++)
					{
						if (!var[j].equals("num") && !var[j].equals(" ") && !var[j].equals(")") && !var[j].equals(",") && !var[j].equals(""))
							pars.add(var[j]);
					}
			}
			int k=0;
			for (String name : MainFile.map.keySet()){
				MainFile.actual_formal_map.put(pars.get(k),name);
				k++;
			}
			System.out.println(MainFile.actual_formal_map);
		}

		
	}
		
	
	
}
