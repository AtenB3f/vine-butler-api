package com.atenb.vinebutlerapi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "furniture_options")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FurnitureOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 가구 이름
    @Column(length = 255, nullable = false, unique = true)
    private String name;

    // 유저 추가 가구 옵션
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isCustom = false;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
