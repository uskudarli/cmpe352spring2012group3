package Tables;

public class Users {
 private String email;
 private int id;
 private String password_hash;
 private String name;
 private String birth_date;
 private String register_Date;
public Users(String email, String name, String password_hash,String birth_date,
		String register_Date) {
	super();
	this.email = email;
	this.name = name;
	this.password_hash=password_hash;
	this.birth_date = birth_date;
	this.register_Date = register_Date;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword_hash() {
	return password_hash;
}
public void setPassword_hash(String password_hash) {
	this.password_hash = password_hash;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBirth_date() {
	return birth_date;
}
public void setBirth_date(String birth_date) {
	this.birth_date = birth_date;
}
public String getRegister_Date() {
	return register_Date;
}
public void setRegister_Date(String register_Date) {
	this.register_Date = register_Date;
}
}
