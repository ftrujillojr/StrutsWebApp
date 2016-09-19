package org.yourorg.yourapp.models;

import java.util.ArrayList;
import java.util.List;

public class JsonResponse {
    private int status;
    private String message;
    private Object data;
    private List<Object> dataList;

    public JsonResponse() { }
    

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void addToDataList(Object data) {
        if(this.dataList == null) {
            this.dataList = new ArrayList<>();
        }
        this.dataList.add(data);
    }
    
    public void setData(Object data) {
        this.data = data;
    }

    public List<Object> getDataList() {
        return dataList;
    }

    public void setDataList(List<Object> dataList) {
        this.dataList = dataList;
    }
    
}
