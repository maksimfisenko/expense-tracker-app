package dev.app.expense_tracker.user.category.model;

import dev.app.expense_tracker.user.profile.model.UserProfile;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.Instant;

@StaticMetamodel(Category.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Category_ {

	
	/**
	 * @see dev.app.expense_tracker.user.category.model.Category#createdTimestamp
	 **/
	public static volatile SingularAttribute<Category, Instant> createdTimestamp;
	
	/**
	 * @see dev.app.expense_tracker.user.category.model.Category#name
	 **/
	public static volatile SingularAttribute<Category, String> name;
	
	/**
	 * @see dev.app.expense_tracker.user.category.model.Category#hex
	 **/
	public static volatile SingularAttribute<Category, String> hex;
	
	/**
	 * @see dev.app.expense_tracker.user.category.model.Category#currency
	 **/
	public static volatile SingularAttribute<Category, String> currency;
	
	/**
	 * @see dev.app.expense_tracker.user.category.model.Category#id
	 **/
	public static volatile SingularAttribute<Category, Long> id;
	
	/**
	 * @see dev.app.expense_tracker.user.category.model.Category#type
	 **/
	public static volatile SingularAttribute<Category, CategoryType> type;
	
	/**
	 * @see dev.app.expense_tracker.user.category.model.Category
	 **/
	public static volatile EntityType<Category> class_;
	
	/**
	 * @see dev.app.expense_tracker.user.category.model.Category#lastModifiedTimestamp
	 **/
	public static volatile SingularAttribute<Category, Instant> lastModifiedTimestamp;
	
	/**
	 * @see dev.app.expense_tracker.user.category.model.Category#userProfile
	 **/
	public static volatile SingularAttribute<Category, UserProfile> userProfile;

	public static final String CREATED_TIMESTAMP = "createdTimestamp";
	public static final String NAME = "name";
	public static final String HEX = "hex";
	public static final String CURRENCY = "currency";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String LAST_MODIFIED_TIMESTAMP = "lastModifiedTimestamp";
	public static final String USER_PROFILE = "userProfile";

}

