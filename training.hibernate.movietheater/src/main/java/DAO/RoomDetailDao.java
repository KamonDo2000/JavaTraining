package DAO;

import java.util.List;

import entities.CinemaRoomDetail;

public interface RoomDetailDao {

	CinemaRoomDetail GetRoomDetailByID(int id);

	List<CinemaRoomDetail> GetAllRoomDetail();

	void UpdateRoomDetailByID(int id, CinemaRoomDetail roomDatail);

	void DeleteRoomDetailById(int id);

	void InsertRoomDetail(CinemaRoomDetail roomDatail);

}
