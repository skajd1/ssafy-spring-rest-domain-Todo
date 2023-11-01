package com.mvc.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.service.TodoService;
import com.mvc.vo.Todo;

@RestController
public class TodoController {
	
	private TodoService ts;
	@Autowired
	public TodoController(TodoService ts) {
		this.ts = ts;
	}
	
	@GetMapping(value = "/list")
	public List<Todo> getList() {
		return ts.selectAll();
		
	}
	@GetMapping(value = "/list/id/{id}")
	public List<Todo> selectById(@PathVariable String id){
		return ts.selectById(id);
	}
	@GetMapping(value = "/list/{num}")
	public Todo selectOne(@PathVariable String num) {
		return ts.selectOne(num);
	}
	@DeleteMapping(value = "/list/{num}")
	public HashMap<String,String> delete(@PathVariable String num) {
		HashMap<String,String> map = new HashMap<>();
		int res = ts.delete(num);
		if (res>=1) map.put("msg","삭제 " + res + "건 성공");
		return map;
	}
	@PutMapping(value = "/list/{num}")
	public HashMap<String,String> update(@PathVariable String num) {
		HashMap<String,String> map = new HashMap<>();
		int res = ts.update(num);
		if (res>=1) map.put("msg","변경 " + res + "건 성공");
		return map;
	}
	@PostMapping(value = "/list")
	public HashMap<String,String> insert(@RequestBody Todo todo) {
		HashMap<String,String> map = new HashMap<>();
		int res = ts.insert(todo);
		if (res>=1) map.put("msg","추가 성공");
		return map;
	}
	@GetMapping(value = "/list/date/{sdate}/{edate}")
	public List<Todo> searchByDate(@PathVariable String sdate, @PathVariable String edate){
		return ts.searchByDate(sdate, edate);
	}
	@GetMapping(value = "/list/content/{content}")
	public List<Todo> searchByContent(@PathVariable String content){
		return ts.searchByContent(content);
	}
	@DeleteMapping(value = "/list/all")
	public HashMap<String,String> deleteAll(){
		HashMap<String,String> map = new HashMap<>();
		int res = ts.deleteAll();
		if (res>=1) map.put("msg","삭제 " + res + "건 성공");
		return map;
	}

}
