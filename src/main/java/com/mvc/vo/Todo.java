package com.mvc.vo;
//board 테이블 안의 레코드 1건의 정보를 저장하기 위한 용도

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class Todo {
	
	private String num;
	private String content;
	private String id;
	private String sdate;
	private String edate;
	private String done;	
		
}
