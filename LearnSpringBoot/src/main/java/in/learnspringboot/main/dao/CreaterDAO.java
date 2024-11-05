package in.learnspringboot.main.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.learnspringboot.main.Entity.Creater;
import in.learnspringboot.main.dto.CreaterReqDTO;
import in.learnspringboot.main.dto.CreaterResDTO;
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

	public Optional<Creater> loginCreater(String uniqueName, String password) throws Exception {
		return createrRepo.getByuniqueNameString(uniqueName);

	}

//	<----------------------------------------------------------------------------------------------------------------->

	public Optional<Creater> findCreaterByUniqueName(String uniqueNameString) throws UniqueNameNotFoundException {
		
		return createrRepo.getByuniqueNameString(uniqueNameString);
		
	}
//	<----------------------------------------------------------------------------------------------------------------->
	
	public Creater updateCreater(Creater creater) {
		
		return createrRepo.save(creater);
		
	}
	
<<<<<<< HEAD
=======
//	<----------------------------------------------------------------------------------------------------------------->
	
	public Integer deleteCreater(String uniqueName) {
		return createrRepo.deleteByuniqueNameString(uniqueName);
	}
	
////	<----------------------------------------------------------------------------------------------------------------->
//	
//	public List<Creater> searchCreaterByEmail(String email){
//		return createrRepo.findByemailStringContainingIgnoreCase(email);
//	}
	
//	<----------------------------------------------------------------------------------------------------------------->
	
	public List<Creater> searchCreaterByUniqueName(String uniqueName) throws UniqueNameNotFoundException{
		return createrRepo.findByemailStringContainingIgnoreCase(uniqueName);
	}
	
//	<----------------------------------------------------------------------------------------------------------------->
	
//	public List<Creater> searchCreaterByName(String name){
//		return createrRepo.findByemailStringContainingIgnoreCase(name);
//	}

>>>>>>> branch 'danish' of https://github.com/erdanishrajput/LearnSpringBoot.git
}
