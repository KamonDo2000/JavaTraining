package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.Employee;
import ultil.HibernateUltil;

public class EmpDaoImpl implements EmpDao {

	static final SessionFactory factory = HibernateUltil.getSessionFactory();

	@Override
	public void save(Employee e) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();

			session.save(e);

			transaction.commit();

		} catch (Exception ex) {
			System.err.println(ex);
			System.out.println(e.getId());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void saveList(List<Employee> e) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();

			for (Employee emp : e) {
				session.save(emp);
			}

			transaction.commit();
			System.out.println("DONE!!");

		} catch (Exception ex) {
			System.err.println(ex);
			System.out.println("ERROR!!");
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Override
	public void delete(int id) {
		Session session = null;
		Transaction transaction = null;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();

			Employee employee = session.get(Employee.class, id);
			if (employee != null) {
				session.delete(employee);
			}

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = null;
		Session session = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			employees = session.createQuery("FROM Employee", Employee.class).list();

			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return employees;
	}

}
