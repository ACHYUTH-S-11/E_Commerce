package com.platform.ecommerce.repository;
import com.platform.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface UserRepository extends JpaRepository<User, Long> {}