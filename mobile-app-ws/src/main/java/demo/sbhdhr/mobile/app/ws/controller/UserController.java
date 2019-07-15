package demo.sbhdhr.mobile.app.ws.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.sbhdhr.mobile.app.ws.dto.UserDto;
import demo.sbhdhr.mobile.app.ws.model.request.UserDetailRequestModel;
import demo.sbhdhr.mobile.app.ws.model.response.UserRest;
import demo.sbhdhr.mobile.app.ws.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String getUser() {
		String nameofCurrMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nameofCurrMethod + " was called";
	}

	@PostMapping
	public UserRest createUser(@RequestBody UserDetailRequestModel requestUserDetails) {
		UserRest returnValue = new UserRest();

		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(requestUserDetails, userDto);

		UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);

		return returnValue;
	}

	@PutMapping
	public String updateUser() {

		String nameofCurrMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nameofCurrMethod + " was called";
	}

	@DeleteMapping
	public String deleteUser() {

		String nameofCurrMethod = Thread.currentThread().getStackTrace()[1].getMethodName();
		return nameofCurrMethod + " was called";
	}

}
