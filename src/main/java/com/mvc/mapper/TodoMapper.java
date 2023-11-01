package com.mvc.mapper;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.mvc.vo.Todo;


//BoardService를 위한 인터페이스
@Mapper
public interface TodoMapper {
	public List<Todo> selectAll();
	public List<Todo> selectById(String id); //all data
	public Todo selectOne(String num); //num에 해당하는  data 한 건
	public int delete(String num); //num 기준으로 data 삭제
	public int update(String num,String done); //num 기준으로 done을 수정 (N <-> Y) 
	public int insert(HashMap<String, String> map); //새로운 할 일 추가
	public List<Todo> searchByDate(String sdate, String edate);//시작일,종료일 사이 data 검색
	public List<Todo> searchByContent(String content);//content에 내용이 포함된 data 검색
	public int deleteAll();//모든 데이터 삭제
}
