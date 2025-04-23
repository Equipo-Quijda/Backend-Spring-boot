package com.quijada.ecommerce.repository;

import com.quijada.ecommerce.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepositorio extends JpaRepository<Roles, Integer> {
}
