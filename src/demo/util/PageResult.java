package demo.util;

public class PageResult implements java.io.Serializable {
	private int pageNo; 
	private int pageSize; 
	private int recordCount; 
	private int pageCount; 
	
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

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageCount() {
		if (this.recordCount % this.pageSize == 0)
			return this.recordCount / this.pageSize;
		else
			return this.recordCount / this.pageSize + 1;
	}
}
