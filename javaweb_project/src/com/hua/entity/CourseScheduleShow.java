package com.hua.entity;

public class CourseScheduleShow {
	private String joint; //µÚ¼¸½Ú
	
	private CourseSchedule monday;    
	
	private CourseSchedule tuesday;   
	
	private CourseSchedule wesneday;   
	
	private CourseSchedule thursday;  
	
	private CourseSchedule friday;  
	
	private CourseSchedule saturday;   
	
	private CourseSchedule sunday;

	public CourseScheduleShow() {
		super();
	}

	

	public CourseScheduleShow(String joint, CourseSchedule monday,
			CourseSchedule tuesday, CourseSchedule wesneday,
			CourseSchedule thursday, CourseSchedule friday,
			CourseSchedule saturday, CourseSchedule sunday) {
		super();
		this.joint = joint;
		this.monday = monday;
		this.tuesday = tuesday;
		this.wesneday = wesneday;
		this.thursday = thursday;
		this.friday = friday;
		this.saturday = saturday;
		this.sunday = sunday;
	}



	public String getJoint() {
		return joint;
	}

	public void setJoint(String joint) {
		this.joint = joint;
	}

	public CourseSchedule getMonday() {
		return monday;
	}

	public void setMonday(CourseSchedule monday) {
		this.monday = monday;
	}

	public CourseSchedule getTuesday() {
		return tuesday;
	}

	public void setTuesday(CourseSchedule tuesday) {
		this.tuesday = tuesday;
	}

	public CourseSchedule getWesneday() {
		return wesneday;
	}

	public void setWesneday(CourseSchedule wesneday) {
		this.wesneday = wesneday;
	}

	public CourseSchedule getThursday() {
		return thursday;
	}

	public void setThursday(CourseSchedule thursday) {
		this.thursday = thursday;
	}

	public CourseSchedule getFriday() {
		return friday;
	}

	public void setFriday(CourseSchedule friday) {
		this.friday = friday;
	}

	public CourseSchedule getSaturday() {
		return saturday;
	}

	public void setSaturday(CourseSchedule saturday) {
		this.saturday = saturday;
	}

	public CourseSchedule getSunday() {
		return sunday;
	}

	public void setSunday(CourseSchedule sunday) {
		this.sunday = sunday;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((friday == null) ? 0 : friday.hashCode());
		result = prime * result + ((monday == null) ? 0 : monday.hashCode());
		result = prime * result
				+ ((saturday == null) ? 0 : saturday.hashCode());
		result = prime * result + ((sunday == null) ? 0 : sunday.hashCode());
		result = prime * result
				+ ((thursday == null) ? 0 : thursday.hashCode());
		result = prime * result + ((tuesday == null) ? 0 : tuesday.hashCode());
		result = prime * result
				+ ((wesneday == null) ? 0 : wesneday.hashCode());
		result = prime * result + ((joint == null) ? 0 : joint.hashCode());
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
		CourseScheduleShow other = (CourseScheduleShow) obj;
		if (friday == null) {
			if (other.friday != null)
				return false;
		} else if (!friday.equals(other.friday))
			return false;
		if (monday == null) {
			if (other.monday != null)
				return false;
		} else if (!monday.equals(other.monday))
			return false;
		if (saturday == null) {
			if (other.saturday != null)
				return false;
		} else if (!saturday.equals(other.saturday))
			return false;
		if (sunday == null) {
			if (other.sunday != null)
				return false;
		} else if (!sunday.equals(other.sunday))
			return false;
		if (thursday == null) {
			if (other.thursday != null)
				return false;
		} else if (!thursday.equals(other.thursday))
			return false;
		if (tuesday == null) {
			if (other.tuesday != null)
				return false;
		} else if (!tuesday.equals(other.tuesday))
			return false;
		if (wesneday == null) {
			if (other.wesneday != null)
				return false;
		} else if (!wesneday.equals(other.wesneday))
			return false;
		if (joint == null) {
			if (other.joint != null)
				return false;
		} else if (!joint.equals(other.joint))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CourseScheduleShow [joint=" + joint + ", Monday=" + monday
				+ ", Tuesday=" + tuesday + ", Wesneday=" + wesneday
				+ ", Thursday=" + thursday + ", Friday=" + friday
				+ ", Saturday=" + saturday + ", Sunday=" + sunday + "]";
	}

	
	
}
