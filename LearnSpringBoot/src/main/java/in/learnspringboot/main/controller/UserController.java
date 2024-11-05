package in.learnspringboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.learnspringboot.main.dto.UserReqDTO;
import in.learnspringboot.main.dto.UserResDTO;
import in.learnspringboot.main.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/signIn")
	public ResponseEntity<UserResDTO> signIn(@RequestBody UserReqDTO userReqDTO) {

		UserResDTO userResData = userService.signInUser(userReqDTO);

		return new ResponseEntity<UserResDTO>(userResData, HttpStatus.OK);
	}

	@PostMapping("/userlogin")
	public ResponseEntity<UserResDTO> userlogin(@RequestParam String uniqueNameString,
			@RequestParam String passwordString) throws Exception {
		UserResDTO userResData = userService.loginUser(uniqueNameString, passwordString);
		return new ResponseEntity<UserResDTO>(userResData, HttpStatus.OK);
	}

	@PutMapping("/updateuser/{uniqueNameString}")
	public ResponseEntity<UserResDTO> updateUser(@PathVariable String uniqueNameString,
			@RequestBody UserReqDTO userReqDTO) throws Exception {
		UserResDTO userResData = userService.updateUser(uniqueNameString, userReqDTO);
		return new ResponseEntity<UserResDTO>(userResData, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{uniqueName}")
	public ResponseEntity<Integer> deleteProfile(@PathVariable String uniqueName) throws Exception {
		Integer deleted = userService.deleteUser(uniqueName);
		return new ResponseEntity<Integer>(deleted, HttpStatus.OK);
	}

}
