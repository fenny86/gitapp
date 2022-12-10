package dao;

import java.util.List;

import model.Item;

public interface ItemDao {
	public void insert(Item item);
	public void deleteById(int Pd_id);
	public void updateItem(Item item);
	public Item selectItem(int Pd_id);
	public List<Item>  selectAll();
}
