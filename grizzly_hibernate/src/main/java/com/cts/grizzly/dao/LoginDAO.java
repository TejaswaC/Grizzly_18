package com.cts.grizzly.dao;

import com.cts.grizzly.bean.Login;

public interface LoginDAO {

	public Login authenticate(Login login);
}
