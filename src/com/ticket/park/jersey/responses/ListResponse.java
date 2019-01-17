package com.ticket.park.jersey.responses;

import java.util.List;

import com.ticket.park.data.DDCategory;




public class ListResponse extends ServiceResponse {
	
	private List<DDCategory> list;
	
	public ListResponse()
	{}

	public List<DDCategory> getList() {
		return list;
	}

	public void setList(List<DDCategory> list) {
		this.list = list;
	}

}
