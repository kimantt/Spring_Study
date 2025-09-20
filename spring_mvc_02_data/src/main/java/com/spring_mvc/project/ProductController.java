package com.spring_mvc.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	@RequestMapping("product/productForm")
	public String productFormView() {
		return "product/productForm";
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
	
}
