package demo.action;

import com.opensymphony.xwork2.ActionSupport;

import demo.entity.User;
import demo.service.IUserService;

public class UserAction extends ActionSupport {
    /**  */
    private static final long serialVersionUID = -8606662112364181323L;

    private User              user;

    private IUserService      userService;

    public String reg() {

        this.userService.reg(user);
        return "reg_ok";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

}
