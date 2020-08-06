package collegeapp.models;

public class College {
	private int collegeID;
	private String collegeName;
	private String courseType;
	private String city;
	private double fees;
	private int pincode;

	public int getCollegeID() {
		return collegeID;
	}

	public void setCollegeID(int collegeID) {
		this.collegeID = collegeID;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "College [city=" + city + ", collegeID=" + collegeID + ", collegeName=" + collegeName + ", courseType="
				+ courseType + ", fees=" + fees + ", pincode=" + pincode + "]";
	}
}
