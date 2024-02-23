package bankguru.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import bankguru.GlobalConstants;

public class UserDataMapper {

	public static UserDataMapper getUserData() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(new File(GlobalConstants.getGlobalConstants().getProjectPath() + "/resource/UserData.json"), UserDataMapper.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@JsonProperty("firstName")
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("emailAddress")
	private String emailAddress;

	@JsonProperty("password")
	private String password;

	@JsonProperty("day")
	private String day;

	@JsonProperty("month")
	private String month;

	@JsonProperty("year")
	private String year;

	@JsonProperty("login")
	private Login login;

	@JsonProperty("country")
	private String country;

	@JsonProperty("city")
	private String city;

	@JsonProperty("address")
	private String address;

	@JsonProperty("pin")
	private String pin;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("state")
	private String state;

	@JsonProperty("customerid")
	private String customerid;

	static class Login {
		@JsonProperty("username")
		private String username;

		@JsonProperty("password")
		private String password;
	}

	public String getLoginUsername() {
		return login.username;
	}

	public String getLoginPassword() {
		return login.password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public String getDay() {
		return day;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getAddress() {
		return address;
	}

	public String getPIN() {
		return pin;
	}

	public String getPhone() {
		return phone;
	}

	public String getState() {
		return state;
	}

	public String getCustomerID() {
		return customerid;
	}

}
