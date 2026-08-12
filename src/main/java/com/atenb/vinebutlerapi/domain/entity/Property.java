package com.atenb.vinebutlerapi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "properties")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 주소
    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    // 공인중개사
    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    // 매물 종류(매매, 전세, 월세)
    @ManyToOne
    @JoinColumn(name = "property_type_id", nullable = false)
    private PropertyType propertyType;

    // 인근 교통편 정보
    // 가까운 지하철
    @Column(length = 255)
    private String vicinitySubway;

    //가까운 버스역
    @Column(length = 255)
    private String vicinityBus;

    // 집주인 전화번호
    @Column(length = 20)
    private  String ownerPhoneNumber;

    // 융자 여부
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isLoan = false;

    // 전세보험 가입 가능 여부
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isSuretyInsured = false;

    // 입주일 협의 가능 여부
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean moveInAvailable = false;

    // 주차 가능 여부
    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean parkingAvailable = false;

    // 크롤링 시 데이터 원본 URL
    @Column(length = 2048)
    private String sourceUrl;

    // 데이터 출처
    @Column(length = 50)
    private String sourceType;

    // 메모
    @Column(columnDefinition = "TEXT")
    private String memo;

    // 블로그 포스팅 url
    @Column(length = 2048)
    private String blogPostUrl;


    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;


    @OneToMany(mappedBy = "property")
    private List<PropertyOption> propertyOptions = new ArrayList<>();

    @OneToMany(mappedBy = "property")
    private List<PropertyImage> propertyImages = new ArrayList<>();

    @OneToOne(mappedBy = "property")
    private PropertyTransaction propertyTransaction;
}
