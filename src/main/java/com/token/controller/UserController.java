package com.token.controller;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.token.bean.Template;
import com.token.model.TemplateMaster;
import com.token.service.ErrorService;
import com.token.service.UserService;


@RestController
public class UserController {


	@Autowired
	private UserService service;

	@Autowired
	private HttpServletRequest request;
	
	  @PostMapping("/tokenverify")
	  public ResponseEntity<?> verifytokens(@RequestBody Map<String, Object> requBody)  {
		  return new  ResponseEntity<Object>(service.verifytoken(this.request, requBody), HttpStatus.OK); 
		  
	  }
	  
		 
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/tokenverify/api")
	  public ResponseEntity<?> verifytemplate(@RequestBody Template temp) 
	 
	  {
    	
    	
		   try {
		  long id =temp.getTempid();
		  String mob=temp.getSmstomob();
		  String message=temp.getTemplatemsg();
		  
		  
		  
		  Map<Long,TemplateMaster> result=service.getnotify(temp.getTempid());
			if (mob.equalsIgnoreCase(result.get(id).getSmsto()) &&  message.equalsIgnoreCase(result.get(id).getTemplatemessage()))
			{
			
	    return new ResponseEntity(new ErrorService("Successfully done","SMS Send Succesfully") ,HttpStatus.OK);
			}
		return new ResponseEntity(new ErrorService("Success", "SMS Varification is done Please Provide Valid API to Send SMS ") ,HttpStatus.OK);
		
			}
			catch (Exception e) {
				e.printStackTrace();
		return new ResponseEntity(new ErrorService("Failed","Something is getting wrong"+e),HttpStatus.OK);
			}
	  }}
