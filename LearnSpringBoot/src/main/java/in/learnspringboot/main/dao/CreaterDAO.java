package in.learnspringboot.main.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.learnspringboot.main.Entity.Creater;
import in.learnspringboot.main.dto.CreaterReqDTO;
import in.learnspringboot.main.dto.CreaterResDTO;
import in.learnspringboot.main.exceptions.BadCredentialsException;
import in.learnspringboot.main.exceptions.UniqueNameAllreadyExist;
import in.learnspringboot.main.exceptions.UniqueNameNotFoundException;
import in.learnspringboot.main.repositories.CreaterRepo;
import in.learnspringboot.main.translaters.CreaterTranslater;

@Repository
public class CreaterDAO {

	@Autowired
	private CreaterRepo createrRepo;

	@Autowired
	private CreaterTranslater createrTranslater;

//	<----------------------------------------------------------------------------------------------------------------->

	public CreaterResDTO saveCreater(CreaterReqDTO createrReqDTO) throws UniqueNameAllreadyExist {

		Creater creater = createrTranslater.createrDtoToEntity(createrReqDTO);
		if (createrRepo.existsByuniqueNameString(creater.getUniqueNameString())) {
			throw new UniqueNameAllreadyExist("creater unique name already exist...");
		}
		Creater savedCreater = createrRepo.save(creater);
		CreaterResDTO resUser = createrTranslater.createrEntityToDto(savedCreater);

		return resUser;

	}

//	<----------------------------------------------------------------------------------------------------------------->

	public CreaterResDTO loginCreater(String uniqueName, String password) throws Exception {

		if (!createrRepo.existsByuniqueNameString(uniqueName)) {
			throw new UniqueNameNotFoundException("Creater not found...");
		}

		Optional<Creater> createrOptional = createrRepo.getByuniqueNameString(uniqueName);
		Creater creater = createrOptional.orElseThrow(() -> new UniqueNameNotFoundException("Creater not found..."));

		if (!creater.getPasswordString().equals(password)) {
			throw new BadCredentialsException("Incorrect password.");
		}

		CreaterResDTO createrResDTO = createrTranslater.createrEntityToDto(creater);

		return createrResDTO;
	}

//	<----------------------------------------------------------------------------------------------------------------->

	public Optional<Creater> findCreaterByUniqueName(String uniqueNameString) throws UniqueNameNotFoundException {
		
		return createrRepo.getByuniqueNameString(uniqueNameString);
		
	}
//	<----------------------------------------------------------------------------------------------------------------->
	
	public Creater updateCreater(Creater creater) {
		
		return createrRepo.save(creater);
		
	}
	
}
