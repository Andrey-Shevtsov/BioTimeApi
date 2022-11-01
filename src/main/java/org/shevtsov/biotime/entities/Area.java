package org.shevtsov.biotime.entities;

public class Area {
    private int id;
    private String areaCode;
    private String areaName;
    private String parentArea;

    public Area(
            int id,
            String areaCode,
            String areaName,
            String parentArea
    ) {
        this.id = id;
        this.areaCode = areaCode;
        this.areaName = areaName;
        this.parentArea = parentArea;
    }

    public int getId() {
        return id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public String getParentArea() {
        return parentArea;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public void setParentArea(String parentArea) {
        this.parentArea = parentArea;
    }
}
