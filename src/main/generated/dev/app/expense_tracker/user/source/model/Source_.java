package dev.app.expense_tracker.user.source.model;

import dev.app.expense_tracker.user.profile.model.UserProfile;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.time.Instant;

@StaticMetamodel(Source.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Source_ {

	
	/**
	 * @see dev.app.expense_tracker.user.source.model.Source#balance
	 **/
	public static volatile SingularAttribute<Source, BigDecimal> balance;
	
	/**
	 * @see dev.app.expense_tracker.user.source.model.Source#createdTimestamp
	 **/
	public static volatile SingularAttribute<Source, Instant> createdTimestamp;
	
	/**
	 * @see dev.app.expense_tracker.user.source.model.Source#name
	 **/
	public static volatile SingularAttribute<Source, String> name;
	
	/**
	 * @see dev.app.expense_tracker.user.source.model.Source#hex
	 **/
	public static volatile SingularAttribute<Source, String> hex;
	
	/**
	 * @see dev.app.expense_tracker.user.source.model.Source#currency
	 **/
	public static volatile SingularAttribute<Source, String> currency;
	
	/**
	 * @see dev.app.expense_tracker.user.source.model.Source#id
	 **/
	public static volatile SingularAttribute<Source, Long> id;
	
	/**
	 * @see dev.app.expense_tracker.user.source.model.Source
	 **/
	public static volatile EntityType<Source> class_;
	
	/**
	 * @see dev.app.expense_tracker.user.source.model.Source#lastModifiedTimestamp
	 **/
	public static volatile SingularAttribute<Source, Instant> lastModifiedTimestamp;
	
	/**
	 * @see dev.app.expense_tracker.user.source.model.Source#userProfile
	 **/
	public static volatile SingularAttribute<Source, UserProfile> userProfile;

	public static final String BALANCE = "balance";
	public static final String CREATED_TIMESTAMP = "createdTimestamp";
	public static final String NAME = "name";
	public static final String HEX = "hex";
	public static final String CURRENCY = "currency";
	public static final String ID = "id";
	public static final String LAST_MODIFIED_TIMESTAMP = "lastModifiedTimestamp";
	public static final String USER_PROFILE = "userProfile";

}

