package me.Dio.API.Rest.na.Nuvem.Domain.repository;


import me.Dio.API.Rest.na.Nuvem.Domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	boolean existsByAccountNumber(String accountNumber);

}
