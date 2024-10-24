package DAO;

import java.util.List;

import entities.Seat;

public interface SetDao {

	Seat GetSetByID(int id);

	List<Seat> GetAllSet();

	void UpdateSetByID(int id, Seat seat);

	void DeleteSetById(int id);

	void InsertSet(Seat seat);

}
