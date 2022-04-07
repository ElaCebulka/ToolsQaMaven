package pages.components;

public class RegistrationForm {
    String firstName;
    public String lastName;
    public String email;
    public String mobile;
    public String city;
    public String country;
    public String message;

    public RegistrationForm(String firstName, String lastName, String email, String mobile, String country, String city, String message){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.mobile=mobile;
        this.country=country;
        this.city=city;
        this.message=message;
    }

    public RegistrationForm() {
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public String getMobile(){
        return mobile;
    }

    public String getCountry(){
        return country;
    }

    public String getCity(){
        return city;
    }

    public String getMessage(){
        return message;
    }
@Override
    public String toString() {
        return "Form: firstName: " + this.firstName + ", lastName: " + this.lastName+ ", email: " +this.email + ", mobile: " + this.mobile + ", city: " + this.city +", country: " + this.country + ", message: " + this.message;
}
    public static class FormBuilder{
        String firstName;
        String lastName;
        String email;
        String mobile;
        String country;
        String city;
        String message;

        public FormBuilder() {
        }
        public FormBuilder setFirstName(String firstName) {
            this.firstName=firstName;
            return this;
        }
        public FormBuilder setLastName(String lastName) {
            this.lastName=lastName;
            return this;
        }
        public FormBuilder setEmail(String email) {
            this.email=email;
            return this;
        }
        public FormBuilder setMobile(String mobile) {
            this.mobile=mobile;
            return this;
        }
        public FormBuilder setCountry(String country) {
            this.country=country;
            return this;
        }
        public FormBuilder setCity(String city) {
            this.city=city;
            return this;
        }
        public FormBuilder setMessage(String message) {
            this.message=message;
            return this;
        }

        public RegistrationForm build() {
            RegistrationForm form = new RegistrationForm();
            form.firstName = this.firstName;
            form.lastName = this.lastName;
            form.email = this.email;
            form.mobile = this.mobile;
            form.country = this.country;
            form.city = this.city;
            form.message = this.message;
            return form;
        }

    }

}
