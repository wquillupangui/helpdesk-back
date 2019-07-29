package com.edimca.hdesk.rest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edimca.hdesk.model.MarkPriority;
import com.edimca.hdesk.model.Operation;
import com.edimca.hdesk.model.Request;
import com.edimca.hdesk.model.User;
import com.edimca.hdesk.model.ValueMark;
import com.edimca.hdesk.repo.OperationRepo;
import com.edimca.hdesk.repo.RequestRepo;
import com.edimca.hdesk.repo.UserRepo;

@RestController
@CrossOrigin(origins = { "*" }, allowCredentials = "true")
@RequestMapping(path="/request")
public class RequestController {
	
	public static final String MARK_PENDING="Pending";
	public static final String MARK_APPROVED="Approved";
	public static final String MARK_ASSIGNED="Assigned";
	public static final Integer STATE_ACTIVE=1;
	public static final Integer STATE_PAST=0;
	
	@Autowired
	private RequestRepo requestRepo;
	@Autowired
	private OperationRepo operationRepo;
	@Autowired
	private UserRepo userRepo;

	@GetMapping(path="/list")
	public List<Request> getAll(){
		return requestRepo.findAll();
	}
	
	@GetMapping(path="/table")
	public List<MarkPriority> getAllPending(){
		return requestRepo.retrieveRequestAsDTO();
	}
	
	@GetMapping(path="/table0")
	public List<ValueMark> getTable0(){
		return requestRepo.retrieveRequestAsDTO0();
	}
	
	@GetMapping(path="/table1")
	public List<ValueMark> getTable1(){
		return requestRepo.retrieveRequestAsDTO1();
	}
	
	@RequestMapping(path="/active", method= RequestMethod.GET)
	public Map<String, List<ReqExt>> getAllActive(){
		Map<String, List<ReqExt>> mapStrReq0=operationRepo.findByAllActive()
				.parallelStream()
				.collect(Collectors.
						groupingBy(Operation::getMark, Collectors.
								mapping(obj -> new ReqExt(obj.getRequest(),obj) , Collectors.toList())));
		return mapStrReq0;
		
	}
	
	@RequestMapping(path="/new", method= RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
	public Request putNew(@RequestBody Request obj) {		
		System.out.println(obj);
		Request request0=requestRepo.save(obj);		
		User user0=userRepo.findByName("EMPLOYEE");
		String mark0=RequestController.MARK_PENDING;
		Operation operation0=newOperation(request0, user0, mark0);		
		return request0;
	}
	
	@RequestMapping(path="/approve", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public Request updateApprove(@RequestBody ObjId obj) {		
		System.out.println(obj);
		Request request0=requestRepo.findById(obj.getRequestId()).get();
		User user0=userRepo.findByName("MANAGER");				
		String mark0=RequestController.MARK_APPROVED;	
		operationRepo.pastOperation(request0);
		Operation operation0=newOperation(request0, user0, mark0);
		return request0;

	}
	
	@RequestMapping(path="/assign", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public Request updateAssign(@RequestBody ObjId obj) {		
		System.out.println(obj);		
		Request request0=requestRepo.findById(obj.getRequestId()).get();
		User user0=userRepo.findById(obj.getUserId()).get();				
		String mark0=RequestController.MARK_ASSIGNED;	
		operationRepo.pastOperation(request0);
		Operation operation0=newOperation(request0, user0, mark0);
		return request0;
	}

	public Operation newOperation(Request request0, User user0, String mark0) {
		Operation operation0=new Operation();		
		operation0.setRequest(request0);
		operation0.setMark(mark0);
		operation0.setDate_m(LocalDateTime.now());			
		operation0.setUser(user0);
		operation0.setState(RequestController.STATE_ACTIVE);
		operation0=operationRepo.save(operation0);
		return operation0;
	}
}


class ObjId{
	
	private Integer userId;
	private Integer requestId;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getRequestId() {
		return requestId;
	}
	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}
	@Override
	public String toString() {
		return "ObjId [userId=" + userId + ", requestId=" + requestId + "]";
	}
	
}

class ReqExt {
	
	private Integer id;
	private String name;
	private String description;
	private String priority;
	private LocalDateTime date_m;
	private String user;
	private String mark;

	public ReqExt(Request req, Operation oper) {		
		this.id=req.getId();
		this.name=req.getName();
		this.description=req.getDescription();
		this.priority=req.getPriority();
		this.date_m=oper.getDate_m();	
		this.user=oper.getUser().getName();
		this.mark=oper.getMark();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public LocalDateTime getDate_m() {
		return date_m;
	}
	public void setDate_m(LocalDateTime date_m) {
		this.date_m = date_m;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}


	
	
	
}





