package com.edimca.hdesk.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edimca.hdesk.model.Operation;
import com.edimca.hdesk.model.Request;

public interface OperationRepo extends JpaRepository<Operation, Integer> {
	
	@Query("SELECT obj FROM Operation obj WHERE obj.state=1" )
	public List<Operation> findByAllActive();
	
	@Modifying
    @Query("UPDATE Operation o SET o.state = 0 WHERE o.request = :request")
    public int pastOperation(@Param("request") Request request );

}
