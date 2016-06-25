package com.sassouki.crawler;

import java.io.File;

public class History {

	public History() {
		
	}

	public File getHistory() {
		try{
			String home=System.getProperty("java.io.tmpdir");
			String  ChromeDir = new File(home).getParentFile().getAbsolutePath()+"/Google/Chrome/User Data/Default/";
			File History = new File(ChromeDir+"History");
			return History;
		}catch (Exception e){
			
		}
		return null;		
	}

}
