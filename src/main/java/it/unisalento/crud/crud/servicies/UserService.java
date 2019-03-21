package it.unisalento.crud.crud.servicies;

import it.unisalento.crud.crud.IService.UserIService;
import it.unisalento.crud.crud.models.User;
import it.unisalento.crud.crud.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserIService{

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}

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
	public void delete(String _id){
		userRepository.delete(userRepository.findBy_id(new ObjectId(_id)));
	}

}
