package com.bs.spring.demo.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.bs.spring.demo.model.dto.Address;
import com.bs.spring.demo.model.dto.Demo;
import com.bs.spring.demo.service.DemoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class DemoController {

	// Web에서 Controller 객체는 Client 의 요청을 받아 서비스를 진행
	// Domain => URL 주소 
	// 서비스를 한 개의 메소드로 처리 -> URL 주소와 연결하기 위해서 @RequestMapping을 사용
	// @RequestMapping("URL매핑주소") -> URL 주소와 연결
	
	// @Controller 메소드를 선언하는 방법
	// Request 주소와 매핑하기 위해서 어노테이션을 선언
	/* 
	 * @RequestMapping("주소") : 요청 Method - GET/POST 모두
	 * 아래는 Rest 방식으로 서비스를 구현했을 때 사용 
	 * @GetMapping("주소") : 요청 방식이 GET일때 매핑 -> GET 방식일때만 실행
	 * @PostMapping("주소") : 요청 방식이 POST일때 매핑 -> POST 방식일때만 실행
	 * @PutMapping("주소") : 요청 방식이 PUT일때 매핑 -> PUT 방식일때만 실행
	 * @DeleteMapping("주소") : 요청 방식이 DELETE일때 매핑 -> DELETE 방식일때만 실행
	 * ---------- 메소드 방식이 일치하지 않으면 에러를 발생시킴 : 에러페이지 이동 ! -------------
 	 * GET 조회 POST 저장 PUT ?? DELETE ??  
 	 * 
 	 * 
	 */
	
	/*
	 * 메소드 선언방법
	 * 반환형 메소드명([매개변수,...])
	 * 1. 반환형
	 * 	1) String : InternalResorceViewResolver클래스를 이용해서 내부에서 jsp 파일을 선택할 때
	 * 				prefix value + 반환값 + suffix value 파일을 찾음
	 * 	2) void : URL 매핑주소가 view 이름과 같을 때 사용, 직접 HttpServletResponse 객체를 이용해서 응답해줄 때
	 * 	3) ModelAndView : Model 객체와 view 를 한번에 저장하는 객체로, jsp 에 보낼 데이터와 view 이름을 저장해서 반환
	 * 	4) ViewResolver 구현한 클래스 : 구현된 클래스의 객체를 반환 -> 라이브러리
	 * 	5) 일반 클래스타입 : Data를 json방식으로 응답할 때 -> converter를 등록 ! 
	 * 	
	 * 	@ResponseBody 어노테이션 추가(반환형 앞 또는 메소드 위에 선언) -> Rest방식으로 data 응답
	 * 	
	 * 2. 매개변수 -> Spring이 알아서 줌 ~ .
	 * 	1) HttpServletRequest : 서블릿 request
	 * 	2) HttpServletResponse : 서블릿 response
	 *	3) HttpSession : 서블릿 session	 
	 * 	4) java.uril.Locale : 서버의 Locale 정보를 저장하는 객체(지역설정)
	 * 	5) InputStream/Reader : 클라이언트와 연결된 stream (받는 것)	
	 * 	6) OutputStream/Writer : 클라이언트와 연결된 stream (보내는 것)
	 * 	7) 기본자료형 변수(String 포함) : 클라이언트가 보낸 parameter 데이터를 저장할 변수 -> 자동대입
	 *  	- parameter key 값과 변수명이 일치
	 *  	- @RequestParam 어노테이션으로 연결  
	 * 	8) DTO(클래스타입)-command 객체 : spring이 만들어서 데이터 저장한 후 전달해줌 ! 
	 * 		- 필드명과 parameter key 값이 같아야 함
	 * 	9) java.util.Map : parameter를 Map방식으로 전달
	 * 	10) @RequestHeader(key) String 변수선언 : Header 정보가져오기
	 * 	11) @CookieValue("key") String 변수선언 : Cookie 정보가져오기
	 * 	12) Model : spring에서 사용하는 jsp에 데이터를 전달할 때 사용하는 객체(Servlet 에서의 Request,Session,Context 중 request와 같음 !!)
	 * 		ModelAndView : Model 과 View를 한 번에 저장하는 객체
	 * 
	 * 	매핑메소드에 사용하는 추가 어노테이션
	 * 	@RequestBody : request body의 데이터가 json일 때 -> 지정된 자바 클래스로 convert(변환)
	 *	@ResponseBody : response body에 자바클래스를 json으로 convert해서 넘김
	 * 	@ModelAttribute : model 데이터 관리하는 속성 -> hibernate validator 이용 시 사용
	 * 	@SessionAttributes : Model에 저장된 데이터를 Session으로 설정 
	 */ 
	
	// 메소드명 : 개발자 마음대로 규칙에 맞춰서 설정함 
	
//	@RequestMapping("/demo/demo.do")
//	public String demo() {
//		// 화면전환용 메소드
//		return "demo/demo"; // RequestDispatcher.forward 랑 동일함 
//	}
	
	@RequestMapping("/demo/demo.do")
	public void demo() {}
	
	
	// 서블릿처럼 이용하기
	@RequestMapping("/demo/demo1.do")
	public void demo1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request);
		System.out.println(response);
		
		// 클라이언트가 보낸 데이터 받아오기
		String devName = request.getParameter("devName");
		int devAge = Integer.parseInt(request.getParameter("devAge"));
		String devGender = request.getParameter("devGender");
		String devEmail = request.getParameter("devEmail");
		String[] devLang = request.getParameterValues("devLang");
		
		Demo d = Demo.builder()
				.devName(devName)
				.devAge(devAge)
				.devGender(devGender)
				.devEmail(devEmail)
				.devLang(devLang).build();
		
		System.out.println(d);
		
		request.setAttribute("demo", d);
		
		request.getRequestDispatcher("/WEB-INF/views/demo/demoResult.jsp").forward(request, response);
	}
	
	// 전달된 파라미터 1:1로 매핑해서 가져오기
	@RequestMapping("/demo/demo2.do")
	public String demo2(String devName, int devAge, String devGender, String devEmail, String[] devLang, Model m) {
		
		System.out.println(devName + devAge + devGender + devEmail + Arrays.toString(devLang));
		Demo d = Demo.builder()
				.devName(devName)
				.devAge(devAge)
				.devGender(devGender)
				.devEmail(devEmail)
				.devLang(devLang).build();
		// 데이터는 Model 클래스에 저장함
		// 데이터를 key:value 구조로 저장
		m.addAttribute("demo", d);
		
		return "demo/demoResult";
	}
	
	// @RequestParam을 이용해서 매개변수 선언하기
	// 속성값을 설정할 수 있음 
	// value, defaultValue, required
	@RequestMapping("/demo/demo3.do")
	public String demo3(
			@RequestParam(value="devName") String name,
			@RequestParam(value="devAge", defaultValue="10") int age,
			@RequestParam(value="devEmail") String email,
			@RequestParam(value="devGender", required=false) String gender,
			@RequestParam(value="devLang", required=true) String[] lang,
			Model m) {
		
		Demo d = Demo.builder()
				.devName(name)
				.devAge(age)
				.devEmail(email)
				.devGender(gender)
				.devLang(lang)
				.build();
		
		m.addAttribute("demo", d);
		
		return "demo/demoResult";
	}
	
	// DTO를 파라미터로 선언하기
	@RequestMapping("/demo/demo4.do")
	public String demo4(@ModelAttribute Demo d, Address address) {
			//Model m) {
		d.setAddress(address);
//		m.addAttribute("d", d);
//		System.out.println(d);
		return "demo/demoResult";
	}
	
	// Map 으로 클라이언트가 보낸 데이터 받기
	@RequestMapping("/demo/demo5.do")
	public String demo5(@RequestParam Map param, String[] devLang, Model m) {
		System.out.println(param);
		param.put("devLang", devLang);
		m.addAttribute("demo", param);
		
		return "demo/demoResult";
	}
	
	// 추가 데이터 전달받아 처리하기
	// RequestHeader 의 값, Cookie 값, Session에 저장된 값
	
	@RequestMapping("/demo/extra.do")
	public String extraData(
			@RequestHeader(value="User-agent") String userAgent,
			@CookieValue(value="cookieData", required=false) String cookieData,
			//HttpSession session
			@SessionAttribute(value="sessionId") String sessionId) {
		
		System.out.println("userAgent :" + userAgent);
		System.out.println("cookieData :" + cookieData);
		System.out.println("sessionId :" + sessionId);
		
		return "index";
	}
	
	// ModelAndView 객체 활용하기
	@RequestMapping("/demo/demo6.do")
	public ModelAndView modelViewTest(Demo d, ModelAndView mv) {
		// 객체 저장하기
		mv.addObject("demo", d);
		// 화면 이름 설정하기
		mv.setViewName("demo/demoResult");
		
		Map<String, Object> data = mv.getModel(); // 데이터 가져올 때 사용할 수 있는 메소드
		System.out.println(data);
		Demo de  = (Demo)data.get("demo");
		System.out.println(de);
		
		String viewName = mv.getViewName();
		System.out.println(viewName);
		
		return mv;
	}
	
	// 값을 반환하기1(스트링)
	@RequestMapping("/demo/demo7.do")
	@ResponseBody
	// responsebody 선언해주면 ~ viewresolver와 연결하지 않고 데이터를 반환해줌 ! 
	public String dataReturn() {
		return "yoo, 김, lee";
	}
	// 값을 반환하기2(객체) -> REST 서비스를 구현할 때 많이 사용
	// 반환하는 값이 객체일 때는 classpath에 converter(Gson, Jackson)가 있어야 함
	// Gson 은 has a 관계에 있는 객체에 대해서는 파싱을 못해주는데, Jackson은 해준다 ! 구래서 잭슨이 더 좋음 ! 
	// pom.xml 에 해당 컨버터 넣어주기 만 하면 됨 ~ dependency 넣어주기 ~  ~ 
	@RequestMapping("/demo/demo72.do")
	// responsebody 선언해주면 ~ viewresolver와 연결하지 않고 데이터를 반환해줌 ! 
	public @ResponseBody Demo dataReturn2() {
		return Demo.builder().devName("yoo").build();
	}
	
	// 메소드 별로 요청을 처리하는 요청메소드 선언하기1
	// @RequestMapping("/demo/test") -> GET / POST 
	@RequestMapping(value="/demo/demo8.do", method= RequestMethod.POST)
	// RequestMethod 라는 Enum타입으로 메소드들을 설정해놈 ! 
	public String postRequest(Demo d, Model m) {
		m.addAttribute("demo", d);
		return "demo/demoResult";
	}
	
	// 메소드 별로 요청을 처리하는 요청메소드 선언하기2
	// @RequestMapping("/demo/test") -> GET / POST 
	@PostMapping("/demo/demo82.do") 
	public String postRequest2(Demo d, Model m) {
		m.addAttribute("demo", d);
		return "demo/demoResult";
	}
	
	// 메소드 별로 요청을 처리하는 요청메소드 선언하기3
	// @RequestMapping("/demo/test") -> GET / POST 
	@GetMapping("/demo/demo83.do") 
	public String postRequest3(Demo d, Model m) {
		m.addAttribute("demo", d);
		return "demo/demoResult";
	}
	
	// 주소 동적으로 매핑하기
	// @PathVariable -> 동적으로 변경되는 주소값을 가져오는 기능 ! 
	@GetMapping("/demo/{no}")
	public String searchDemo(@PathVariable String no) {
		System.out.println(no);
		return "demo/demo";
	}
	
	// 이거 모르갯어용 ! 
	// 요청내용 리다이렉트 시키기 ! 
	// "redirect : 주소(jsp파일명 X -> mapping 주소)";
	@GetMapping("/demo/demo9.do")
	public String sendRedirect() {
		return "redirect:/";
	}
	
	private final DemoService service;
	
	// Post Redirect Get 방식
	@PostMapping("/demo/insertdemo.do")
	public String insertDemo(Demo d) {
		service.insertDemo(d);
		return "redirect:/demo/demo.do";
	}
	
	@GetMapping("/demo/demolist.do")
	public String selectDemoList(@RequestParam(defaultValue="1") int cPage, 
								 @RequestParam(defaultValue="10") int numPerpage, 
								 Model m) {

		List<Demo> result =service.selectDemoList(Map.of("cPage",cPage,"numPerpage",numPerpage));
		m.addAttribute("demo", result);
		
		
		return "demo/demoList";
	}
	
}
