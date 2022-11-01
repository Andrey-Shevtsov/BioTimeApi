package org.shevtsov.biotime.requests;

public class GetAreaListRequest {
    private String page;
    private String pageSize;

    public GetAreaListRequest(
            int page,
            int pageSize
    ) {
        this.page = String.valueOf(page);
        this.pageSize = String.valueOf(pageSize);
    }

    public String getPage() {
        return page;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }
}
