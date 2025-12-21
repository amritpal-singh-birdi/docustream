package com.aps.docustream.validators;

import org.springframework.web.multipart.MultipartFile;

import com.aps.docustream.entities.enums.FileType;

public class FileTypeDetector {

	public static FileType detectFileType(MultipartFile file) {
	
		String contentType = file.getContentType();
		String fileName = file.getOriginalFilename();
		
		if(contentType == null) {
			return FileType.UNKNOWN;
		}else if (contentType.contains("xml") || fileName.endsWith(".xml")){
			return FileType.XML;
		}else if (contentType.contains("json") || fileName.endsWith(".json")){
			return FileType.JSON;
		}else {
			return FileType.UNKNOWN;
		}
		
		
	}
}
