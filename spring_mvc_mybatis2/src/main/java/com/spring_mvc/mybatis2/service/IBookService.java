package com.spring_mvc.mybatis2.service;

import java.util.ArrayList;

import com.spring_mvc.mybatis2.model.BookVO;

public interface IBookService {
	ArrayList<BookVO> listAllBook(); 	  // 전체 도서 조회
	void insertBook(BookVO vo);      	  // 도서 정보 등록
	void updateBook(BookVO vo);	     	  // 도서 정보 수정
	void deleteBook(String bookNo);	 	  // 도서 정보 삭제
	BookVO detailViewBook(String bookNo); // 도서 상세 조회
}
