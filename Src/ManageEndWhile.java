package Functionality;

import CFG.CFGTree;

// manage endwhile statements
public class ManageEndWhile {

	public static void mainfunction(String lbl)
	{	
		if(!CFGTree.nd.empty()){
			while(!CFGTree.nd.peek().ConditionType.equals("WHILE"))
			{
				CFGTree.nd.pop();
			}
			if(CFGTree.nd.peek().ConditionType.equals("WHILE"))
			{
				CFGTree.tmp=CFGTree.nd.pop();
			}
			System.out.println("node popped");
		}
	}

}
