package com.myweb.result;

import com.myweb.view.HotUserView;

import java.util.List;

/**
 *
 * @author huleiwind
 * @version $Id: HotUserQueryResult.java, v 0.1 2016-03-16/3/5-16:01 huleiwind Exp $$
 */
public class HotUserQueryResult extends QueryResult{

    private static final long serialVersionUID = 9177431614150344545L;
    private List<HotUserView> hotUserViewList;

    public List<HotUserView> getHotUserViewList() {
        return hotUserViewList;
    }

    public void setHotUserViewList(List<HotUserView> hotUserViewList) {
        this.hotUserViewList = hotUserViewList;
    }
}
