package it.unisalento.crud.crud.repository;

import it.unisalento.crud.crud.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("user-repository")
public interface UserRepository extends MongoRepository<User, String> {
	Optional<User> findBy_id(ObjectId id);
}
