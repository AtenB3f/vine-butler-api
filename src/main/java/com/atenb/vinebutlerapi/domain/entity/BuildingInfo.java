package com.atenb.vinebutlerapi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "building_infos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Property와 BuildingInfo는 1:1 관계
    @OneToOne
    @JoinColumn(name = "property_id", nullable = false, unique = true)
    private Property property;

    // 국가 표준 건물 종류
    @Column(length = 20)
    private String propertyTypeCode;

    // 층수
    @Column
    private Integer floor;

    // 건물의 전체 층수
    @Column
    private Integer totalFloor;

    // 전용면적
    @Column(precision = 10, scale = 2)
    private BigDecimal exclusiveArea;

    // 공급면적: 전용면적과 주거공용면적을 합한 것
    @Column(precision = 10, scale = 2)
    private BigDecimal supplyArea;

    // 공용면적: 복도, 계단, 엘리베이터 등
    @Column(precision = 10, scale = 2)
    private BigDecimal commonArea;

    // 임대면적: 공급면적+기타 공용면적
    @Column(precision = 10, scale = 2)
    private BigDecimal rentableArea;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
