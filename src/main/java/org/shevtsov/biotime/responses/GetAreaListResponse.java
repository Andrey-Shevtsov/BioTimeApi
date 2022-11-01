package org.shevtsov.biotime.responses;

import org.shevtsov.biotime.entities.Area;

public class GetAreaListResponse {
    private int count;
    private String next;
    private String previous;
    private String msg;
    private int code;
    private Area[] data;

    public GetAreaListResponse(
            int count,
            String next,
            String previous,
            String msg,
            int code,
            Area[] data
    ) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public Area[] getData() {
        return data;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(Area[] data) {
        this.data = data;
    }
}
