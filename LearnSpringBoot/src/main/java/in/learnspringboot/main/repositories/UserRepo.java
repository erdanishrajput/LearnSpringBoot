package in.learnspringboot.main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.learnspringboot.main.Entity.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
	public boolean existsByuniqueNameString(String uniqueName);

	public Optional<User> getByuniqueNameString(String uniqueName);
	
	public Integer deleteByuniqueNameString(String uniqueName);
}
