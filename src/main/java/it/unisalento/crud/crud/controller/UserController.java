package it.unisalento.crud.crud.controller;


import it.unisalento.crud.crud.IService.UserIService;
import it.unisalento.crud.crud.exception.CustomErrorType;
import it.unisalento.crud.crud.models.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController @CrossOrigin
public class UserController{

	@Autowired
	private UserIService userIService;


	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAllUser(){
		System.out.println("in ricerca");
		return new ResponseEntity<>(userIService.findAll(), HttpStatus.OK);
	}


	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@Valid @RequestBody User user, BindingResult bindingResult){
		if(!bindingResult.hasErrors()){
			if (user.get_id() == null) {
				user.set_id(ObjectId.get());
			}
			return new ResponseEntity<>(userIService.save(user), HttpStatus.CREATED);
		}else{
			return new ResponseEntity<>(new CustomErrorType("Unable to create user. Bad request"),
					HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") String _id){
		try{
			userIService.delete(_id);
			return new ResponseEntity<>("Deleted", HttpStatus.OK);
		}catch(Exception ex){
			return new ResponseEntity<>(new CustomErrorType("User not Found"), HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateUser(@PathVariable("id") ObjectId _id, @Valid @RequestBody User user,
	                                    BindingResult bindingResult){
		if(!bindingResult.hasErrors()){
			user.set_id(_id);
			return new ResponseEntity<>(userIService.save(user), HttpStatus.OK);
		}else{
			return new ResponseEntity<>(new CustomErrorType("Unable to save"), HttpStatus.BAD_REQUEST);
		}
	}

}
