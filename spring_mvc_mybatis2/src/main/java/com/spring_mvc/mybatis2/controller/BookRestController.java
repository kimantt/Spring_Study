package com.spring_mvc.mybatis2.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring_mvc.mybatis2.model.BookVO;
import com.spring_mvc.mybatis2.service.BookService;

@RestController
public class BookRestController {
	@Autowired
	BookService service;
	
	// 도서 검색 처리
	@RequestMapping("/book/bookSearch")
	public ArrayList<BookVO> bookSearch(@RequestParam HashMap<String, Object> param) {
		ArrayList<BookVO> bookList = service.bookSearch(param);
		return bookList;
	}
}
