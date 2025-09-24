package com.spring_mvc.project;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

	@RequestMapping("/student/studentForm")
	public String studentFormView() {
		return "student/studentForm";
	}
	
	@RequestMapping("/student/studentForm2")
	public String studentFormView2() {
		return "student/studentForm2";
	}
	
	@RequestMapping("/student/studentForm3")
	public String studentFormView3() {
		return "student/studentForm3";
	}
	
	@RequestMapping("/student/studentForm4")
	public String studentFormView4() {
		return "student/studentForm4";
	}
	
	@RequestMapping("/student/studentForm5")
	public String studentFormView5() {
		return "student/studentForm5";
	}
	
	@RequestMapping("/student/studentSearchForm")
	public String studentSearchForm() {
		return "student/studentSearchForm";
	}
	
	// 클라이언트로부터 전송된 폼데이터를 받는 방식
	// 1. request 객체 사용 : 메서드 파라미터로 정의
	@RequestMapping("/student/newStudent")
	public String insertStudent(HttpServletRequest request, Model model) {
		// 클라이언트 -> 컨트롤러
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String year = request.getParameter("year");
		
		// 컨트롤러 -> view
		model.addAttribute("no", no);
		model.addAttribute("name", name);
		model.addAttribute("year", year);
		
		return "student/studentResult";
	}
	
	// 2. RequestParam 사용
	@RequestMapping("/student/newStudent2")
	public String insertStudent2(@RequestParam("no") String no,
								@RequestParam("name") String name,
								@RequestParam("year") String year,
								Model model) {
		
		// 컨트롤러 -> view
		model.addAttribute("no", no);
		model.addAttribute("name", name);
		model.addAttribute("year", year);
		
		return "student/studentResult";
	}
	
	// 3. command 객체 활용
	@RequestMapping("/student/newStudent3")
	public String insertStudent3(Student student) { // 폼 태그 통해 전달된 데이터가 객체로 자동 주입 -> model 객체에도 자동 저장
		System.out.println(student.getNo());
		System.out.println(student.getName());
		System.out.println(student.getYear());
		
		// view에서 사용하는 필드명과 객체의 필드명이 같기 때문에 모듈이 매칭시킴
		// 전달되는 필드명이 다르면 매칭되지 않아 값 사용 불가능
		
		return "student/studentResult2";
	}
	
	// view로 전달되는 command 객체명 변경 어노테이션 @ModelAttribute
	@RequestMapping("student/newStudent4")
	public String insertStudent4(@ModelAttribute("studentInfo")Student student) {
		return "student/studentResult3";
	}
	
	// Date 타입의 필드 전달
	@RequestMapping("student/newStudent5")
	public String insertStudent5(Student student) {
		return "student/studentResult4";
	}
	
	// uri 구성 시 {변수명} -> 변수명이 파라미터처럼 사용되어짐. stdNo 위치의 문자열은 전송 value로 사용가능
	@RequestMapping("student/studentDetailView/{no}")
	public String studentDetailView(@PathVariable String no) { // url로 전달된 값을 사용 : @PathVariable 어노테이션 사용
		return "student/studentResult";
	}
	
	@RequestMapping("student/studentDetailView/{no}/{name}/{year}")
	public String studentDetailView1(@PathVariable String no,
									 @PathVariable String name,
									 @PathVariable String year
									 ) { // url로 전달된 값을 사용 : @PathVariable 어노테이션 사용
		return "student/studentResult";
	}
	
	// select 태그의 type 파라미터와 input 태그의 keyword 파라미터가 전달됨
	// 하나의 객체에 주입
	@RequestMapping("student/studentSearch")
	public String studentSearch(@RequestParam HashMap<String, Object> param, Model model) {
		// param 참조변수를 통해 전달된 파라미터 출력
		System.out.println(param.get("type"));
		System.out.println(param.get("keyword"));
		
		// 서비스 통해서 dbms 연결 후 keyword를 통한 select 진행 후 결과 반환받는 코드
		
		// name 홍길동으로 검색한 결과가 2명 존재한다고 가정
		Student student = new Student();
        student.setName("홍길동");
        student.setYear(1);
        student.setNo("2024001");

        Student student2 = new Student();
        student2.setName("홍길동");
        student2.setYear(3);
        student2.setNo("2022005");
        
        // ArrayList 사용해서 검색결과 저장
        ArrayList<Student> stdList = new ArrayList<Student>();
        stdList.add(student);
        stdList.add(student2);
        
        // Model 객체에 Collection 저장 후 view로 전달
        model.addAttribute("stdList", stdList);
        
		return "student/studentSearchResult";
	}
	
}
