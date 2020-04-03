package com.token.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.token.model.TemplateMaster;

public interface MasterRepo extends JpaRepository<TemplateMaster, Long> {

}

