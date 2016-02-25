package com.myweb.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.myweb.entity.Picture;
import com.myweb.entity.User;
import com.myweb.result.BizResult;
import com.myweb.result.UserInfoQueryResult;
import com.myweb.service.IPictureService;
import com.myweb.service.IUserService;
import com.myweb.util.HandlerPath;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
    /**  */
    private static final long serialVersionUID = -8606662112364181323L;

    private String            name;
    private String            password;
    private int               sex;
    private String            city;
    private int               pageSize         = 100;
    private int               pageNo           = 1;
    private IUserService      userService;
    private IPictureService   pictureService;
    private String            result;
    //上传图片名称
    private String            fileFileName;
    private File              file;
    public Map                responseJson;

    private String            userName;
    private String            nationality;
    private String            blogUrl;
    private String            faceImg;

    //用户信息

    public String registerUser() {
        Map<String, Object> map = new HashMap<String, Object>();
        BizResult<User> bizResult = userService.saveUser(name, password, sex, city);

        if (bizResult.isSuccess()) {
            ActionContext actionContext = ActionContext.getContext();
            Map session = actionContext.getSession();
            session.put("USER", bizResult.getObject());
            map.put("msg", "注册成功");
        } else {
            map.put("msg", "注册失败");
        }

        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String getUserDatas() {
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        User user = (User) session.get("USER");
        Map<String, Object> map = new HashMap<String, Object>();
        UserInfoQueryResult userInfoQueryResult = userService.getUserInfo(user.getUserId(), pageNo,
            pageSize);
        map.put("userInfo", userInfoQueryResult.getUserInfoView());
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String uploadUserFaceImg() {
        BizResult<Picture> bizResult = pictureService.uploadUserImgPic(file, fileFileName);
        result = "{flag:\"1\",msg:\"上传成功\",path:\"" + HandlerPath.getPicturePath()
                 + bizResult.getObject().getPicName() + "\",picName:\""
                 + bizResult.getObject().getPicName() + "\"}";
        return Action.SUCCESS;
    }

    public String updateUserInfo() {
        Map<String, Object> map = new HashMap<String, Object>();
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        User user = (User) session.get("USER");
        BizResult<User> bizResult = userService.updateUserInfo(user.getUserId(), sex, userName,
            nationality, blogUrl, faceImg);

        if (bizResult.isSuccess()) {
            session.put("USER", bizResult.getObject());
            map.put("msg", "保存成功");
        } else {
            map.put("msg", "保存失败");
        }

        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public IUserService getUserService() {
        return userService;
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public Map getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(Map responseJson) {
        this.responseJson = responseJson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public IPictureService getPictureService() {
        return pictureService;
    }

    public void setPictureService(IPictureService pictureService) {
        this.pictureService = pictureService;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getBlogUrl() {
        return blogUrl;
    }

    public void setBlogUrl(String blogUrl) {
        this.blogUrl = blogUrl;
    }

    public String getFaceImg() {
        return faceImg;
    }

    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg;
    }

}
