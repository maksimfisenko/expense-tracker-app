package dev.app.expense_tracker.user.subcategory.model;

import dev.app.expense_tracker.user.category.model.Category;
import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.Instant;

@StaticMetamodel(Subcategory.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Subcategory_ {

	
	/**
	 * @see dev.app.expense_tracker.user.subcategory.model.Subcategory#createdTimestamp
	 **/
	public static volatile SingularAttribute<Subcategory, Instant> createdTimestamp;
	
	/**
	 * @see dev.app.expense_tracker.user.subcategory.model.Subcategory#name
	 **/
	public static volatile SingularAttribute<Subcategory, String> name;
	
	/**
	 * @see dev.app.expense_tracker.user.subcategory.model.Subcategory#id
	 **/
	public static volatile SingularAttribute<Subcategory, Long> id;
	
	/**
	 * @see dev.app.expense_tracker.user.subcategory.model.Subcategory#category
	 **/
	public static volatile SingularAttribute<Subcategory, Category> category;
	
	/**
	 * @see dev.app.expense_tracker.user.subcategory.model.Subcategory
	 **/
	public static volatile EntityType<Subcategory> class_;
	
	/**
	 * @see dev.app.expense_tracker.user.subcategory.model.Subcategory#lastModifiedTimestamp
	 **/
	public static volatile SingularAttribute<Subcategory, Instant> lastModifiedTimestamp;

	public static final String CREATED_TIMESTAMP = "createdTimestamp";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String CATEGORY = "category";
	public static final String LAST_MODIFIED_TIMESTAMP = "lastModifiedTimestamp";

}

