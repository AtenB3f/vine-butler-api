package com.atenb.vinebutlerapi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "property_transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "property_id", nullable = false, unique = true)
    private Property property;

    // 거래 타입(매매, 전세, 월세)
    @ManyToOne
    @JoinColumn(name = "transaction_type_id", nullable = false)
    private TransactionType transactionType;

    // 거래 상태(거래 대기, 거래 중, 거래 완료)
    @ManyToOne
    @JoinColumn(name = "transaction_status_id", nullable = false)
    private TransactionStatus transactionStatus;

    // 거래 금액
    @Column(precision = 15, scale = 2)
    private BigDecimal transactionAmount;

    // 월세
    @Column(precision = 10, scale = 2)
    private BigDecimal monthlyRent;

    // 관리비
    @Column(precision = 10, scale = 2)
    private BigDecimal maintenanceCost;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
