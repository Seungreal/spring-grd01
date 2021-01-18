package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes({"ctx","cmm","mgr","tea","uss","grd"})
public class HomeController {
	@Autowired HttpSession session;
	@Autowired HttpServletRequest request;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/")
	public String index() {
		String ctx = request.getContextPath();
		session.setAttribute("ctx", ctx);
		session.setAttribute("cmm", ctx+"/resources/cmm");
		session.setAttribute("mgr", ctx+"/resources/sym/mgr");
		session.setAttribute("tea", ctx+"/resources/sym/tea");
		session.setAttribute("stu", ctx+"/resources/uss");
		session.setAttribute("sts", ctx+"/resources/sts");
		logger.info("Welcome home!");
		return "index";
	}
	
	//uss 사용시
	@GetMapping("/user/{page}")
    public String user(@PathVariable String page){
        logger.info("이동한 페이지:"+page);
        return String.format("user:%s", page);
    }
    
	//sym 사용시
    @GetMapping("/admin/{dir}/{page}")
    public String admin(@PathVariable String dir,@PathVariable String page){
        logger.info("이동한 페이지:"+dir+"/"+page);
        return String.format("admin:%s/%s", dir,page);
    }
    @GetMapping("/mgr/{page}")
    public String mgr(@PathVariable String page){
        logger.info("이동한 페이지:"+page);
        return String.format("mgr:%s",page);
    }
    @GetMapping("/tea/{page}")
    public String tea(@PathVariable String page){
        logger.info("이동한 페이지:"+page);
        return String.format("tea:%s",page);
    }
    
    //cop 사용시
    @GetMapping("/content/{dir}/{page}")
    public String content(@PathVariable String dir,@PathVariable String page){
        logger.info("이동한 페이지:"+dir+"/"+page);
        return String.format("content:%s/%s", dir,page);
    }
    
    @GetMapping("/home")
    public String home() {
    	logger.info("타일즈 성공");
    	return "public";
    }
   
}
