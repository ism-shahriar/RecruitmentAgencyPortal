package com.example.organization;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrgRepository extends CrudRepository<Organization, Integer> {

}
