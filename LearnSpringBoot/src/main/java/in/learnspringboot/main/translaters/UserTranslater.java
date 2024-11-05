package in.learnspringboot.main.translaters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.learnspringboot.main.Entity.User;
import in.learnspringboot.main.dto.UserReqDTO;
import in.learnspringboot.main.dto.UserResDTO;

@Component
public class UserTranslater {

	@Autowired
	private ModelMapper modelMapper;

//	this fun map entity to dto in user
	public UserResDTO userEntityToDto(User user) {
		return modelMapper.map(user, UserResDTO.class);
	}

//	this fun map dto to entity in user
	public User userDtoToEntity(UserReqDTO userReqDTO) {
		return modelMapper.map(userReqDTO, User.class);
	}

}
