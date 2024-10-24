package zsuppose;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controler.ShowCandidateControl;
import model.Candidate;
import model.Certificate;
import model.Experience;
import model.Fresher;
import model.Intern;

/*
 * 2.	Giả sử sau khi truy vấn danh sách ứng viên từ DataBase, có những record bị trùng CandidateID. 
 * 	Học viên hãy loại bỏ đi các record thứ 2 trở đi mà đã trùng CandidateID với record trước đó 
 * (Học viên hãy sử dụng kiểu dữ liệu có cấu trúc (List, Set, Map)
 *  phù hợp trong topic Collection đã học để xử lý yêu cầu này)
 */
public class SupposeEXE {

	public static void main(String[] args) {
		List<Candidate> listCandidate = new ArrayList<>();

		Map<String, Candidate> mapCandidate = new HashMap<>();

		fakeData(listCandidate);

		for (Candidate s : listCandidate) {
			if (mapCandidate.get(s.getCandidateID()) != null) {
				continue;
			}
			mapCandidate.put(s.getCandidateID(), s);
		}

		List<Candidate> listDone = new ArrayList<>();

		for (Map.Entry<String, Candidate> entry : mapCandidate.entrySet()) {
			listDone.add(entry.getValue());
		}

		// Compare
//		listDone.sort(new Comparator<Candidate>() {
//			public int compare(Candidate obj1, Candidate obj2) {
//				if (obj1.getCandidateType() != null && obj2.getCandidateType() != null
//						&& obj1.getCandidateType().compareTo(obj2.getCandidateType()) != 0) {
//					return obj1.getCandidateType().compareTo(obj2.getCandidateType());
//				} else {
//					return obj2.getBirthDay().compareTo(obj1.getBirthDay());
//				}
//			}
//		});

		// Lamda Compare
		listDone.sort((obj1, obj2) -> {
			if (obj1.getCandidateType() != null && obj2.getCandidateType() != null
					&& obj1.getCandidateType().compareTo(obj2.getCandidateType()) != 0) {
				return obj1.getCandidateType().compareTo(obj2.getCandidateType());
			} else {
				return obj2.getBirthDay().compareTo(obj1.getBirthDay());
			}
		});

		ShowCandidateControl.show(listDone);
	}

	public static void fakeData(List<Candidate> listCandidate) {

		LocalDate date = LocalDate.now();

		List<Certificate> listCerti = new ArrayList<>();
		Certificate cer1 = new Certificate("00001", "Cong nghe phan cung", "Gioi", date);
		Certificate cer2 = new Certificate("00002", "Tester editting", "Kha", date);
		Certificate cer3 = new Certificate("00003", "halooo", "Gioi", date);
		Certificate cer4 = new Certificate("00004", "kanyi", "kha", date);
		listCerti.add(cer1);
		listCerti.add(cer2);
		listCerti.add(cer3);
		listCerti.add(cer4);

		Candidate candi1 = new Experience("00001", "Do The Gia Huy", date, "0774053798", "huydo@gmail.com", listCerti,
				3, "Java C#");
		Candidate candi2 = new Fresher("00002", "Nguyen thi thuy Ly", date, "0884052348", "huydo@gmail.com", listCerti,
				date, "Dai Hoc", "Cong nghe Thong Tin");
		Candidate candi3 = new Intern("00003", "Do Gia Huy", date, "0884052348", "huydo@gmail.com", null, "CNTT", 5,
				"DH Tai nguyen");
		Candidate candi4 = new Fresher("00002", "Nguyen thi Ly", date, "0884055681", "huyasdo@gmail.com", listCerti,
				date, "Dai Hoc", "Cong nghe Thong Tin");
		Candidate candi5 = new Fresher("00002", "Nguyen thi thuy", date, "0884051647", "huydofa@gmail.com", listCerti,
				date, "Cao dang", "Cong nghe Thong Tin");
		Candidate candi6 = new Fresher("00004", "Nguyen thi dong van", date, "0884059847", "hu235dsf@gmail.com",
				listCerti, date, "Cao dang", "Cong nghe rau");
		Candidate candi7 = new Intern("00003", "Do Gia van ", date, "0823452678", "hudf323o@gmail.com", null, "CNTT", 5,
				"DH Tai nguyen");

		listCandidate.add(candi1);
		listCandidate.add(candi2);
		listCandidate.add(candi3);
		listCandidate.add(candi4);
		listCandidate.add(candi5);
		listCandidate.add(candi6);
		listCandidate.add(candi7);
	}

}
