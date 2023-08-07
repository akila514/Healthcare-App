package entity;

public class Patient {
    private String pid;
    private String name;
    private String address;
    private String contact;

    public Patient() {

    }

    public Patient(String did, String name, String address, String contact) {
        this.pid = did;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String did) {
        this.pid = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
