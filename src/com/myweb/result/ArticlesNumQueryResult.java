package com.myweb.result;

/**
 * 
 * @author huleiwind
 * @version $Id: ArticlesNumQueryResult.java, v 0.1 2015-12-3 下午3:08:35 huleiwind Exp $
 */
public class ArticlesNumQueryResult extends QueryResult {

    /** serialVersionUID */
    private static final long serialVersionUID = 8359591324584324112L;
    private int               nums;

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

}
