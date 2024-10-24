package DAO;

import java.util.List;

import entities.CinemaRoom;

public interface RoomDao {

	CinemaRoom GetRoomByID(int id);

	List<CinemaRoom> GetAllRoom();

	void UpdateRoomByID(int id, CinemaRoom room);

	void DeleteRoomById(int id);

	void InsertRoom(CinemaRoom room);

}
