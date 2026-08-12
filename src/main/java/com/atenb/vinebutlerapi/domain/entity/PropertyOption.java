package com.atenb.vinebutlerapi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "property_options", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "property_id", "option_id"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @ManyToOne
    @JoinColumn(name = "option_id", nullable = false)
    private FurnitureOption furnitureOption;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
