import com.score.boot.model.dto.Logindto;
import com.score.boot.model.dto.StudentLogin;
import com.score.boot.model.pojo.TStudent;
import com.score.boot.model.pojo.TUser;
import com.score.boot.service.IUserService;
import com.score.boot.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    //教师登录
    @RequestMapping("/teacherLogin")
    public ResponseUtils<String> login(@RequestBody Logindto logindto){
        try {
            TUser login = userService.login(logindto);
            if (login==null){
                System.out.println(login);
                return new ResponseUtils<>(500,"教师登录失败");
            }else {
                return new ResponseUtils<>(200,"教师登录成功");
            }
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    //学生登录
    @RequestMapping("/studentLogin")
    public ResponseUtils<String> stucentLogin(@RequestBody StudentLogin studentLogin){
        try {
            TStudent tologin = userService.tologin(studentLogin);
            if (tologin==null){
                System.out.println(tologin);
                return new ResponseUtils<>(500,"学生登录失败");
            }else {
                return new ResponseUtils<>(200,"学生登录成功");
            }
        }catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}