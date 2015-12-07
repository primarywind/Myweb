package com.myweb.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.myweb.entity.Picture;
import com.myweb.result.BizResult;
import com.myweb.result.PictureListQueryResult;
import com.myweb.service.IPictureService;
import com.myweb.util.HandlerPath;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @author huleiwind
 * @version $Id: PictureAction.java, v 0.1 2015-10-14 下午4:47:12 huleiwind Exp $
 */
public class PictureAction extends ActionSupport {
    /**  */
    private static final long serialVersionUID = 3198512705781943241L;
    private IPictureService   pictureService;
    private int               pageNo           = 1;
    //默认一页10条
    private int               pageSize         = 10;
    public Map                responseJson;
    private String            result;
    //上传图片名称
    private String            fileFileName;
    private String            fileContentType;

    // 上传数据
    private File              file;
    private String[]          delAIds;

    public String findPicturesByPage() {

        PictureListQueryResult pictureListQueryResult = pictureService
            .findByPages(pageNo, pageSize);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pictureListViews", pictureListQueryResult.getPictureList());
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public String uploadSpecialRecommendPic() {
        BizResult<Picture> bizResult = pictureService.uploadPicFile(file, fileFileName);
        result = "{flag:\"1\",msg:\"上传成功\",path:\"" + HandlerPath.getPicturePath()
                 + bizResult.getObject().getPicName() + "\",picName:\"" + fileFileName + "\"}";
        return Action.SUCCESS;

    }

    public String savePictureChange() {
        BizResult<Object> bizResult = pictureService.savePictureChange(delAIds);
        Map<String, Object> map = new HashMap<String, Object>();
        if (bizResult.isSuccess()) {
            map.put("msg", "保存成功！");
        } else {
            map.put("msg", "保存异常，数据回滚！");
        }
        this.setResponseJson(map);
        return Action.SUCCESS;
    }

    public IPictureService getPictureService() {
        return pictureService;
    }

    public void setPictureService(IPictureService pictureService) {
        this.pictureService = pictureService;
    }

    public Map getResponseJson() {
        return responseJson;
    }

    public void setResponseJson(Map responseJson) {
        this.responseJson = responseJson;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
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

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String[] getDelAIds() {
        return delAIds;
    }

    public void setDelAIds(String[] delAIds) {
        this.delAIds = delAIds;
    }

}
