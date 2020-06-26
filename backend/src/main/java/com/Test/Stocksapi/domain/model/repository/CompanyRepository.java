package com.Test.Stocksapi.domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Test.Stocksapi.domain.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
