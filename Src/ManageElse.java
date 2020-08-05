package Functionality;

import CFG.CFGNode;
import CFG.CFGTree;

// manage Else statements
public class ManageElse {
	
	public static void mainfunction(String lbl)
	{
		CFGNode n=new CFGNode("ELSE",""); // negation need to be added here , parent node trace needed for that
		n.prev=CFGTree.nd.peek();
		n.Condition="(!( "+n.prev.Condition+" ))";
		if(n.prev.prevConditions.length()>0)
		n.prevConditions=n.prev.prevConditions;
		//n.Condition=n.Condition+" & ("+n.prev.prevConditions+" )";
		System.out.println("else condition is "+n.Condition);
		CFGTree.nd.peek().fal=n;
		CFGTree.nd.push(n);
		System.out.println("else node inserted");
		
		
		
		
	}
}
