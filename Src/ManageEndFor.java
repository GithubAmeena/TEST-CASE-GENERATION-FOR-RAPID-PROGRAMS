package Functionality;

import CFG.CFGTree;

// manage endwhile statements
public class ManageEndFor {

	public static void mainfunction(String lbl)
	{
		while(!CFGTree.nd.peek().ConditionType.equals("FOR"))
		{
			CFGTree.nd.pop();
		}
		if(CFGTree.nd.peek().ConditionType.equals("FOR"))
		{
			CFGTree.tmp=CFGTree.nd.pop();
		}
		System.out.println("node popped");
	}
	

}
