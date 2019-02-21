package com.sdg.cmdb.domain.ci;

import java.io.Serializable;

public class CiJobParamDO implements Serializable {

    private static final long serialVersionUID = -3079969773802777636L;

    private long id;

    private long jobId;

    private String paramName;

    private String paramValue;

    private String content;

    private String gmtCreate;

    private String gmtModify;

    public CiJobParamDO() {

    }

    public CiJobParamDO(long jobId, String paramName, String paramValue) {
        this.jobId = jobId;
        this.paramName = paramName;
        this.paramValue = paramValue;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(String gmtModify) {
        this.gmtModify = gmtModify;
    }
}
