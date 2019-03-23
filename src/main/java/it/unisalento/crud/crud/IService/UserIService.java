package it.unisalento.crud.crud.IService;

import it.unisalento.crud.crud.exception.UserNotFoundException;
import it.unisalento.crud.crud.models.User;

import java.util.List;

public interface UserIService{
	public List<User> findAll();
	public User save(User user);
	public void delete(String _id) throws UserNotFoundException;
}
