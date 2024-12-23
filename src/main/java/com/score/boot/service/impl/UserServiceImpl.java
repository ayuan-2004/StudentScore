package com.score.boot.service.impl;

import com.score.boot.dao.TStudentMapper;
import com.score.boot.model.dto.Logindto;
import com.score.boot.model.dto.StudentLogin;
import com.score.boot.model.dto.Studentdtn;
import com.score.boot.model.pojo.TStudent;
import com.score.boot.model.pojo.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.score.boot.dao.UserDao;
import com.score.boot.service.IUserService;

import java.util.List;

/**
 * 服务实现
 * @author hmg
 *
 */
@Service //标识为服务类
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private TStudentMapper studentMapper;

    @Override public TUser login(Logindto logindto) {
        return userDao.login(logindto);
    }

    @Override public TStudent tologin(StudentLogin studentLogin) {
        return studentMapper.tologin(studentLogin);
    }
}
