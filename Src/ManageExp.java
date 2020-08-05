package Functionality;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

import CFG.CFGNode;
import CFG.CFGTree;
import MainModule.MainFile;
import ParserToZ3.Parser;


// code to manage the IF statement 
public class ManageExp {
	
	public static void mainfunction(String lbl) throws IOException
	{	
		String words[] = lbl.split(":=|;");
		
		String word[] = words[0].split(" ");	
		///System.out.println(word[0]);
		String key = MainFile.actual_formal_map.get(word[0]);
		if(key!=null){
			int x = MainFile.map.get(key);
			x = 2*x;
			System.out.println(key);
			
			MainFile.map.replace(key,x);	
			
			System.out.println(MainFile.map);
		}
		
		
	}
		
}
