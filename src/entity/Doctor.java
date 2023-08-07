package entity;

public class Doctor {
    private String did;
    private String name;
    private String address;
    private String contact;

    public Doctor() {
    }

    public Doctor(String did, String name, String address, String contact) {
        this.did = did;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
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
