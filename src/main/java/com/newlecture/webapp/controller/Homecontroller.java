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
		
		ServletContext ctx = request.getServletContext();	//request의 공유자원을 ctx에 넣음
		String path = ctx.getRealPath("/resource/upload");	//"resource/upload"의 실제 폴더가 어디에 있는지 request의 공유자원중 실제경로를 가져옴.
		File f = new File(path);							//경로는 파일을 등록하기 위한 준비사항- 폴더생성
		
		if(!f.exists()) {//폴더생성
			if(!f.mkdirs())
				System.out.println("디렉토리를 생성할 수가 없습니다.");
		}
		
		path += File.separator + file.getOriginalFilename();//실제파일을 저장하기 위한 파일객체- File.separator:운영체제마다 '/'or '\' 다름. 자동으로 맞게 설정 
		File f2 = new File(path);							
		System.out.println("path : "+path);
		
		InputStream fis = file.getInputStream(); //읽기			
		OutputStream fos = new FileOutputStream(f2);//쓰기
		
		byte[] buf = new byte[1024];
		int size = 0;
		while((size=fis.read(buf))>0)
			fos.write(buf, 0, size);
		fos.close();
		fis.close();	
		return title;
	}

}
