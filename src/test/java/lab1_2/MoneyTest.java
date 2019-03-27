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
    public void shouldThrownIllegalArgumentExceptionWhenCurrencyMismatchInAdd() {
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

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrownIllegalArgumentExceptionWhenCurrencyMismatchInSubtract() {
        Money money = new Money(100);
        Money sub = new Money(300, Currency.getInstance("USD"));
        money.subtract(sub);
    }

    @Test
    public void currencyCodeTest() {
        Money usdMoney = new Money(300, Currency.getInstance("USD"));
        String usdCode = "USD";
        assertThat(usdMoney.getCurrencyCode(), equalTo(usdCode));
    }

    @Test
    public void shouldReturnTrueIfMoneyIsGreaterInGreaterThanMethod() {
        Money more = new Money(300);
        Money less = new Money(100);

        assertThat(more.greaterThan(less), equalTo(true));
    }

    @Test
    public void shouldReturnFalseIfMoneyIsGreaterInnGreaterThanMethod() {
        Money more = new Money(300);
        Money less = new Money(100);

        assertThat(less.greaterThan(more), equalTo(false));
    }

    @Test
    public void shouldReturnTruefMoneyIsLessInnLessThanMethod() {
        Money more = new Money(300);
        Money less = new Money(100);

        assertThat(less.lessThan(more), equalTo(true));
    }

    @Test
    public void shouldReturnFalsefMoneyIsLessInnLessThanMethod() {
        Money more = new Money(300);
        Money less = new Money(100);

        assertThat(more.lessThan(less), equalTo(false));
    }

    @Test
    public void shouldReturnFalsefMoneyIsGreaterInnLessOrEqualsThanMethod() {
        Money more = new Money(300);
        Money less = new Money(100);

        assertThat(more.lessOrEquals(less), equalTo(false));
    }

    @Test
    public void shouldReturnTruefMoneyIsLessInnOrEqualsThanMethod() {
        Money more = new Money(300);
        Money less = new Money(100);

        assertThat(less.lessOrEquals(more), equalTo(true));
    }

    @Test
    public void shouldReturnTruefMoneyIsEqualInnOrEqualsThanMethod() {
        Money more = new Money(100);
        Money less = new Money(100);

        assertThat(more.lessOrEquals(less), equalTo(true));
    }

}
