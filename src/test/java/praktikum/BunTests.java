package praktikum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Класс Bun - модель булочки для бургера")
public class BunTests {


    @DisplayName("Конструктор должен корректно устанавливать значения полей")
    @ParameterizedTest
    @CsvSource({
            "black bun, 100",  // нормальные значения
            "white bun, 200", // другие нормальные значения
            "test Bun, 0",                    // нулевая цена
            "Булка, 99.01"                    // дробная цена
    })
    void testBunConstructorGetters(String name, float price) {
        Bun bun = new Bun(name, price);

        assertEquals(name, bun.getName(), "Название булочки должно совпадать");
        assertEquals(price, bun.getPrice(), "Цена булочки должна совпадать");
    }


    @Test
    @DisplayName("Мок объекта Bun должен возвращать стаб значения")
    void mock_MustReturnStubValues() {
        Bun mockBun = mock(Bun.class);

        when(mockBun.getName()).thenReturn("Булочка с моком");
        when(mockBun.getPrice()).thenReturn(250f);

        String actualName = mockBun.getName();
        float actualPrice = mockBun.getPrice();

        assertEquals("Булочка с моком", actualName);
        assertEquals(250f, actualPrice);

    }


}
