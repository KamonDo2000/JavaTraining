package index;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import controler.InputCandidateControl;
import controler.ShowCandidateControl;
import model.Candidate;
import service.ConcurUpdate;
import service.InsertData;
import service.ObjCandidateInData;
import service.SelectData;
import view.MainMenu;

public class Main {

	public static void main(String[] args) {
		Connection conn = null;

		try {
			// Tao ket noi
			conn = DButil.connectDB();
			List<Candidate> listCandidate = new ArrayList<>(SelectData.selectData(conn));
			System.out.println("----Manager Candidate Application------");

			do {
				int choose = MainMenu.menu();

				switch (choose) {
				case 1:
					InsertData.insertCandidate(conn, InputCandidateControl.input(conn));
					continue;

				case 2:
					ShowCandidateControl.show(listCandidate);
					continue;

				case 3:
					ShowCandidateControl.showCountCandidate(listCandidate);
					continue;

				case 4:
					ShowCandidateControl.showFullName(listCandidate);
					continue;
				case 5:
					ConcurUpdate.updateConcur(ObjCandidateInData.input(conn), conn);
					continue;

				case 0:
					System.err.println("\n========================== Exits Program ==========================");
					return;
				default:
					continue;
				}
			} while (true);
		} finally {
			DButil.close(conn);
		}
	}

}
