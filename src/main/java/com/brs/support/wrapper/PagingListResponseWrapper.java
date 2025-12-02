package com.brs.support.wrapper;

import com.brs.support.enums.RestApiResponseStatus;

import java.util.List;

/**
 * @author Nuwan
 */
public class PagingListResponseWrapper<T> extends BaseResponseWrapper {

    private List<T> content;

    private Pagination pagination;

    public PagingListResponseWrapper(List<T> content, Pagination pagination) {
        super(RestApiResponseStatus.OK);
        this.content = content;
        this.pagination = pagination;
    }


  public static class Pagination {

    public Pagination(Integer pageNumber, Integer pageSize, Integer totalPages, Long totalRecords) {
      this.pageNumber = pageNumber;
      this.pageSize = pageSize;
      this.totalPages = totalPages;
      this.totalRecords = totalRecords;
    }

    private Integer pageNumber;

    private Integer pageSize;

    private Integer totalPages;

    private Long totalRecords;

    public Integer getPageNumber() {
      return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
      this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
      return pageSize;
    }

    public void setPageSize(Integer pageSize) {
      this.pageSize = pageSize;
    }

    public Integer getTotalPages() {
      return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
      this.totalPages = totalPages;
    }

    public Long getTotalRecords() {
      return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
      this.totalRecords = totalRecords;
    }
  }

  public List<T> getContent() {
    return content;
  }

  public void setContent(List<T> content) {
    this.content = content;
  }

  public Pagination getPagination() {
    return pagination;
  }

  public void setPagination(Pagination pagination) {
    this.pagination = pagination;
  }


}
