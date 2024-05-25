package dev.app.expense_tracker.security.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UserRole.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class UserRole_ {

	
	/**
	 * @see dev.app.expense_tracker.security.model.UserRole#authority
	 **/
	public static volatile SingularAttribute<UserRole, String> authority;
	
	/**
	 * @see dev.app.expense_tracker.security.model.UserRole#id
	 **/
	public static volatile SingularAttribute<UserRole, Long> id;
	
	/**
	 * @see dev.app.expense_tracker.security.model.UserRole
	 **/
	public static volatile EntityType<UserRole> class_;

	public static final String AUTHORITY = "authority";
	public static final String ID = "id";

}

