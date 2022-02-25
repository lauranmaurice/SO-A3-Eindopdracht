package eindopdracht.domain;

/**
 * ProductOwner
 */
public class ProductOwner {

    private String name;
    private String phoneNumber;
	private String email; 

    public ProductOwner(String name, String phoneNumber, String email){
        setName(name);
        setPhoneNumber(phoneNumber);
		setEmail(email);
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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