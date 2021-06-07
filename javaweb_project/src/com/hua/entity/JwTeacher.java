package com.hua.entity;

public class JwTeacher {

	private String teacherId;  //教师编号
	
	private String teacherName;  //教师姓名
	
	private String gender;  //性别
	
	private String politicstatus;  //政治面貌
	
	private String nation;  //民族

	private String academy;  //学院

	private String nativeplace;   //籍贯
	
	private String qq;   //联系电话
	
	private String phone;   //联系电话
	
	private String address;  //家庭地址	
	
	private String email;  //邮件地址

	public JwTeacher() {
		super();
	}

	public JwTeacher(String teacherId, String teacherName, String gender,
			String politicstatus, String nation, String academy,
			String nativeplace, String qq, String phone,
			String address, String email) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.gender = gender;
		this.politicstatus = politicstatus;
		this.nation = nation;
		this.academy = academy;
		this.nativeplace = nativeplace;
		this.qq = qq;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPoliticstatus() {
		return politicstatus;
	}

	public void setPoliticstatus(String politicstatus) {
		this.politicstatus = politicstatus;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getAcademy() {
		return academy;
	}

	public void setAcademy(String academy) {
		this.academy = academy;
	}

	public String getNativeplace() {
		return nativeplace;
	}
	
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName="
				+ teacherName + ", gender=" + gender + ", politicstatus="
				+ politicstatus + ", nation=" + nation + ", academy=" + academy
				+ ", nativeplace=" + nativeplace
				+ ", qq=" + qq + ", phone=" + phone + ", address=" + address + ", email="
				+ email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((academy == null) ? 0 : academy.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((nation == null) ? 0 : nation.hashCode());
		result = prime * result + ((qq == null) ? 0 : qq.hashCode());
		result = prime * result
				+ ((nativeplace == null) ? 0 : nativeplace.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result
				+ ((politicstatus == null) ? 0 : politicstatus.hashCode());
		result = prime * result
				+ ((teacherId == null) ? 0 : teacherId.hashCode());
		result = prime * result
				+ ((teacherName == null) ? 0 : teacherName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JwTeacher other = (JwTeacher) obj;
		if (academy == null) {
			if (other.academy != null)
				return false;
		} else if (!academy.equals(other.academy))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (nation == null) {
			if (other.nation != null)
				return false;
		} else if (!nation.equals(other.nation))
			return false;
		if (nativeplace == null) {
			if (other.nativeplace != null)
				return false;
		} else if (!nativeplace.equals(other.nativeplace))
			return false;
		if (qq == null) {
			if (other.qq != null)
				return false;
		} else if (!qq.equals(other.qq))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (politicstatus == null) {
			if (other.politicstatus != null)
				return false;
		} else if (!politicstatus.equals(other.politicstatus))
			return false;
		if (teacherId == null) {
			if (other.teacherId != null)
				return false;
		} else if (!teacherId.equals(other.teacherId))
			return false;
		if (teacherName == null) {
			if (other.teacherName != null)
				return false;
		} else if (!teacherName.equals(other.teacherName))
			return false;
		return true;
	}

	
	
	

}
