package dev.app.expense_tracker.security.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UserAccount.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class UserAccount_ {

	
	/**
	 * @see dev.app.expense_tracker.security.model.UserAccount#password
	 **/
	public static volatile SingularAttribute<UserAccount, String> password;
	
	/**
	 * @see dev.app.expense_tracker.security.model.UserAccount#id
	 **/
	public static volatile SingularAttribute<UserAccount, Long> id;
	
	/**
	 * @see dev.app.expense_tracker.security.model.UserAccount
	 **/
	public static volatile EntityType<UserAccount> class_;
	
	/**
	 * @see dev.app.expense_tracker.security.model.UserAccount#authorities
	 **/
	public static volatile SetAttribute<UserAccount, UserRole> authorities;
	
	/**
	 * @see dev.app.expense_tracker.security.model.UserAccount#username
	 **/
	public static volatile SingularAttribute<UserAccount, String> username;

	public static final String PASSWORD = "password";
	public static final String ID = "id";
	public static final String AUTHORITIES = "authorities";
	public static final String USERNAME = "username";

}

