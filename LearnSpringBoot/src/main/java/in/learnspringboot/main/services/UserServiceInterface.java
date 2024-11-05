package in.learnspringboot.main.services;

import in.learnspringboot.main.dto.UserReqDTO;
import in.learnspringboot.main.dto.UserResDTO;

public interface UserServiceInterface {
	
	public UserResDTO signInUser(UserReqDTO userReqDTO);

	public UserResDTO loginUser(String uniqueName, String password) throws Exception;
}
