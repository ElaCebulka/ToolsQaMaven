import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FormTest {

    @Test
    public void checkNewForm() {
        List<String> expectedResultList = Arrays.asList("Anna", "Kowal", "aaa@kowal.com", "123333", "Wroclaw","Polska", "test message");
        Form form = new Form.FormBuilder().setFirstName("Anna")
                .setLastName("Kowal")
                .setEmail("aaa@kowal.com")
                .setMobile("123333")
                .setCity("Wroclaw")
                .setCountry("Polska")
                .setMessage("test message")
                .build();
        System.out.println(form.toString());
        List<String> result = new ArrayList<>();
        result.add(form.getFirstName());
        result.add(form.getLastName());
        result.add(form.getEmail());
        result.add(form.getMobile());
        result.add(form.getCity());
        result.add(form.getCountry());
        result.add(form.getMessage());
        System.out.println(result);

        Assertions.assertThat(result).containsExactlyElementsOf(expectedResultList);
    }
}
