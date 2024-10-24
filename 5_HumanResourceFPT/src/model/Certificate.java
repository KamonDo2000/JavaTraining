package model;

import java.time.LocalDate;

public class Certificate {
	private String certificatedID;
	private String certificateName;
	private String certificateRank;
	private LocalDate certificatedDate;

	public Certificate() {
	}

	public Certificate(String certificatedID, String certificateName, String certificateRank,
			LocalDate certificatedDate) {
		super();
		this.certificatedID = certificatedID;
		this.certificateName = certificateName;
		this.certificateRank = certificateRank;
		this.certificatedDate = certificatedDate;
	}

	/**
	 * @param certificatedID the certificatedID to set
	 */
	public void setCertificatedID(String certificatedID) {
		this.certificatedID = certificatedID;
	}

	/**
	 * @param certificateName the certificateName to set
	 */
	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	/**
	 * @param certificateRank the certificateRank to set
	 */
	public void setCertificateRank(String certificateRank) {
		this.certificateRank = certificateRank;
	}

	/**
	 * @param certificatedDate the certificatedDate to set
	 */
	public void setCertificatedDate(LocalDate certificatedDate) {
		this.certificatedDate = certificatedDate;
	}

	/**
	 * @return the certificatedID
	 */
	public String getCertificatedID() {
		return certificatedID;
	}

	/**
	 * @return the certificateName
	 */
	public String getCertificateName() {
		return certificateName;
	}

	/**
	 * @return the certificateRank
	 */
	public String getCertificateRank() {
		return certificateRank;
	}

	/**
	 * @return the certificatedDate
	 */
	public LocalDate getCertificatedDate() {
		return certificatedDate;
	}

}
