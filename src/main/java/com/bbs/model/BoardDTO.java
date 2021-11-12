package com.bbs.model;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data //data 어노테이션은 get,set,tostring 메서드 모두 가져올 수 있음
public class BoardDTO {
	
	private Long bno;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private Timestamp bregdate;
		
}
