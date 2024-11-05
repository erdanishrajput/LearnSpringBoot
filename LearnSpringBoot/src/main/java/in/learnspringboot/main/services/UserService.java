package in.learnspringboot.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.learnspringboot.main.Entity.User;
import in.learnspringboot.main.dao.UserDAO;
import in.learnspringboot.main.dto.UserReqDTO;
import in.learnspringboot.main.dto.UserResDTO;
import in.learnspringboot.main.exceptions.UniqueNameAllreadyExist;
import in.learnspringboot.main.exceptions.UniqueNameNotFoundException;
import in.learnspringboot.main.translaters.UserTranslater;
import jakarta.transaction.Transactional;

@Service
public class UserService implements UserServiceInterface {
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserTranslater userTranslater;

	@Override
	public UserResDTO signInUser(UserReqDTO userReqDTO) throws UniqueNameAllreadyExist {

		UserResDTO savedUserDto = userDAO.saveUser(userReqDTO);

		return savedUserDto;
	}

	@Override
	public UserResDTO loginUser(String uniqueName, String password) throws Exception {
		UserResDTO userResDTO = userDAO.loginUser(uniqueName, password);
		return userResDTO;
	}

	public UserResDTO updateUser(String uniqueNameString, UserReqDTO userReqDTO) throws Exception {
		User user = userDAO.findUserByUniqueName(uniqueNameString)
				.orElseThrow(() -> new UniqueNameNotFoundException("User not found..."));

		user.setEmailString(userReqDTO.getEmailString());
		user.setNameString(userReqDTO.getNameString());
		user.setPhoneNoLong(userReqDTO.getPhoneNoLong());

		User updatedUser = userDAO.updateUser(user);
		return userTranslater.userEntityToDto(updatedUser);
	}

	
	@Transactional
	public Integer deleteUser(String uniqueName) throws Exception{
		userDAO.findUserByUniqueName(uniqueName).orElseThrow(()->new UniqueNameNotFoundException("User not found..."));
		Integer deletedUser = userDAO.deleteUser(uniqueName);
		return deletedUser;
	}

}
