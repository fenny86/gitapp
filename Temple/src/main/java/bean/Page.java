package bean;

public class Page {
	private Integer pageIndex;
	private Integer pageSize;
	private Integer totalCounts;
	private Integer totalPage;
	private Integer startRows;
	public Page(Integer pageIndex, Integer pageSize) {
		super();
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.setStartRows((pageIndex-1)*pageSize);
	}
	public Page(Integer pageIndex) {
		this(pageIndex,5);
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCounts() {
		return totalCounts;
	}
	public void setTotalCounts(Integer totalCounts) {
		this.totalCounts = totalCounts;
		this.setTotalPage(totalCounts%pageSize==0?totalCounts/pageSize:totalCounts/pageSize+1);

	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getStartRows() {
		return startRows;
	}
	public void setStartRows(Integer startRows) {
		this.startRows = startRows;
	}
	
	
	

}
