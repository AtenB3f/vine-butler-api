package com.atenb.vinebutlerapi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 시/도
    @Column(name = "si_do", length = 50)
    private String sidoName;

    // 시/군/구
    @Column(name = "si_gun_gu", length = 50)
    private String sigunguName;

    // 읍/면/동
    @Column(name = "eup_myeon_dong", length = 50)
    private String eupMyeonDongName;

    // 지번주소
    @Column(length = 255)
    private String jibunAddr;

    // 도로명주소
    @Column(length = 255)
    private String roadAddr;

    // 우편번호
    @Column(length = 10)
    private String zipCode;

    // 위도
    @Column(precision = 10, scale = 8)
    private BigDecimal latitude;

    // 경도
    @Column(precision = 11, scale = 8)
    private BigDecimal longitude;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "address")
    private List<Property> properties = new ArrayList<>();
}