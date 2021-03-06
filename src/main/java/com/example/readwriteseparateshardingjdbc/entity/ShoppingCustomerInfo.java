package com.example.readwriteseparateshardingjdbc.entity;

import java.sql.Timestamp;
import java.util.Objects;

public class ShoppingCustomerInfo {
    private Long id;
    private String name;
    private String certid;
    private String gender;
    private String phone;
    private String address;
    private String photourl;
    private String status;
    private Timestamp inputdate;
    private Timestamp updatedate;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertid() {
        return certid;
    }

    public void setCertid(String certid) {
        this.certid = certid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getInputdate() {
        return inputdate;
    }

    public void setInputdate(Timestamp inputdate) {
        this.inputdate = inputdate;
    }

    public Timestamp getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Timestamp updatedate) {
        this.updatedate = updatedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCustomerInfo that = (ShoppingCustomerInfo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(certid, that.certid) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(address, that.address) &&
                Objects.equals(photourl, that.photourl) &&
                Objects.equals(status, that.status) &&
                Objects.equals(inputdate, that.inputdate) &&
                Objects.equals(updatedate, that.updatedate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name,certid, gender, phone, address, photourl, status, inputdate, updatedate);
    }

	@Override
	public String toString() {
		return "ShoppingCustomerInfo [id=" + id + ", name=" + name+ ", certid=" + certid
				+ ", gender=" + gender + ", phone=" + phone + ", address="
				+ address + ", photourl=" + photourl + ", status=" + status
				+ ", inputdate=" + inputdate + ", updatedate=" + updatedate
				+ "]";
	}
    
    
}
