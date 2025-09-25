package com.spring_mvc.mybatis2.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_mvc.mybatis2.model.BookVO;
import com.spring_mvc.mybatis2.service.BookService;

@Controller
public class BookController {
	@Autowired
	BookService service;
	
	//main 페이지
	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}
	
	// 전체 도서 조회
	@RequestMapping("/book/listAllBook")
	public String listAllBook(Model model) {
		// 서비스에 전체 도서 목록 요청 후 반환 받음
		ArrayList<BookVO> bookList = service.listAllBook();
		
		// model에 속성으로 추가
		model.addAttribute("bookList", bookList);
		
		// 도서 목록 view 반환
		return "book/bookListView";
	}
	
	// 도서 등록 폼
	@RequestMapping("/book/newBookForm")
	public String newBookForm() {
		return "book/newBookForm";
	}
	
	// 도서 등록 요청 처리
	@RequestMapping("/book/insertBook")
	public String insertBook(BookVO book) {
		// 서비스를 호출해서 도서 등록 요청
		service.insertBook(book);
		
		// 등록된 도서 확인하기 위해 도서 목록으로 redirect
		return "redirect:/book/listAllBook";
	}
	
	// 도서 상세 정보
	@RequestMapping("/book/detailViewBook/{bookNo}")
	public String detailViewBook(@PathVariable String bookNo, Model model) {
		// 1. 도서번호 전송해서 상세 정보 반환받음
		BookVO book = service.detailViewBook(bookNo);
		
		// 2. 반환 정보 모델에 저장
		model.addAttribute("book", book);
		
		// 3. view 페이지 반환
		return "book/bookDetailView";
	}
	
	// 도서정보 수정 폼
	@RequestMapping("/book/updateBookForm/{bookNo}")
	public String updateBookForm(@PathVariable String bookNo, Model model) {
		// 1. 도서번호 전송해서 상세 정보 반환받음
		BookVO book = service.detailViewBook(bookNo);
		
		// 2. 반환 정보 모델에 저장
		model.addAttribute("book", book);
		
		// 3. view 페이지 반환
		return "book/updateBookForm";
	}
	
	// 도서정보 수정 로직 처리
	@RequestMapping("/book/updateBook")
	public String updateBook(BookVO vo) {
		// 서비스에서 update 메서드 호출
		service.updateBook(vo);
		
		// 수정 결과 확인하도록 상세페이지 반환
		return "redirect:/book/detailViewBook/" + vo.getBookNo();
	}
	
	// 도서정보 삭제 로직 처리
	@RequestMapping("/book/deleteBook/{bookNo}")
	public String deleteBook(@PathVariable String bookNo) {
		// 파라미터로 받은 bookNo를 서비스에 전달해서 삭제 요청
		service.deleteBook(bookNo);
		
		// 삭제 후 전체 도서 목록 view 반환
		return "redirect:/book/listAllBook";
	}
}
