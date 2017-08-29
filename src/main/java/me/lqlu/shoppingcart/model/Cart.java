package me.lqlu.shoppingcart.model;

import java.util.HashSet;
import java.util.Set;

public class Cart {

	private Set<Goods> goods;

	public Cart() {
		goods = new HashSet<Goods>();
	}

	public Set<Goods> getGoods() {
		return goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}

	public void put(Goods g) {
		goods.add(g);
	}

	public void delete(Goods g) {
		goods.remove(g);
	}
}
