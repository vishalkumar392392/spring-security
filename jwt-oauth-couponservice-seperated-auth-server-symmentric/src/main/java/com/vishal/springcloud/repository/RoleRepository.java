package com.vishal.springcloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vishal.springcloud.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
