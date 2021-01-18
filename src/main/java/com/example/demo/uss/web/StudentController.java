package com.example.demo.uss.web;

import static com.example.demo.cmm.util.Util.*;
import com.example.demo.HomeController;
import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cmm.enm.Sql;
import com.example.demo.cmm.enm.Table;
import com.example.demo.cmm.util.Box;
import com.example.demo.cmm.util.Pagination;
import com.example.demo.sts.service.GradeService;
import com.example.demo.sts.service.SubjectService;
import com.example.demo.sym.service.ManagerService;
import com.example.demo.sym.service.TeacherService;
import com.example.demo.uss.service.Student;
import com.example.demo.uss.service.StudentRepository;
import com.example.demo.uss.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/students")
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired GradeService gradeService;
    @Autowired StudentService studentService;
    @Autowired SubjectService subjectService;
    @Autowired TeacherService teacherService;
    @Autowired ManagerService managerService;
    @Autowired StudentRepository studentRepository;
    @Autowired Pagination page;
    @Autowired Box<Object> bx;
    @PostMapping("")
    public Messenger register(@RequestBody Student s){
        studentService.register(s);
        return Messenger.SUCCESS;
    }
    @GetMapping("/insert-many/{count}")
    public String insertMany(@PathVariable String count) {
        managerService.insertMany(1);
        subjectService.insertMany(5);
        studentService.insertMany(Integer.parseInt(count));
        teacherService.insertMany(5);
        //gradeService.insertMany(Integer.parseInt(count));
        return String.valueOf(studentService.count());
    }
    @PostMapping("/login")
    public Map<?,?> login(@RequestBody Student s){
        Student result = null;
        bx.put("message", result!=null?"SUCCESS":"FAILURE");
        bx.put("sessionUser", result);
        return bx.get();
    }
    @GetMapping("/count")
    public String count(){
        bx.put("TOTAL_COUNT", Sql.TOTAL_COUNT.toString()+ Table.STUDENTS.toString());
        return String.valueOf(studentRepository.count());
    }
    @GetMapping("/{userid}")
    public Student profile(@PathVariable String userid){
        return null;
    }
    @GetMapping("/page/{pageSize}/{pageNum}")
    public Map<?,?> list(@PathVariable String pageSize, @PathVariable String pageNum){
        bx.put("TOTAL_COUNT",Sql.TOTAL_COUNT.toString()+Table.STUDENTS.toString());
        var page = new Pagination(
                Table.STUDENTS.toString(),
                integer.apply(pageSize),
                integer.apply(pageNum),
                (int)studentRepository.count());
        bx.put("list",null);
        bx.put("page", page);
        return bx.get();
    }
    @PutMapping("")
    public Messenger update(@RequestBody Student s){
        return Messenger.SUCCESS;
    }
    @DeleteMapping("")
    public Messenger delete(@RequestBody Student s){
        studentService.delete(s);
        return Messenger.SUCCESS;
    }
    @GetMapping("/truncate")
    public Messenger truncate() {
        studentService.truncate();
        return studentService.count()==0?Messenger.SUCCESS:Messenger.FAILURE;
    }
    /*@GetMapping("/find-by-gender/{gender}")
    public List<Student> findByGender(@PathVariable String gender) {
    	logger.info(String.format("find by %s", gender));
    	return studentService.selectByGender(gender);
    }*/
}