package me.Dio.API.Rest.na.Nuvem.service;

import me.Dio.API.Rest.na.Nuvem.Domain.model.User;


public interface UserService {

	User findByID(Long id);
	
	User create(User usertoCreate);
}
