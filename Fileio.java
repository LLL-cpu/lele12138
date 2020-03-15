package com.lele;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


class Fileio {
	File f1 ; 
	StringBuffer sb = new StringBuffer();
	
	public String start1(String str){
		
		
			
			String s2 = str.replace('\\', '/');
			f1 = new File(s2);
			if(f1.exists()==false){ 
				return "不存在此文件，请注意格式，并重新输入。";
			}
			return "a";
	}
	
	public void outputString() throws IOException {
		FileInputStream fis = new FileInputStream(f1);
		int b;
		while((b = fis.read())!=-1){
			char c = (char)b;
			sb = sb.append(c);
		}
		fis.close();	
	}
}
