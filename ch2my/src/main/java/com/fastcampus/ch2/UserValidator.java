package com.fastcampus.ch2;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) { //어떤 클래스의 객체가 넘어오는데
		//return User.class.equals(clazz); //그게 User과 같으면 그객체는 User 타입인것이다
		return User.class.isAssignableFrom(clazz); //clazz가 User 또는 그 자손인지 확인.
	}

	@Override
	public void validate(Object target, Errors errors) {// target이 User 객체가 넘어와야하니까 형변환 필요
		System.out.println("UserValidator.validate() is called");
		
//		if(!target instanceof User) return; >> supports 에서 이미한번 검증과정을 거쳤기 때문에 하지 않아도된다.
		User user = (User)target;
		
		String id = user.getId();
		
//		if(id==null || "".equals(id.trim())) { //null 이거나 비었을때 
//			errors.rejectValue("id", "required");
//		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id",  "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");
//		
		if(id==null || id.length() <  5 || id.length() > 12) {
			errors.rejectValue("id", "invalidLength");
		}
	}
}