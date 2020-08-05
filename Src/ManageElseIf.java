package Functionality;

import java.io.FileWriter;
import java.io.IOException;

import CFG.CFGNode;
import CFG.CFGTree;
import MainModule.MainFile;
import ParserToZ3.Parser;

//manage ElseIf statements 

public class ManageElseIf {
	public static void mainfunction(String lbl,boolean flag) throws IOException
	{	
		//String path="C:\\Users\\Mayank\\git\\PEMM\\PEMM\\src\\output.txt"; // path specified
		String words[]=lbl.split(" ");
		String condition="";
		for(int i=1;i<words.length-1;i++)
		{
			condition=condition+words[i];
		}
		if(flag==true){
			CFGNode n=new CFGNode("ELSEIF",condition);
			insertElseIf(n);
			String parsered="";
			if(n.prevConditions.length()>0)
			parsered=Parser.parse(n.prevConditions+" & "+n.Condition);
			else
			parsered=Parser.parse(n.Condition);	
			System.out.println(" else if conditon and previous condition "+n.Condition+" "+n.prevConditions);
			FileWriter f=new FileWriter(MainFile.output,true);
			f.write("(assert "+parsered+" )\n");
			f.close();
		}
		else
		{
			System.out.println("ElseIf skipped!!");
		}

		
		
	}
	
	public static void insertElseIf(CFGNode n)
	{
	
		n.prev=CFGTree.nd.peek();
		n.prevConditions="(!( "+n.prev.Condition+" ))";
		//System.out.println("");
		if(n.prev.prevConditions.length()>0)
		n.prevConditions=n.prevConditions+" & "+n.prev.prevConditions;
		
		CFGTree.nd.peek().fal=n;
		CFGTree.nd.push(n);
		System.out.println("else if node inserteds");
	}
}
