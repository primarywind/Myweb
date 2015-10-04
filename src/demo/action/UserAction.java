package demo.action;

import com.opensymphony.xwork2.ActionSupport;

import demo.entity.UserInfo;
import demo.service.IUserService;

public class UserAction extends ActionSupport {
	private UserInfo user;
	private IUserService userService;
	
	public String reg(){
		System.out.println("UserAction.reg() ... ");
		this.userService.reg(user);
		return "reg_ok";
	}

	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
}
