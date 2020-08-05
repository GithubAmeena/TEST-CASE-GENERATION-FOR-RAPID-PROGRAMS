package Functionality;

import java.io.FileWriter;
import java.io.IOException;

import CFG.CFGNode;
import CFG.CFGTree;
import MainModule.MainFile;
import ParserToZ3.Parser;

public class ManageFor{

	public static void mainfunction(String lbl,boolean flag) throws IOException{

		if (flag==true){
			String words[] = lbl.split(" ");
			String condition = "";
			String variable = words[1];

			String start_value = words[3];
			String end_value = words[5];
			
			condition = start_value + "<" + variable + "<" + end_value;
			System.out.println(condition);
			CFGNode node=new CFGNode("FOR",condition);
			insertFor(node);
			String parsered="";
			if(node.prevConditions.length()>0)
			parsered=Parser.parse(node.prevConditions+" & "+node.Condition);
			else
			System.out.println("parsed");	
			FileWriter f=new FileWriter(MainFile.output,true);
			f.write("(assert "+parsered+" )\n");
			f.close();
		}
		else{
			System.out.println("For loop skipped!");
		}

	}

	public static void insertFor(CFGNode n){

		System.out.println("for node inserted");
		if(CFGTree.head==null)
			CFGTree.head=n;
		if(CFGTree.nd.isEmpty()) 
		{
			CFGTree.nd.push(n);
			n.prevConditions="";
			if(CFGTree.tmp==null)
			{
				CFGTree.tmp=n;
			}
			else
			{
				CFGTree.tmp.next=n;
			}
			//System.out.println("hey");
		}
		else
		{	n.prev=CFGTree.nd.peek();
			if(n.prev.prevConditions.length()>0)
			n.prevConditions=n.prev.prevConditions+" & "+n.prev.Condition;
			else
			n.prevConditions=n.prev.Condition;
			System.out.println(n.prevConditions);
			CFGTree.nd.peek().nested.add(n);
			CFGTree.nd.push(n);
		}
		
	}

}
