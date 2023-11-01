package com.mvc.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.mapper.TodoMapper;
import com.mvc.vo.Todo;

@Service
public class TodoServiceImpl implements TodoService {
	
	private TodoMapper m;
	
	@Autowired
	public TodoServiceImpl(TodoMapper m) {
		this.m = m;
	}
	@Override
	public List<Todo> selectAll() {
		return m.selectAll();
	}

	@Override
	public List<Todo> selectById(String id) {
		return m.selectById(id);
	}

	@Override
	public Todo selectOne(String num) {
		return m.selectOne(num);
	}

	@Override
	public int delete(String num) {
		return m.delete(num);
	}

	@Override
	public int update(String num) {
		String done = m.selectOne(num).getDone();
		return m.update(num,done);
	}

	@Override
	public int insert(Todo todo) {
		HashMap<String,String> map = new HashMap<>();
		map.put("content", todo.getContent());
		map.put("id", todo.getId());
		map.put("edate", todo.getEdate());
		return m.insert(map);
		
	}

	@Override
	public List<Todo> searchByDate(String sdate, String edate) {
		return m.searchByDate(sdate, edate);
	}

	@Override
	public List<Todo> searchByContent(String content) {
		return m.searchByContent(content);
	}

	@Override
	public int deleteAll() {
		return m.deleteAll();
	}

}
