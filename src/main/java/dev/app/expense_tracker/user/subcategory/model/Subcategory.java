package dev.app.expense_tracker.user.subcategory.model;

import dev.app.expense_tracker.user.category.model.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Table(schema = "expense-tracker")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdTimestamp;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant lastModifiedTimestamp;

    @ManyToOne(optional = false)
    private Category category;
}
