package com.spring_mvc.project;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	@RequestMapping("product/productForm")
	public String productFormView() {
		return "product/productForm";
	}
	
	@RequestMapping("product/productForm3")
	public String productFormView3() {
		return "product/productForm3";
	}
	
	@RequestMapping("product/productForm4")
	public String productFormView4() {
		return "product/productForm4";
	}
	
	@RequestMapping("product/productSearchForm")
	public String productSearchForm() {
		return "product/productSearchForm";
	}
	
	@RequestMapping("product/newProduct")
	public ModelAndView insertProduct(ModelAndView mv,
									  @RequestParam("prdNo") String no,
									  @RequestParam("prdName") String name,
									  @RequestParam("prdPrice") String price,
									  @RequestParam("prdCompany") String company,
									  @RequestParam("prdDate") String date,
									  @RequestParam("prdStock") String stock
									  ) {
		mv.addObject("no", no);
		mv.addObject("name", name);
		mv.addObject("price", price);
		mv.addObject("company", company);
		mv.addObject("date", date);
		mv.addObject("stock", stock);
		mv.setViewName("product/productResult");
		return mv;
	}
	
	@RequestMapping("product/newProduct3")
	public String insertProduct3(Product product) {
		return "product/productResult3";
	}
	
	@RequestMapping("product/newProduct4")
	public String insertProduct4(@ModelAttribute("prd")Product product) {
		return "product/productResult4";
	}
	
	@RequestMapping("product/productDetail1/{name}")
	public String productDetail1(@PathVariable String name) {
		System.out.println("상품명 : " + name);
		return "product/productResult";
	}
	
	@RequestMapping("product/productDetail1/{no}/{name}/{stock}")
	public String productDetail2(@PathVariable String no,
								 @PathVariable String name,
								 @PathVariable String stock) {
		System.out.println("상품번호 : " + no);
		System.out.println("상품명 : " + name);
		System.out.println("재고수량 : " + stock);
		return "product/productResult";
	}
	
	@RequestMapping("product/productSearch")
	public String productSearch(@RequestParam HashMap<String, Object> param, Model model) {
		System.out.println(param.get("type"));
		System.out.println(param.get("keyword"));
		
		// 검색 결과 가정
		Product product = new Product();
		product.setNo("1");
		product.setName("선풍기");
		product.setPrice(20000);
		product.setCompany("삼성");
		
		Product product2 = new Product();
		product2.setNo("2");
		product2.setName("TV");
		product2.setPrice(2000000);
		product2.setCompany("삼성");
        
        // ArrayList 사용해서 검색결과 저장
        ArrayList<Product> prdList = new ArrayList<Product>();
        prdList.add(product);
        prdList.add(product2);
        
        // Model 객체에 Collection 저장 후 view로 전달
        model.addAttribute("prdList", prdList);
        
		return "product/productSearchResult";
	}
	
}
