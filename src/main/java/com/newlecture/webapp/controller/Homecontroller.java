package com.newlecture.webapp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/*")
public class Homecontroller {
	
	@RequestMapping("index")
	public String index() {
		// return "/WEB-INF/views/index.jsp";
		return "home.index";
	}
	
	@RequestMapping("upload")
	@ResponseBody
	public String upload(String title, MultipartFile file, HttpServletRequest request) throws IOException
	{
		System.out.println(title);
		System.out.println(file.getOriginalFilename());
		
		ServletContext ctx = request.getServletContext();	//request�� �����ڿ��� ctx�� ����
		String path = ctx.getRealPath("/resource/upload");	//"resource/upload"�� ���� ������ ��� �ִ��� request�� �����ڿ��� ������θ� ������.
		File f = new File(path);							//��δ� ������ ����ϱ� ���� �غ����- ��������
		
		if(!f.exists()) {//��������
			if(!f.mkdirs())
				System.out.println("���丮�� ������ ���� �����ϴ�.");
		}
		
		path += File.separator + file.getOriginalFilename();//���������� �����ϱ� ���� ���ϰ�ü- File.separator:�ü������ '/'or '\' �ٸ�. �ڵ����� �°� ���� 
		File f2 = new File(path);							
		System.out.println("path : "+path);
		
		InputStream fis = file.getInputStream(); //�б�			
		OutputStream fos = new FileOutputStream(f2);//����
		
		byte[] buf = new byte[1024];
		int size = 0;
		while((size=fis.read(buf))>0)
			fos.write(buf, 0, size);
		fos.close();
		fis.close();	
		return title;
	}

}
