package in.learnspringboot.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.learnspringboot.main.dto.CreaterReqDTO;
import in.learnspringboot.main.dto.CreaterResDTO;
import in.learnspringboot.main.services.CreaterService;

@RestController
@RequestMapping("/creater")
public class CreaterController {
	
	@Autowired
	private CreaterService createrService;
	
	@PostMapping("/signIn")
	public ResponseEntity<CreaterResDTO> signIn(@RequestBody CreaterReqDTO createrReqDTO) {
		
		CreaterResDTO createrResData=createrService.signInCreater(createrReqDTO);
		
		return new ResponseEntity<CreaterResDTO>(createrResData, HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<CreaterResDTO> login(@RequestParam String uniqueNameString, @RequestParam String passwordString) throws Exception{
		CreaterResDTO createrResData = createrService.loginCreater(uniqueNameString, passwordString);
		return new ResponseEntity<CreaterResDTO>(createrResData, HttpStatus.OK);
		
	}
	
	@PutMapping("/updateProfile/{uniqueNameString}")
	public ResponseEntity<CreaterResDTO> updateProfile(@PathVariable String uniqueNameString, @RequestBody CreaterReqDTO createrReqDTO) throws Exception {
		
		CreaterResDTO createrResData = createrService.updateCreater(uniqueNameString, createrReqDTO);
		
		return new ResponseEntity<CreaterResDTO>(createrResData, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{uniqueName}")
	public ResponseEntity<Integer> deleteProfile(@PathVariable String uniqueName) throws Exception {
		Integer deleted = createrService.deleteCreater(uniqueName);
		return new ResponseEntity<Integer>(deleted, HttpStatus.OK);
	}
	
	
	
//	not working correctly
	@GetMapping("/search") 
	public ResponseEntity<List<CreaterResDTO>> searchCreater(@RequestParam(required = false) String uniqueName, @RequestParam(required = false) String email, @RequestParam(required = false) String name) throws Exception{

		List<CreaterResDTO> createrResList = createrService.searchCreaterByUniqueName(uniqueName);
		
		return new ResponseEntity<List<CreaterResDTO>>(createrResList, HttpStatus.OK);
		
	}
}
