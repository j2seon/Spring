package com.fastcampus.ch2;


import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




//PropertyEditor 양방향  
//converter 단방향 이게 더 좋다. 
//Formatter  양방향 @Numberformat(pattern="") @DateTimeFormat(pattern="")
//우선순위 1. 커스텀 2. converter 3.PropertyEditor(디폴트)




@Controller
@RequestMapping("/register")
public class RegisterController {
	
	
	//날짜형식으로 변환해주는 메서드 선언
	@InitBinder //컨트롤러 내에서만 사용가능하다.
	public void toDate(WebDataBinder binder) {
		ConversionService conversionService = binder.getConversionService();
		System.out.println("conversionService="+conversionService);
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false)); //스프링이제공해주는 date에디터 사용
//		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#")); //구분자
		binder.registerCustomEditor(String[].class,"hobby", new StringArrayPropertyEditor("#")); //hobby에만 적용!!!
	//	binder.setValidator(new UserValidator()); // UserValidator를 WebDateBinder에 local validator로 등록
		//binder.addValidators(new UserValidator()); // UserValidator를 WebDateBinder에 local validator로 등록 global이 있을 경우 add로
		List<Validator> validatorList = binder.getValidators();
		System.out.println("validatorList=" + validatorList);
	}
	
	
//	@RequestMapping("/register/add") //신규회원 가입은 get으로 add는 단순히 화면만 보여준다.
		@RequestMapping(value="/add", method={RequestMethod.GET, RequestMethod.POST}) // 신규회원 가입
//		@GetMapping("/register/add") // 4.3부터 추가
		public String register() {
			return "registerForm";  // WEB-INF/views/registerForm.jsp
		}
	
	/*	src > main> webapp > web-inf > Spring > appServlet> servlet-comtext.xml에 해당 문장 추가하면 위의 내용을 적을 필요가 없다.
	 * 
	 * <view-controller path="/register/add" view-name="registerForm"/>
	 * 
	 * 이렇게 추가하면 get 요청으로만!!!
	*/
	
	
	//@RequestMapping(value = "/register/save", method = RequestMethod.POST) //포스트형식으로만 받을 수 있게 설정.
	@PostMapping("/save")
		public String save(@Valid User user, BindingResult result, Model m) throws Exception {
		System.out.println("result = " + result);
		System.out.println("user="+user);
		
		//수동검증 - Validator를 직접 생성하고, validate()를 직접 호출 함
		//UserValidator uservalidator = new  UserValidator();
		//uservalidator.validate(user, result); //BindingResult는 Errors 의 자손이다.
		
		//User 객체를 검증한 결과 에러가 있으면 registerForm을 이용해서 에러를 보여줘야함.
		if(result.hasErrors()) {
			return "registerForm";
		}
		
		
//		//1. 유효성 검사
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id를 잘못입력하셨습니다.", "UTF-8");
//			m.addAttribute("msg" , msg);
//			return "forward:/register/add";
//			//return "redirect:/register/add?msg="+msg;//재작성(rewriting)
//		}
		
		
		
		//2.db에 신규회원 정보를 저장
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return true;
	}
}
