package com.stackroute.keepnote.dao;

import org.hibernate.SessionFactory;
import com.stackroute.keepnote.exception.UserNotFoundException;
import com.stackroute.keepnote.model.User;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * This class is implementing the UserDAO interface. This class has to be annotated with 
 * @Repository annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, 
 * thus clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */
public class UserDaoImpl implements UserDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.(Use
	 * constructor-based autowiring.
	 */
	SessionFactory sessionFactory;

	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Create a new user
	 */

	public boolean registerUser(User user) {
		Integer userId = (Integer) sessionFactory.getCurrentSession().save(user);

		if(userId!=null){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	/*
	 * Update an existing user
	 */

	public boolean updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		return Boolean.TRUE;

	}

	/*
	 * Retrieve details of a specific user
	 */
	public User getUserById(String userId) {
		return sessionFactory.getCurrentSession().get(User.class, userId);
	}

	/*
	 * validate an user
	 */

	public boolean validateUser(String userId, String password) throws UserNotFoundException {
		User user = getUserById(userId);
		if(user==null){
			throw new UserNotFoundException("UserNotFoundException");
		}else{
			if(!password.equals(user.getUserPassword())){
				return Boolean.FALSE;
			}
		}
		return true;

	}

	/*
	 * Remove an existing user
	 */
	public boolean deleteUser(String userId) {
		User user = getUserById(userId);
		if(user!=null){
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}
		return false;

	}

}
