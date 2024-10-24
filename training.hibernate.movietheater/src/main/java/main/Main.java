package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import DAO.RoomDaoImpl;
import DAO.RoomDetailDaoImpl;
import DAO.SetDaoImpl;
import entities.CinemaRoom;
import entities.CinemaRoomDetail;
import entities.Seat;

public class Main {

	static SetDaoImpl sdao = new SetDaoImpl();
	static RoomDaoImpl rdao = new RoomDaoImpl();
	static RoomDetailDaoImpl rddao = new RoomDetailDaoImpl();

	static java.sql.Date activeDate = java.sql.Date.valueOf("2000-10-24");

	public static void main(String[] args) {

		CinemaRoom room1 = new CinemaRoom(1, "Cinema Room 1", 100);
		CinemaRoom room2 = new CinemaRoom(2, "Cinema Room 2", 100);
		CinemaRoom room3 = new CinemaRoom(3, "Cinema Room 3", 100);
		CinemaRoom room4 = new CinemaRoom(4, "Cinema Room 4", 100);
		CinemaRoom room5 = new CinemaRoom(5, "Cinema Room 5", 100);

		ArrayList<CinemaRoom> cinemaRooms = new ArrayList<>(Arrays.asList(room1, room2, room3, room4, room5));

		List<Seat> seats = new ArrayList<>(Arrays.asList(new Seat(1, "ASD", 12, "available", "regular", room4),
				new Seat(2, "BCD", 13, "available", "regular", room1),
				new Seat(3, "EFG", 14, "available", "regular", room5),
				new Seat(4, "HIJ", 15, "available", "regular", room5),
				new Seat(5, "KLM", 16, "available", "regular", room3)));

		List<CinemaRoomDetail> cinemaRoomDetails = new ArrayList<>(
				Arrays.asList(new CinemaRoomDetail(1, 80, activeDate, "Phòng chiếu thường", room3),
						new CinemaRoomDetail(2, 75, activeDate, "Phòng chiếu VIP", room1),
						new CinemaRoomDetail(3, 90, activeDate, "Phòng chiếu gia đình", room4),
						new CinemaRoomDetail(4, 60, activeDate, "Phòng chiếu sinh viên", room2),
						new CinemaRoomDetail(5, 100, activeDate, "Phòng chiếu đặc biệt", room5)));
		System.out.println("\n\n");

		// Run function

//		insert

		for (CinemaRoom e : cinemaRooms) {
			rdao.InsertRoom(e);
		}
		for (Seat e : seats) {
			sdao.InsertSet(e);
		}
		for (CinemaRoomDetail e : cinemaRoomDetails) {
			rddao.InsertRoomDetail(e);
		}

//		Get
//		System.out.println(rdao.GetRoomByID(2).toString());
//		System.out.println(rddao.GetRoomDetailByID(4).toString());
//		System.out.println(sdao.GetSetByID(1).toString());

//		GetList
//		rdao.GetAllRoom().forEach(e -> {
//			System.out.println(e.toString());
//		});
//
//		System.out.println("\n\n");
//		rddao.GetAllRoomDetail().forEach(e -> {
//			System.out.println(e.toString());
//		});
//
//		System.out.println("\n\n");
//		sdao.GetAllSet().forEach(e -> {
//			System.out.println(e.toString());
//		});

//		update

//		CinemaRoom roomup = new CinemaRoom(4, "Cinema Update", 213523); 
//		rdao.UpdateRoomByID(4, roomup);  	// update parent
//
//		CinemaRoomDetail roomDetail = new CinemaRoomDetail(2, 7342, activeDate, "Update helo34 room", room2);
//		rddao.UpdateRoomDetailByID(2, roomDetail); //update partner relation One To One
//
//		Seat seat = new Seat(2, "update", 13, "vip", "hhihihi", room4);
//		sdao.UpdateSetByID(2, seat);

//		Delete

		rddao.DeleteRoomDetailById(5);
		
		sdao.DeleteSetById(3);
		sdao.DeleteSetById(4);
	
		rdao.DeleteRoomById(5);
	}
}
