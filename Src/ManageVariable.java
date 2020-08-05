package Functionality;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import MainModule.MainFile;
public class ManageVariable {
	
	// code to manage various kind of variables
	
	public static HashMap<String,String> posvar= new HashMap<String,String>();
	public static HashMap<String,Integer> map = new HashMap<String,Integer>();
	//static String path="C:\\Users\\Mayank\\git\\PEMM\\PEMM\\src\\output.txt";
	public static void mainfunction(String lbl) throws IOException
	{
		
	
		if(lbl.contains("num")||lbl.contains("byte")||lbl.contains("dnum"))
		{
			numVariable(lbl);
		}
		if(lbl.contains("string"))
		{
			stringVariable(lbl);
		}
		if(lbl.contains("bool"))
		{
			boolVariable(lbl);
		}
		if(lbl.contains("pos"))
		{
			posVariable(lbl);
		}
		if(lbl.contains("robtarget"))
		{
			robtargetVariable(lbl);
		}

	}
	
	public static void numVariable(String lbl) throws IOException
	{
		String words[]=lbl.split(":=|;");
		if(lbl.contains(".")) // insert real 
		{
			String word[]=words[0].split(" ");
			String temp="";
			for(int i=2;i<word.length;i++)
			{
				temp=temp+word[i];
			}
			String var[]=temp.split(",");
			FileWriter f=new FileWriter(MainFile.output,true);
			for(int i=0;i<var.length;i++)
			{
				f.write("(declare-const "+var[i]+" Real)\n");
			}
			f.close();
			
		}
		else // insert number
		{
			String word[]=words[0].split(" ");
			String temp="";
			for(int i=2;i<word.length;i++)
			{	
				temp=temp+word[i];
			}
			
			//storing the corresponding values in hash table
			if(words.length > 1){
				System.out.println(words[1]);
				int val = Integer.parseInt(words[1]);
				MainFile.map.put(temp,val);
			}
			
			
			
			//System.out.println(map);
							
			String var[]=temp.split(",| ");
			FileWriter f=new FileWriter(MainFile.output,true);
			for(int i=0;i<var.length;i++)
			{
				f.write("(declare-const "+var[i]+" Int)\n");
			}
			f.close();
		}
		
	}
	public static void stringVariable(String lbl)
	{
		
	}
	
	public static void boolVariable(String lbl) throws IOException
	{
		String words[]=lbl.split(":=|;");
		String word[]=words[0].split(" ");
		String temp="";
		for(int i=2;i<word.length;i++)
		{
			temp=temp+word[i];
		}
		String var[]=temp.split(",| ");
		FileWriter f=new FileWriter(MainFile.output,true);
		for(int i=0;i<var.length;i++)
		{
			f.write("(declare-const "+var[i]+" Bool)\n");
		}
		f.close();
		
	}
	
	public static void posVariable(String lbl) throws IOException
	{
		String words[]=lbl.split(":=|;");
		String word[]=words[0].split(" ");
		String temp="";
		for(int i=2;i<word.length;i++)
		{
			temp=temp+word[i];
		}
		String var[]=temp.split(",| ");
		FileWriter f=new FileWriter(MainFile.output,true);
		for(int i=0;i<var.length;i++)
		{
			f.write("(declare-const "+var[i]+"_x Int)\n");
			f.write("(declare-const "+var[i]+"_y Int)\n");
			f.write("(declare-const "+var[i]+"_z Int)\n");
			posvar.put(var[i]+".x", var[i]+"_x");
			posvar.put(var[i]+".y", var[i]+"_y");
			posvar.put(var[i]+".z", var[i]+"_z");
		}
		f.close();
		
		
		
	}

	public static void robtargetVariable(String lbl) throws IOException
	{ 
		String words[] = lbl.split(":=|;");
		String word[] = words[0].split(" ");
		String temp = "";
		for(int i=2;i<word.length;i++){
			temp = temp + word[i];
		}
		String value[] = words[1].split("");
		//for(int i=1;i<values.length;i++) System.out.print(values[i]);

		String s = "";
		for(int i=2;i<value.length-1;i++)
			s = s + value[i];
		String values[] = s.split("");
		System.out.println(s);
		ArrayList<String> arr = new ArrayList<String>();
		
		//Stack<String> stack = new Stack<String>();
		//stack.push(s[0])
		int flag = 1;
		String s1 = values[0];
		for(int i=1;i<values.length;i++)
		{
			if (values[i].equals("]") && flag == 1){
				//System.out.println("hello");
				s1 = s1 + values[i];
				arr.add(s1);
				s1 = "";
				flag = 0;
			}
			if(values[i].equals("[") && flag == 0){
				s1 = s1 + values[i];
				flag = 1;	
			}
			else{
				if(flag == 1) s1 = s1 + values[i];
			}
			//System.out.println(s1);
		}
		System.out.println(arr.size());
		for(int i=0;i<arr.size();i++){
			if(i==0){
				System.out.println("trans : " + arr.get(i));
			}
			if(i==1){
				System.out.println("rotation : " + arr.get(i));
			}
			if(i==2){
				System.out.println("rob conf : " + arr.get(i));
			}
			if(i==3){
				System.out.println("external axis : " + arr.get(i));
			}
		}
			


		String var[]=temp.split(",| ");
		FileWriter f=new FileWriter(MainFile.output,true);
		for(int i=0;i<var.length;i++)
		{
			f.write("(declare-const "+var[i]+" robtarget)\n");
			System.out.println("(declare-const "+var[i]+" robtarget)\n");
		}
		f.close();

		
	}
	
	
	
}
