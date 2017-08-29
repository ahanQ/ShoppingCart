package me.lqlu.shoppingcart.model;

import java.io.Serializable;

public class Goods implements Serializable {

	private static final long serialVersionUID = 4326431666387551908L;

	private String id;

	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
