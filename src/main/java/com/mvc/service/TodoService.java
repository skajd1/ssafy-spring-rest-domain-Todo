package com.mvc.service;
import java.util.List;
import com.mvc.vo.Todo;
public interface TodoService {
		public List<Todo> selectAll();
		public List<Todo> selectById(String id); //all data
		public Todo selectOne(String num); //num에 해당하는  data 한 건
		public int delete(String num); //num 기준으로 data 삭제
		public int update(String num); //num 기준으로 done을 수정 (N <-> Y) 
		public int insert(Todo todo); //새로운 할 일 추가
		public List<Todo> searchByDate(String sdate, String edate);//시작일,종료일 사이 data 검색
		public List<Todo> searchByContent(String content);//content에 내용이 포함된 data 검색
		public int deleteAll();//모든 데이터 삭제
}


