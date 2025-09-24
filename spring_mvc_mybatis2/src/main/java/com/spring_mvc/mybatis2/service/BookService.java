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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBook(BookVO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(String bookNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BookVO detailViewBook(String bookNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
