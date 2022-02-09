import org.testng.annotations.Test;

public class FormTest {

    @Test
    public void checkNewForm() {
        Form form1 = new Form.FormBuilder().setFirstName("Anna")
                .setLastName("Kowal")
                .setEmail("aaa@kowal.com")
                .setMobile("123333")
                .setCity("Wroclaw")
                .setCountry("Polska")
                .setMessage("test message")
                .build();
        System.out.println(form1.toString());
        System.out.println(form1.getFirstName());
    }
}
