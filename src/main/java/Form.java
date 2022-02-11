
public class Form {
    String firstName;
    String lastName;
    String email;
    String mobile;
    String city;
    String country;
    String message;

    public Form(String firstName, String lastName, String email, String mobile, String country, String city, String message){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.mobile=mobile;
        this.country=country;
        this.city=city;
        this.message=message;
    }

    public Form() {
    }

    public String getFirstName(){
        this.firstName = firstName;
        return firstName;
    }

    public String getLastName(){
        this.lastName = lastName;
        return lastName;
    }

    public String getEmail(){
        this.email = email;
        return email;
    }

    public String getMobile(){
        this.mobile= mobile;
        return mobile;
    }

    public String getCountry(){
        this.country = country;
        return country;
    }

    public String getCity(){
        this.city = city;
        return city;
    }

    public String getMessage(){
        this.message = message;
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

        FormBuilder() {
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

        public Form build() {
            Form form = new Form();
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
