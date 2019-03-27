package lab1_2;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Currency;

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

    public void shouldReturnAddedValue() {
        Money money = new Money(100);
        Money addValue = new Money(300);

        Money result = money.add(addValue);
        assertThat(new Money(400), equalTo(result));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrownIllegalArgumentExceptionWhenCurrencyMismatch() {
        final int[] emptyTab = {};
        Money money = new Money(100);
        Money addValue = new Money(300, Currency.getInstance("USD"));
        Money result = money.add(addValue);
    }
}
