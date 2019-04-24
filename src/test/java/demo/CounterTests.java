package demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterTests {

    private Counter counter;

    @BeforeEach
    public void setUp() {
        counter = new Counter();
    }

    @ParameterizedTest(name = "Counter should countChars {0}: {1}")
    @MethodSource("parameters")
    public void shouldCountChars(String text, Integer expectedCount) {
        assertEquals(expectedCount, counter.countChars(text));
    }

    // Note: Can use `List`, but `Stream` is preferred by official
    private static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("Hello", 5),
                Arguments.of("OK", 2)
        );
    }

}
