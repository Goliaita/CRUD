package it.unisalento.crud.crud.servicies;

import org.bson.types.ObjectId;
import it.unisalento.crud.crud.IService.UserIService;
import it.unisalento.crud.crud.exception.UserNotFoundException;
import it.unisalento.crud.crud.models.User;
import it.unisalento.crud.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("user-service")
public class UserService implements UserIService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll(){
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	@Override
	public User save(User user){
		return userRepository.save(user);
	}

	@Override
	public void delete(String _id) throws UserNotFoundException {
		User u = userRepository.findBy_id(new ObjectId(_id)).orElseThrow(() -> new UserNotFoundException());
		userRepository.delete(u);
	}

}
