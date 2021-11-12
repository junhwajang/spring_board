package com.bbs.model;

import lombok.Data;

@Data
public class AttachFileDTO {
	
	private String fileName; //원본 파일 이름
	private String uploadPath; //업로드 경로
	private String uuid; 
	private boolean image; 
}
