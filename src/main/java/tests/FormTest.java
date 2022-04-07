package tests;

import static org.assertj.core.api.Assertions.*;
import org.testng.annotations.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.components.RegistrationForm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FormTest {

    @Test
    public void checkNewFormBuilder() {
        List<String> expectedResultList = Arrays.asList("Anna", "Kowal", "aaa@kowal.com", "123333", "Wroclaw","Polska", "test message");
        RegistrationForm form = new RegistrationForm.FormBuilder().setFirstName("Anna")
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

        assertThat(result).containsExactlyElementsOf(expectedResultList);

    }

    @Test
    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void checkDifferentFormsCsvFile(ArgumentsAccessor argumentsAccessor) {
        RegistrationForm form = new RegistrationForm.FormBuilder().setFirstName(argumentsAccessor.getString(0)) //= argumentsAccessor.getString(0);
                .setLastName(argumentsAccessor.getString(1))
                .setEmail(argumentsAccessor.getString(2))
                .setMobile(argumentsAccessor.getString(3))
                .setCity(argumentsAccessor.getString(4))
                .setCountry(argumentsAccessor.getString(5))
                .setMessage(argumentsAccessor.getString(6))
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

        List<Object> expected = argumentsAccessor.toList();

        assertThat(expected).containsExactlyElementsOf(result);
    }

}
