package in.learnspringboot.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.learnspringboot.main.Entity.Blogs;

@Repository
public interface BlogRepo extends JpaRepository<Blogs, Long>{
	

}
