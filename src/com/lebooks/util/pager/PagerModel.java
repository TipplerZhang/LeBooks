package com.lebooks.util.pager;

public class PagerModel {
    private Integer pageIndex = 1;
    private Integer pageSize = 8;
    private Integer totalNum;
    private Integer pageCount;
    private String book_type = null;
    private String book_birthplace = null;

    public String getBook_type() {
        return book_type;
    }

    public void setBook_type(String book_type) {
        this.book_type = book_type;
    }

    public String getBook_birthplace() {
        return book_birthplace;
    }

    public void setBook_birthplace(String book_birthplace) {
        this.book_birthplace = book_birthplace;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
    // 计算查询的开始行号
    public int getStartSize(){
        return (this.pageIndex - 1) * this.pageSize;
    }
}
