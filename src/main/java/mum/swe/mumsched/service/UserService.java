package mum.swe.mumsched.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mum.swe.mumsched.enums.RoleEnum;
import mum.swe.mumsched.model.User;

public interface UserService {
    User findByUsername(String username);
    
	User save(User user);
	User findOne(Long id);
	void delete(Long id);
	Page<User> findAll(Pageable pageable);
	void setUserPassword(User user);
	List<User> findByRole(RoleEnum role);
}
