package it.unisalento.crud.crud.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User{
	@Id
	private ObjectId _id;

	private String firstName;
	private String lastName;

	public User() {}

	public User(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format(
				"User[id=%s, firstName='%s', lastName='%s']",
				_id, firstName, lastName);
	}

	public String get_id() {
		return (_id == null ? null : _id.toHexString());
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getFirstName(){
		return firstName;
	}

	public void setFirstName(String firstName){
		this.firstName = firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public void setLastName(String lastName){
		this.lastName = lastName;
	}
}
