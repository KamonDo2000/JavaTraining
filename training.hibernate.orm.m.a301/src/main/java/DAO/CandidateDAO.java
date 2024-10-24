package DAO;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entities.Candidate;
import entities.EntryTest;
import entities.Interview;
import ultil.HibernateUltil;

public class CandidateDAO {

	private static final SessionFactory factory = HibernateUltil.getSessionFactory();

	public static void insertEntryTest(EntryTest entryTest) {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			session.saveOrUpdate(entryTest);
			transaction.commit();
			System.out.println("Saved successfully!");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			System.err.println("Failed to save EntryTest: " + e.getMessage());
		} finally {
			session.close();
		}
	}

	public static void insertInterview(Interview interview) {
		Session session = factory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			session.saveOrUpdate(interview);
			transaction.commit();
			System.out.println("Saved successfully!");
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			System.err.println("Failed to save Interview: " + e.getMessage());
		} finally {
			session.close();
		}
	}

	public static List<Candidate> findCandidateBySkillAndLevel(String skill, int level) {
		Session session = factory.openSession();

		String hql = "SELECT c FROM Candidate c WHERE skill = '" + skill + "' AND level = " + level;
		List<Candidate> list = session.createQuery(hql, Candidate.class).list();

		session.close();
		return list;
	}

	public static List<Candidate> findCandidateByLanguageAndSkill(String language, String skill) {
		Session session = factory.openSession();
		try {
			String hql = "SELECT c FROM Candidate c WHERE c.foreignLanguage = '" + language + "' AND c.skill = '"
					+ skill + "'";

			return session.createQuery(hql, Candidate.class).list();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Object[]> findCandidateBySkillAndPassTest(String skill, String date) {
		Session session = factory.openSession();
		try {
			String hql = "SELECT c.fullName, c.gender, et.technicalResult FROM Candidate c JOIN c.entryTests et WHERE c.skill = :skill AND et.date = :date AND et.result = 'pass'";

			Query<Object[]> query = session.createQuery(hql);
			query.setParameter("skill", skill);
			query.setParameter("date", date);

			List<Object[]> list = query.list();
			return list;
		} finally {
			session.close();
		}
	}

	public static List<Candidate> findCandidatePassInterview(LocalDate date) {
		Session session = factory.openSession();
		try {
			String jpql = "SELECT c FROM Candidate c JOIN c.interviews i WHERE i.date = :interviewDate AND i.interviewResult = 'pass'";
			Query<Candidate> query = session.createQuery(jpql, Candidate.class);
			query.setParameter("interviewDate", date);
			return query.getResultList();
		} finally {
			session.close();
		}
	}

	public static List<Candidate> getListCandidate() {
		Session session = factory.openSession();

		String hql = "FROM Candidate";
		List<Candidate> candidates = session.createQuery(hql, Candidate.class).list();

		session.close();
		return candidates;
	}

	public static List<Candidate> pagingOperation(int pageNum, int pageSize) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		String hql = "FROM Candidate";

		int firstResult = (pageNum - 1) * pageSize;

		List<Candidate> candidates = session.createQuery(hql, Candidate.class).setFirstResult(firstResult)
				.setMaxResults(pageSize).getResultList();

		transaction.commit();
		session.close();
		return candidates;
	}

	public static void updateRemark(Candidate candidate) {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(candidate);
		transaction.commit();
		System.out.println("update success");
		session.close();
	}
}
