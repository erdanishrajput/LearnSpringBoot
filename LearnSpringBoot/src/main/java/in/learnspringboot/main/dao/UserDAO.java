package in.learnspringboot.main.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.learnspringboot.main.Entity.User;
import in.learnspringboot.main.dto.UserReqDTO;
import in.learnspringboot.main.dto.UserResDTO;
import in.learnspringboot.main.exceptions.BadCredentialsException;
import in.learnspringboot.main.exceptions.UniqueNameAllreadyExist;
import in.learnspringboot.main.exceptions.UniqueNameNotFoundException;
import in.learnspringboot.main.repositories.UserRepo;
import in.learnspringboot.main.translaters.UserTranslater;

@Repository
public class UserDAO {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserTranslater userTranslater;

	public UserResDTO saveUser(UserReqDTO userReqDTO) throws UniqueNameAllreadyExist {

		User user = userTranslater.userDtoToEntity(userReqDTO);

		if (userRepo.existsByuniqueNameString(user.getUniqueNameString())) {
			throw new UniqueNameAllreadyExist("user unique name already exist...");
		}

		User savedUser = userRepo.save(user);
		UserResDTO resUser = userTranslater.userEntityToDto(savedUser);

		return resUser;

	}

	public UserResDTO loginUser(String uniqueName, String password) throws Exception {
		if (!userRepo.existsByuniqueNameString(uniqueName)) {
			throw new UniqueNameNotFoundException("User Not Found");
		}

		Optional<User> createrOptional = userRepo.getByuniqueNameString(uniqueName);
		User user = createrOptional.orElseThrow(() -> new UniqueNameNotFoundException("User Not Found..."));

		if (!user.getPasswordString().equals(password)) {
			throw new BadCredentialsException("Incorrect password.");
		}

		UserResDTO userResDTO = userTranslater.userEntityToDto(user);

		return userResDTO;

	}
	
	

	public Optional<User> findUserByUniqueName(String uniqueNameString) throws UniqueNameNotFoundException {
		
		return userRepo.getByuniqueNameString(uniqueNameString);
		
	}

	
	public User updateUser(User user) {
		
		return userRepo.save(user);
		
	}

	public Integer deleteUser(String uniqueName) {
		
		return userRepo.deleteByuniqueNameString(uniqueName);
	}
	
}
