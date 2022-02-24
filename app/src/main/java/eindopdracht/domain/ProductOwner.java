package eindopdracht.domain;

/**
 * ProductOwner
 */
public class ProductOwner {

    private String name;
    private String phoneNumber;

    public ProductOwner(String name, String phoneNumber){
        setName(name);
        setPhoneNumber(phoneNumber);
    }

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setName(String name) {
		this.name = name;
	}
    

}