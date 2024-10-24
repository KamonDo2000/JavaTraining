package DAO;

import java.util.List;

import entities.Type;

public interface typeDAO {
	Type GetTypeByID(int id);

	List<Type> GetAllType();

	void UpdateTypeByID(int id, Type room);

	void DeleteTypeById(int id);

	void InsertType(Type room);
}
