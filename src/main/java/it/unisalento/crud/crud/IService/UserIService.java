package it.unisalento.crud.crud.IService;

import it.unisalento.crud.crud.exception.UserNotFoundException;
import it.unisalento.crud.crud.models.User;

import java.util.List;

public interface UserIService{
	List<User> findAll();
	User save(User user);
	void delete(String _id) throws UserNotFoundException;
}
