package com.jotahdev.job_development.Modules.Company.Entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity(name = "jobs")
@Data
public class JobEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String description;
    private String benefits;
    private String level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id") // Relacionamento com a chave estrangeira
    private CompanyEntity companyEntity;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
