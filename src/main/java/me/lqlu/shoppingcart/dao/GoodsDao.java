package me.lqlu.shoppingcart.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import me.lqlu.shoppingcart.model.Goods;

public class GoodsDao {

	private GoodsDao() {
	}

	private static GoodsDao instance = new GoodsDao();

	public static GoodsDao getInstance() {
		return instance;
	}

	public static List<Goods> goods;
	{
		goods = new ArrayList<Goods>();

		// 电视机
		Goods television = new Goods();
		television.setId(UUID.randomUUID().toString());
		television.setName("电视机");
		goods.add(television);

		// 冰箱
		Goods refrigerator = new Goods();
		refrigerator.setId(UUID.randomUUID().toString());
		refrigerator.setName("冰箱");
		goods.add(refrigerator);

		// 笔记本电脑
		Goods notebook = new Goods();
		notebook.setId(UUID.randomUUID().toString());
		notebook.setName("笔记本电脑");
		goods.add(notebook);

		// 空调
		Goods airConditioning = new Goods();
		airConditioning.setId(UUID.randomUUID().toString());
		airConditioning.setName("空调");
		goods.add(airConditioning);

		// 洗衣机
		Goods washer = new Goods();
		washer.setId(UUID.randomUUID().toString());
		washer.setName("洗衣机");
		goods.add(washer);

	}

	public List<Goods> findAllGoods() {
		return goods;
	}

	public Goods findById(String id) {
		for (Goods g : goods) {
			if (g.getId().equals(id)) {
				return g;
			}
		}
		return null;
	}

}
