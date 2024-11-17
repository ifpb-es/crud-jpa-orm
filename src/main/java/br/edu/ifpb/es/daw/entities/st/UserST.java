package br.edu.ifpb.es.daw.entities.st;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "USERS")
@SecondaryTables({
		@SecondaryTable(name = "ST_ADDRESSES",
						pkJoinColumns = { @PrimaryKeyJoinColumn(name = "ID_USER") },
						foreignKey = @ForeignKey(name = "FK__TB_ADDRESS_ST__TB_USER"))
})
public class UserST {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "BIRTHDAY")
	private LocalDate birthday;

	@Column(table = "ST_ADDRESSES")
	private String street;

	@Column(table = "ST_ADDRESSES")
	private String city;

	@Column(table = "ST_ADDRESSES")
	private String state;

	@Column(table = "ST_ADDRESSES")
	private String zipcode;

	@Column(table = "ST_ADDRESSES")
	private String country;

	public UserST() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthDate) {
		this.birthday = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UserST)) return false;
		UserST userST = (UserST) o;
		return Objects.equals(firstName, userST.firstName) &&
				Objects.equals(lastName, userST.lastName) &&
				Objects.equals(email, userST.email) &&
				Objects.equals(birthday, userST.birthday) &&
				Objects.equals(street, userST.street) &&
				Objects.equals(city, userST.city) &&
				Objects.equals(state, userST.state) &&
				Objects.equals(zipcode, userST.zipcode) &&
				Objects.equals(country, userST.country);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, email, birthday, street, city, state, zipcode, country);
	}

	@Override
	public String toString() {
		return "UserST{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", birthday=" + birthday +
				", street='" + street + '\'' +
				", city='" + city + '\'' +
				", state='" + state + '\'' +
				", zipcode='" + zipcode + '\'' +
				", country='" + country + '\'' +
				'}';
	}

}
