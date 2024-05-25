package dev.app.expense_tracker.user.profile.model;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UserProfile.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class UserProfile_ {

	
	/**
	 * @see dev.app.expense_tracker.user.profile.model.UserProfile#imageLink
	 **/
	public static volatile SingularAttribute<UserProfile, String> imageLink;
	
	/**
	 * @see dev.app.expense_tracker.user.profile.model.UserProfile#name
	 **/
	public static volatile SingularAttribute<UserProfile, String> name;
	
	/**
	 * @see dev.app.expense_tracker.user.profile.model.UserProfile#id
	 **/
	public static volatile SingularAttribute<UserProfile, Long> id;
	
	/**
	 * @see dev.app.expense_tracker.user.profile.model.UserProfile
	 **/
	public static volatile EntityType<UserProfile> class_;

	public static final String IMAGE_LINK = "imageLink";
	public static final String NAME = "name";
	public static final String ID = "id";

}

