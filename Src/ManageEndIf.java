package Functionality;

import CFG.CFGTree;

// manage EndIf statements
public class ManageEndIf {
	
	public static void mainfunction(String lbl)
	{
		while(!CFGTree.nd.peek().ConditionType.equals("IF"))
		{
			CFGTree.nd.pop();
		}
		if(CFGTree.nd.peek().ConditionType.equals("IF"))
		{
			CFGTree.tmp=CFGTree.nd.pop();
		}
		System.out.println("node popped");
	}

}
