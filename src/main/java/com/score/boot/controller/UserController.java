package com.score.boot.controller;


import cn.hutool.core.util.IdUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.score.boot.model.dto.Logindto;
import com.score.boot.model.dto.StudentLogin;
import com.score.boot.model.pojo.TStudent;
import com.score.boot.model.pojo.TUser;
import com.score.boot.model.vo.Uservo;
import com.score.boot.model.vo.studentVo;
import com.score.boot.service.IUserService;
import com.score.boot.util.ResponseUtils;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    //JSON序列化工具
    private static final ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public static final String USER_TOKEN = "user:token:";

    //教师登录
    @RequestMapping("/teacherLogin")
    public ResponseUtils<String> login(@RequestBody Logindto logindto, HttpServletResponse response, HttpServletRequest request){
        try {
            HttpSession session = request.getSession(true);
            TUser login = userService.login(logindto);
            if (login==null){
                return new ResponseUtils<>(500,"教师登录失败");
            }else {
                Cookie username = new Cookie("username", URLEncoder.encode(login.getUserName(),"UTF-8"));

                username.setMaxAge(60*60*24*7);

                username.setPath("/");
                response.addCookie(username);

                Uservo uservo = new Uservo(login.getUserName());
                session.setAttribute("teacherLogin",uservo);

                String token= IdUtil.fastSimpleUUID();
                uservo.setToken(token);

                String redisKey=USER_TOKEN + token;
                String techerLogin = mapper.writeValueAsString(uservo);
                stringRedisTemplate.opsForValue().set(redisKey, techerLogin, 30L, TimeUnit.MINUTES);
                return new ResponseUtils<>(200,"教师登录成功");
            }
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    //教师退出登录
    @RequestMapping("/logout")
    public ResponseUtils<String> teacherLoginout(HttpServletResponse response, HttpServletRequest request){
        try {
            //从前端获取cookie值
            HttpSession session = request.getSession(false);
            if (session != null){
                //获取登录的信息
                Uservo teacherLogin = (Uservo) session.getAttribute("teacherLogin");
                if (teacherLogin!= null){
                    //清除token
                    String rediskey=USER_TOKEN+teacherLogin.getToken();
                    stringRedisTemplate.delete(rediskey);
                }
                //清除session
                session.removeAttribute("teacherLogin");
                session.invalidate();
            }
            //获取cookie
            Cookie[] cookie=request.getCookies();
            if (cookie!=null){
                for (Cookie cookie1 : cookie){
                    cookie1.setValue("");
                    cookie1.setPath("/");
                    cookie1.setMaxAge(0);
                    response.addCookie(cookie1);
                }
            }
            return new ResponseUtils<>(200,"退出登录成功");
        } catch (Exception e) {
	        throw new RuntimeException(e);
        }

    }
    //学生登录
    @RequestMapping("/studentLogin")
    public ResponseUtils<String> stucentLogin(@RequestBody StudentLogin studentLogin,HttpServletResponse response, HttpServletRequest request){
        try {
            HttpSession session = request.getSession(true);
            TStudent tologin = userService.tologin(studentLogin);
            if (tologin==null){
                return new ResponseUtils<>(500,"学生登录失败");
            }else {
                Cookie studentId = new Cookie("studentId", URLEncoder.encode(String.valueOf(studentLogin.getStudentName()),"UTF-8"));
                studentId.setMaxAge(60*60*24*7);
                studentId.setPath("/");
                response.addCookie(studentId);

                // 存储学生姓名
                Cookie username = new Cookie("username", URLEncoder.encode(tologin.getStudentName(), "UTF-8"));
                username.setMaxAge(60 * 60 * 24 * 7);
                username.setPath("/");
                response.addCookie(username);

                studentVo studentVo = new studentVo(tologin.getStudentName());
                session.setAttribute("studentLogin", studentVo);
                // 在session中也存储学号
                session.setAttribute("studentId", studentLogin.getStudentName());

                String token = IdUtil.fastSimpleUUID();
                studentVo.setToken(token);

                String redisKey = USER_TOKEN + token;
                String studentlogin = mapper.writeValueAsString(studentVo);
                stringRedisTemplate.opsForValue().set(redisKey, studentlogin, 30L, TimeUnit.MINUTES);

                return new ResponseUtils<>(200, "学生登录成功");
            }
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    //学生退出登录
    @RequestMapping("/studentLogout")
    public ResponseUtils<String> studentLogout(HttpServletResponse response, HttpServletRequest request){
        try {
            //从前端获取cookie值
            HttpSession session = request.getSession(false);
            if (session != null){
                //获取登录的信息
                studentVo studentLogin= (studentVo) session.getAttribute("studentLogin");
                if (studentLogin!= null){
                    //清除token
                    String rediskey=USER_TOKEN+studentLogin.getToken();
                    stringRedisTemplate.delete(rediskey);
                }
                //清除session
                session.removeAttribute("studentLogin");
                session.invalidate();
            }
            //获取cookie
            Cookie[] cookie=request.getCookies();
            if (cookie!=null){
                for (Cookie cookie1 : cookie){
                    cookie1.setValue("");
                    cookie1.setPath("/");
                    cookie1.setMaxAge(0);
                    response.addCookie(cookie1);
                }
            }
            return new ResponseUtils<>(200,"退出登录成功");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}