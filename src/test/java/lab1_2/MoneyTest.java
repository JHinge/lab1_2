package lab1_2;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class MoneyTest {

    @Test
    public void shouldReturnValueMultiplied() {
        Money money = new Money(100);
        double multiplier = 3;
        Money shouldBe = new Money(300);

        Money result = money.multiplyBy(multiplier);
        assertThat(shouldBe, equalTo(result));
    }

}
