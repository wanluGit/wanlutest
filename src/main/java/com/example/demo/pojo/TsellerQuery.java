package com.example.demo.pojo;

/*@Data
@ToString*/
public class TsellerQuery {
    private String id;
    private String name;
    private String tel;
    private String type;
    private String district;
    private String address;
    private Integer perBegin;
    private Integer perEnd;
    private String comments;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPerBegin() {
		return perBegin;
	}
	public void setPerBegin(Integer perBegin) {
		this.perBegin = perBegin;
	}
	public Integer getPerEnd() {
		return perEnd;
	}
	public void setPerEnd(Integer perEnd) {
		this.perEnd = perEnd;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "TsellerQuery [id=" + id + ", name=" + name + ", tel=" + tel +
				", type=" + type + ", district="
				+ district + ", address=" + address +
				", perBegin=" + perBegin + ", perEnd=" + perEnd + ", comments="
				+ comments + "]";
	}

}