package it.unisalento.crud.crud.repository;

import it.unisalento.crud.crud.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>{
	public User findBy_id(ObjectId id);
	public User findByFirstNameAndLastName(String firstName, String lastName);
}
