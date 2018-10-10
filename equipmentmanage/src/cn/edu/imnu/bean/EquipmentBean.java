package cn.edu.imnu.bean;

public class EquipmentBean {
	private String equipment_name, equipment_id, equipment_type, equipment_img, major,place_id, equipment_place ,user_id,count;
	private int id;

	public String getEquipment_id() {
		return equipment_id;
	}

	public void setEquipment_id(String equipment_id) {
		this.equipment_id = equipment_id;
	}

	public String getEquipment_type() {
		return equipment_type;
	}

	public void setEquipment_type(String equipment_type) {
		this.equipment_type = equipment_type;
	}

	public String getEquipment_img() {
		return equipment_img;
	}

	public void setEquipment_img(String equipment_img) {
		this.equipment_img = equipment_img;
	}

	public String getEquipment_name() {
		return equipment_name;
	}

	public void setEquipment_name(String equipment_name) {
		this.equipment_name = equipment_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getPlace_id() {
		return place_id;
	}

	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}

	public String getEquipment_place() {
		return equipment_place;
	}

	public void setEquipment_place(String equipment_place) {
		this.equipment_place = equipment_place;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
}
