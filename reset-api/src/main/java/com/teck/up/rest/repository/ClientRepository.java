package com.teck.up.rest.repository;

import com.teck.up.rest.domain.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<ClientEntity,Long> {
	
	@Query("select c from ClientEntity c where c.id like :x")
	ClientEntity FindById(@Param("x")Long id);

}
