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

    @Test
    public void shouldReturnAddedValue() {
        Money money = new Money(100);
        Money addValue = new Money(300);

        Money result = money.add(addValue);
        assertThat(new Money(400), equalTo(result));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrownIllegalArgumentExceptionWhenCurrencyMismatch() {
        Money money = new Money(100);
        Money addValue = new Money(300, Currency.getInstance("USD"));
        money.add(addValue);
    }

    @Test
    public void shouldReturnSubtractedValue() {
        Money money = new Money(300);
        Money sub = new Money(100);

        Money result = money.subtract(sub);
        assertThat(new Money(200), equalTo(result));
    }

}
