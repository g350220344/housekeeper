package com.cindata.housekeeper.core.entity;

import java.util.List;

public class JSONResult<T> extends Result {

    private static final long serialVersionUID = 7880907731807860636L;
    
    /**
     *数据集
     */
    private List<T> dataList;

    /**
     * 数据
     */
    private T data;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public JSONResult() {
        super();
    }
    private Long dataCount;
    private Long saleCount;
    private Long rentCount;
   
    
    
    
    /**
     * 自定义返回的结果
     *
     * @param data
     * @param message
     * @param success
     */
    public JSONResult(T data, String message, boolean success) {
        this.data = data;
        super.setMessage(message);
        super.setSuccess(success);
    }

    public JSONResult(String message, boolean success) {
        super.setMessage(message);
        super.setSuccess(success);
    }
    
    /**
     * 自定义返回的结果
     *
     * @param data
     * @param message
     * @param success
     */
    public JSONResult(List<T> dataList, T data, String message, boolean success) {
        this.data = data;
        this.dataList = dataList;
        super.setMessage(message);
        super.setSuccess(success);
    }

    /**
     * 成功返回数据和消息
     *
     * @param data
     * @param message
     */
    public JSONResult(T data, String message) {
        this.data = data;
        super.setMessage(message);
        super.setSuccess(true);
    }

    /**
     * 成功返回数据
     *
     * @param data
     */
    public JSONResult(T data) {
        this.data = data;
        super.setSuccess(true);
    }

	public Long getDataCount() {
		return dataCount;
	}

	public void setDataCount(Long dataCount) {
		this.dataCount = dataCount;
	}

	public Long getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(Long saleCount) {
		this.saleCount = saleCount;
	}

	public Long getRentCount() {
		return rentCount;
	}

	public void setRentCount(Long rentCount) {
		this.rentCount = rentCount;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	

	
    
    
    
    
}