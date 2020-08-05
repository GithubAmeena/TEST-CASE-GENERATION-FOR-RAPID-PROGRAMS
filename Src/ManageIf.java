package Functionality;

import java.io.FileWriter;
import java.io.IOException;

import CFG.CFGNode;
import CFG.CFGTree;
import MainModule.MainFile;
import ParserToZ3.Parser;


// code to manage the IF statement 
public class ManageIf {
	
	public static void mainfunction(String lbl,boolean flag) throws IOException
	{
		//String path="C:\\Users\\Mayank\\git\\PEMM\\PEMM\\src\\output.txt"; //path specified
		String words[]=lbl.split(" ");
		String condition="";
		for(int i=1;i<words.length-1;i++)
		{
			condition=condition+words[i];
		}

		if(flag==true){
			CFGNode node = new CFGNode("IF",condition);	
			insertIf(node);
			String parsered="";
			if(node.prevConditions.length()>0) { 
			System.out.println(node.prevConditions+" & "+node.Condition);
			parsered=Parser.parse("( "+node.prevConditions+" & "+node.Condition+" )");
			}
			else {
			System.out.println(node.Condition);
			parsered=Parser.parse(node.Condition);	
			}
			
			FileWriter f=new FileWriter(MainFile.output,true);
			f.write("(assert "+parsered+" )\n");
			f.close();
		}
		else{
			System.out.println("IF Skipped!!");
		}
		
	}
	
	
	
	public static void insertIf(CFGNode n) //inserting the IF node in cfg tree
	{
		
		if(CFGTree.head==null)
			CFGTree.head=n;
		if(CFGTree.nd.isEmpty()) 
		{
			CFGTree.nd.push(n);
			//n.prevConditions="";
			if(CFGTree.tmp==null)
			{
				CFGTree.tmp=n;
			}
			else
			{
				CFGTree.tmp.next=n;
			}
		}
		else
		{	n.prev=CFGTree.nd.peek();
			if(n.prev.prevConditions.length()>0)
			n.prevConditions=n.prev.prevConditions+" & "+n.prev.Condition;
			else
			n.prevConditions=n.prev.Condition;
			//System.out.println(n.prevConditions);
			CFGTree.nd.peek().nested.add(n);
			CFGTree.nd.push(n);
		}
		System.out.println("if node inserted");
	}
	
	
	
}
