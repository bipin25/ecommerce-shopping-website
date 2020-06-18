package com.onlineshop.utility;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	private static String filePath;

	public static String uploadFile(MultipartFile file, String code, HttpServletRequest request) throws IllegalStateException, IOException {
		// TODO Auto-generated method stub
		filePath=request.getSession().getServletContext().getRealPath("/assets/images/");
		if(!new File(filePath).exists()) {
			new File(filePath).mkdirs();
		}
		File dest = new File(filePath+code+".jpg");
		file.transferTo(dest);
		return dest.getName();
	}
	
	
}
