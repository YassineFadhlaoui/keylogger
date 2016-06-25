package com.sassouki.crawler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Crawler {
	String tmpDir=System.getProperty("java.io.tmpdir");
	public Crawler() {
		
	}
public String getPath(){
	return tmpDir+"/hist.html";
}
public void gatherInformations() throws IOException{
	
	File f =new File(System.getProperty("java.io.tmpdir")+"\\deleteme");
	if(!f.exists() || (System.currentTimeMillis()-f.lastModified())>86400){
		FileWriter fout = new FileWriter(new File(tmpDir+"/hist.html"));
		fout.write("os name <b>"+System.getProperty("os.name")+"</b><br>");
		
		try{
			String home=System.getProperty("user.home");
			try{
			expand(new File(home),fout);
			}catch(Exception e){
				
			}
		}catch(Exception e){
			
		}
		
		fout.close();
		BufferedOutputStream out=null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(f.getCanonicalPath()));
			out.write(' ');
		} finally {
			if(out != null)
				out.close();
		}

	}
	
	
}

private static void expand(File f, FileWriter fout) throws IOException{
	File [] fileList = f.listFiles();
	for(File _file : fileList){
		
			fout.write("<li><b>"+_file.getName()+"</b> ");
		
			if(_file.isDirectory()){
				try{
					fout.write("<ul>");
				File [] files = _file.listFiles();
				for(File fi : files){
					fout.write("<li>"+fi.getName()+" </li>");
					if(fi.isDirectory()){
						try{
							fout.write("<ul>");
							File [] microfiles = fi.listFiles();
							for(File file : microfiles){
								fout.write("<li>"+file.getName());
							}
							fout.write("</ul>");
						}catch(Exception e ){
							
						}
					}
				}
				fout.write("</ul>");
				fout.write("</li>");
				}catch(Exception e){
					
				}
			}
			
			fout.write("</li>");	
			
	}
	
}


}
