package com.spring_mvc.mybatis2.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_mvc.mybatis2.dao.IBookDAO;
import com.spring_mvc.mybatis2.model.BookVO;

@Service
public class BookService implements IBookService {
	@Autowired
	@Qualifier("IBookDAO")
	IBookDAO dao;
	
	@Override
	public ArrayList<BookVO> listAllBook() {
		return dao.listAllBook();
	}

	@Override
	public void insertBook(BookVO vo) {
		dao.insertBook(vo);
	}

	@Override
	public void updateBook(BookVO vo) {
		dao.updateBook(vo);
	}

	@Override
	public void deleteBook(String bookNo) {
		dao.deleteBook(bookNo);
	}

	@Override
	public BookVO detailViewBook(String bookNo) {
		return dao.detailViewBook(bookNo);
	}

	@Override
	public String bookNoCheck(String bookNo) {
		return dao.bookNoCheck(bookNo);
	}

}
