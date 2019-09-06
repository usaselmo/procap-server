package com.procap.server.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.procap.server.model.Office;

@Repository
public interface OfficeRepo extends CrudRepository<Office, Integer>{

}
