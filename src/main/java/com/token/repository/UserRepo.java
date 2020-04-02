package com.token.repository;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.token.model.User;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	@Transactional
	@Query(name = "findByToken", value = "select * from auth_user where token= :token", nativeQuery = true)
	public User findByToken( @Param(value = "token") String token);
	
	@Transactional
	@Query(name = "findByCredentials", value = "select * from auth_user where mobile_number= :mobileNumber and password= :password", nativeQuery = true)
	public User findByCredentials(@Param(value = "mobileNumber") String mobileNumber, @Param(value = "password") String password);
}
