package Models;

public class AddStaffForm {

    private String fullName;
    private String birthDate;
    private String position;
    private String gender;
    private String mobileNumber;
    private String username;
    private String password;
    private String confirmPassword;
    private String address;

    public AddStaffForm() {

    }

    public AddStaffForm(String fullName, String gender,  String birthDate, String mobileNumber,String position, String username, String password, String confirmPassword, String address) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.position = position;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
