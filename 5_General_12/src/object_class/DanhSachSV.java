package object_class;

import java.util.ArrayList;
import java.util.List;

public class DanhSachSV {

	private List<SinhVien> listSV;

	public DanhSachSV() {
		this.listSV = new ArrayList<>();
	}

	public DanhSachSV(List<SinhVien> listSV) {
		super();
		this.listSV = listSV;
	}

	public void addSV(SinhVien sv) {
		this.listSV.add(sv);
	}

	public List<SinhVien> getListSV() {
		return this.listSV;
	}

	public void clearList() {
		this.listSV.clear();
	}

}
