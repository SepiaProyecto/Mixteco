package mx.curso.mixteco.repository;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.curso.mixteco.entity.Role;



@Repository
public interface RoleRepository {//extends CrudRepository<Role, Long>{
	
	public Role findByName(String name);

}
