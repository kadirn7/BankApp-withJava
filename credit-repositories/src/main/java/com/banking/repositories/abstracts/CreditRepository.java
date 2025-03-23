package com.banking.repositories.abstracts;

import com.banking.entities.concretes.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends JpaRepository<Credit, Long> {
    // İhtiyaç duyulursa özel sorgular eklenebilir
}