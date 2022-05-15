package com.fastcampus.ch2_1;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller // ctrl+shift+o �ڵ� import
@RequestMapping("/register")
public class RegisterController {
	
	
	public void toDate(WebDataBinder binder) {
		SimpleDateFormat df = new SimpleDateFormat();
		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
		binder.setValidator(new UserValidator());
		binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
	}
	
	@RequestMapping(value="/add", method={RequestMethod.GET, RequestMethod.POST})
//	@GetMapping("/add")
	public String register() {
		return "registerForm"; // WEB-INF/views/registerForm.jsp
	}
	
//	@RequestMapping(value="/save", method=RequestMethod.POST)
	@PostMapping("/save")  
	public String save(User user, BindingResult result, Model m) throws Exception {
		System.out.println(result);
		System.out.println(user);
		
//		
	UserValidator uservlidator = new UserValidator();
	uservlidator.validate(user, result);
//		
		if(result.hasErrors()) {
			return "registerForm";
		}
			
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}
}
