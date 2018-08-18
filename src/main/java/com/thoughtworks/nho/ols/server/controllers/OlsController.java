package com.thoughtworks.nho.ols.server.controllers;

import com.thoughtworks.nho.ols.server.auth.UserAuth;
import com.thoughtworks.nho.ols.server.domain.Course;
import com.thoughtworks.nho.ols.server.domain.User;
import com.thoughtworks.nho.ols.server.repo.UserCenter;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author hpliu on 2018/8/18.
 */

@RestController(value = "/api")
public class OlsController {

    private UserCenter uc = UserCenter.getInstance();

    @RequestMapping(value = "/register")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> register(@RequestBody User user) throws Exception {
        String username = user.getUsername();
        String password = user.getPassword();
        if (Strings.isEmpty(username) || Strings.isEmpty(password)) {
            return new ResponseEntity<>("username or password is empty.", HttpStatus.BAD_REQUEST);
        } else if (uc.isRegister(user)) {
            return new ResponseEntity<>("user already registered.", HttpStatus.BAD_REQUEST);
        } else if (password.length() < 6) {
            return new ResponseEntity<>("password must be greater than 6.", HttpStatus.BAD_REQUEST);
        } else {
            String userId = UUID.randomUUID().toString();
            User usr = new User(username, password, userId);
            uc.addUser(username, usr);
            return new ResponseEntity<>("register success,please login.", HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> login(@RequestBody User user) {
        if (!uc.isRegister(user)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (user.equals(uc.getUserByName(user.getUsername()))) {
            return new ResponseEntity<>(new UserAuth().createTokenForUser(user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/course")
    public List<Course> getStudentCourse() {
        try {
            /*Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM studeng_course order  by DATE desc ");*/
            List<Course> courseList = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                Course stuCourse = new Course();
                stuCourse.title = "python";
                stuCourse.description = "python是一种解释型、面向对象、动态数据类型的高级程序设计语言。" +
                        "Python由Guido van Rossum于1989年底发明，第一个公开发行版发行于1991年。" +
                        "像Perl语言一样, Python 源代码同样遵循 GPL(GNU General Public License)协议。";
                stuCourse.date = "2018-08-15";
                courseList.add(stuCourse);
            }
            /*while (rs.next())
            {
                Course stuCourse = new Course();
                stuCourse.title=rs.getString("TITLE");
                stuCourse.description=rs.getString("DESCRIPTION");
                stuCourse.date=rs.getString("DATE");
                courseList.add(stuCourse);
            }*/
            String a = String.join(",", courseList.toString());
            //return new ResponseEntity<>(a, HttpStatus.OK);
            return courseList;
        } catch (Exception e) {
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return null;
        }
    }
}

