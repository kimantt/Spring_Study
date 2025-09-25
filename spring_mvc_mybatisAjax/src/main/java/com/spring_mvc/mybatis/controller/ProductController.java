package com.spring_mvc.mybatis.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_mvc.mybatis.model.ProductVO;
import com.spring_mvc.mybatis.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService service;
	
	//main 페이지
	@RequestMapping("/")
	public String viewIndex() {
		return "index";
	}
	
	// 전체 상품 조회
	@RequestMapping("/product/listAllProduct")
	public String listAllProduct(Model model) {
		// 1. service 메서드 호출
		ArrayList<ProductVO> prdList = service.listAllProduct();
		
		// 2. model에 prdList 저장
		model.addAttribute("prdList", prdList);
		
		// 3. 뷰 반환
		return "product/productListView";
	}
	
	// 상품 등록 폼 요청
	@RequestMapping("/product/newProductForm")
	public String newProductForm() {
		return "product/newProductForm";
	}
	
	// 상품 등록 요청 -> 로직 처리
	@RequestMapping("/product/insertProduct")
	public String insertProduct(ProductVO vo) {
		// insert 기능을 처리할 service method 호출(파라미터로 전달된 입력값을 command 객체에 저장해서 전송)
		service.insertProduct(vo);
		
		// 상품 등록 후에 등록 확인 위해서 전체상품목록을 뷰로 결정 - 전체상품 조회 재요청
		return "redirect:/product/listAllProduct";
	}
	
	// 상품 상세 정보
	@RequestMapping("/product/detailViewProduct/{prdNo}")
	public String detailViewProduct(@PathVariable String prdNo, Model model) {
		// 1. 상품 번호 전송해서 관련 정보 반환
		ProductVO prd = service.detailViewProduct(prdNo);
		
		// 2. 반환 정보 모델에 저장
		model.addAttribute("prd", prd);
		
		// 3. view 페이지 반환
		return "product/productDetailView";
	}
	
	// 상품정보 수정 폼
	@RequestMapping("/product/updateProductForm/{prdNo}")
	public String updateProductForm(@PathVariable String prdNo, Model model) {
		// 1. 상품 번호 전송해서 관련 정보 반환
		ProductVO prd = service.detailViewProduct(prdNo);
		
		// 2. 반환 정보 모델에 저장
		model.addAttribute("prd", prd);
		
		// 3. view 페이지 반환
		return "product/updateProductForm";
	}
	
	// 상품정보 수정 요청 처리
	@RequestMapping("/product/updateProduct")
	public String updateProduct(ProductVO vo, Model model) {
		// 서비스에서 update 메서드 호출
		service.updateProduct(vo);
		
		// 수정 결과 확인하도록 상세페이지 반환
		return "redirect:/product/detailViewProduct/" + vo.getPrdNo();
	}
	
	// 상품정보 삭제 처리
	@RequestMapping("/product/deleteProduct/{prdNo}")
	public String deleteProduct(@PathVariable String prdNo) {
		// 서비스에서 delete 메서드 호출
		service.deleteProduct(prdNo);
		
		// 전체 상품 목록으로 redirect
		return "redirect:/product/listAllProduct";
	}
	
}
