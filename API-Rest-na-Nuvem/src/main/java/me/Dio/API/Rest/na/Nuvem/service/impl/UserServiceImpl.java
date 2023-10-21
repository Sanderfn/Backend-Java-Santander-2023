package me.Dio.API.Rest.na.Nuvem.service.impl;

import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import me.Dio.API.Rest.na.Nuvem.Domain.model.User;
import me.Dio.API.Rest.na.Nuvem.Domain.repository.UserRepository;
import me.Dio.API.Rest.na.Nuvem.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

		public UserServiceImpl(UserRepository userRepository) {
			 this.userRepository = userRepository;
		}
	
	@Override
	public User findByID(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
	}

	@Override
	public User create(User userToCreate) {
		// TODO Auto-generated method stub
		if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
			throw new IllegalArgumentException("This Account number already exists.");
		}
		return userRepository.save(userToCreate);
	}
	
}
