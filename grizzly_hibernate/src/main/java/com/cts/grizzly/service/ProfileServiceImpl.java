package com.cts.grizzly.service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzly.bean.Login;
import com.cts.grizzly.bean.Profile;
import com.cts.grizzly.dao.LoginDAO;
import com.cts.grizzly.dao.ProfileDAO;



@Service("profileService")
@Transactional(propagation=Propagation.SUPPORTS)
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	ProfileDAO profileDAO ;

	
	public Profile getUserStatus(String userName) {
		// TODO Auto-generated method stub
		return profileDAO.getUserStatus(userName);
	}


	
	

	
}
