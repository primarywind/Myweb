package com.myweb.result;

import java.util.List;

import com.myweb.view.PictureListView;

/**
 * 
 * @author huleiwind
 * @version $Id: PictureListQueryResult.java, v 0.1 2015-12-2 下午2:26:25 huleiwind Exp $
 */
public class PictureListQueryResult extends QueryResult {

    /** serialVersionUID */
    private static final long     serialVersionUID = 2331254620817832354L;

    private List<PictureListView> pictureList;

    public List<PictureListView> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<PictureListView> pictureList) {
        this.pictureList = pictureList;
    }

}
