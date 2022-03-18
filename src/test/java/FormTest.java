import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormTest {

    @Test
    public void checkNewFormBulider() {
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

    @Test
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void checkDifferentFormsCsvFile(ArgumentsAccessor argumentsAccessor) {
        Form form = new Form();
        form.firstName = argumentsAccessor.getString(0);
        form.lastName = argumentsAccessor.getString(1);
        form.email = argumentsAccessor.getString(2);
        form.mobile = argumentsAccessor.getString(3);
        form.city = argumentsAccessor.getString(4);
        form.country = argumentsAccessor.getString(5);
        form.message = argumentsAccessor.getString(6);
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

        List<Object> expected = argumentsAccessor.toList();

        Assertions.assertThat(expected).containsExactlyElementsOf(result);
    }

}
