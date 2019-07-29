package com.edimca.hdesk.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.edimca.hdesk.model.MarkPriority;
import com.edimca.hdesk.model.Request;
import com.edimca.hdesk.model.ValueMark;

public interface RequestRepo extends JpaRepository<Request, Integer> {

	
	@Query("SELECT new com.edimca.hdesk.model.MarkPriority(op.mark "
			+ ", sum(case when re.priority = 'High' then 1 else 0 end) \n "
			+ ", sum(case when re.priority = 'Normal' then 1 else 0 end) \n"
			+ ", sum(case when re.priority = 'Low' then 1 else 0 end) \n "
			+ ", count(re.id) \n" 
			+ ") \n"+			
			" from Operation op \n" + 
			" left JOIN  op.request re" + 
			
			" where op.state=1 " + 
			" group by op.mark " + 
			" order by op.mark ")
	public List<MarkPriority> retrieveRequestAsDTO();
	
	@Query("SELECT new com.edimca.hdesk.model.ValueMark(re.priority "
			+ ", sum(case when op.mark = 'Pending' then 1 else 0 end) \n "
			+ ", sum(case when op.mark = 'Approved' then 1 else 0 end) \n "
			+ ", sum(case when op.mark = 'Assigned' then 1 else 0 end) \n"			
			+ ", count(re.id) \n" 
			+ ") \n"+			
			" from Operation op \n" + 
			" left JOIN  op.request re" + 
			
			" where op.state=1 " + 
			" group by re.priority " + 
			" order by re.priority ")
	public List<ValueMark> retrieveRequestAsDTO0();
	
	@Query("SELECT new com.edimca.hdesk.model.ValueMark(us.name "
			+ ", sum(case when op.mark = 'Pending' then 1 else 0 end) \n "
			+ ", sum(case when op.mark = 'Approved' then 1 else 0 end) \n "
			+ ", sum(case when op.mark = 'Assigned' then 1 else 0 end) \n"			
			+ ", count(op.id) \n" 
			+ ") \n"+			
			" from Operation op \n" + 
			" left JOIN  op.user us " + 			
			" where op.state=1 and \n" + 
			" us.role='TECH' " + 
			" group by us.name " + 
			" order by us.name ")
	public List<ValueMark> retrieveRequestAsDTO1();
	
	
}

