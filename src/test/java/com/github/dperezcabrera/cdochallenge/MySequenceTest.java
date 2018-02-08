package com.github.dperezcabrera.cdochallenge;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author David Pérez Cabrera <dperezcabrera@gmail.com>
 */
public class MySequenceTest {

    MySequence<Integer> instance = new MySequence<>();

    @Test
    public void add_demo_3() {
        Integer expectedResult = 3;
        instance.add(5);
        instance.add(3);
        instance.add(5);
        instance.add(6);

        Optional<Integer> optResult = instance.getFirstNonDuplicated();

        assertEquals(expectedResult, optResult.get());
    }

    @Test
    public void add_null() {

        assertThrows(NullPointerException.class, () -> instance.add(null));
    }

    @Test
    public void add_demo_6() {
        Integer expectedResult = 6;
        instance.add(5);
        instance.add(3);
        instance.add(5);
        instance.add(6);
        instance.add(3);

        Optional<Integer> optResult = instance.getFirstNonDuplicated();

        assertEquals(expectedResult, optResult.get());
    }

    @Test
    public void non_added_elements() {
        Optional<Integer> optResult = instance.getFirstNonDuplicated();

        assertFalse(optResult.isPresent());
    }

    @Test
    public void add_one_element_with_list_size_1() {
        Integer expectedResult = 1;
        instance.add(1);

        Optional<Integer> optResult = instance.getFirstNonDuplicated();

        assertEquals(expectedResult, optResult.get());
    }

    @Test
    public void add_two_elements_with_empty_list() {
        instance.add(1);
        instance.add(1);

        Optional<Integer> optResult = instance.getFirstNonDuplicated();

        assertFalse(optResult.isPresent());
    }

    @Test
    public void add_two_element_with_list_size_2() {
        Integer expectedResult = 1;
        instance.add(1);
        instance.add(2);

        Optional<Integer> optResult = instance.getFirstNonDuplicated();

        assertEquals(expectedResult, optResult.get());
    }

    @Test
    public void add_three_elements_with_empty_list() {
        instance.add(1);
        instance.add(1);
        instance.add(1);

        Optional<Integer> optResult = instance.getFirstNonDuplicated();

        assertFalse(optResult.isPresent());
    }

    @Test
    public void add_three_element_with_list_size_3() {
        Integer expectedResult = 1;
        instance.add(1);
        instance.add(2);
        instance.add(3);

        Optional<Integer> optResult = instance.getFirstNonDuplicated();

        assertEquals(expectedResult, optResult.get());
    }

    @Test
    public void add_three_element_with_list_size_2_return_first() {
        Integer expectedResult = 1;
        instance.add(1);
        instance.add(2);
        instance.add(2);

        Optional<Integer> optResult = instance.getFirstNonDuplicated();

        assertEquals(expectedResult, optResult.get());
    }

    @Test
    public void add_three_element_with_list_size_2_return_last() {
        Integer expectedResult = 2;
        instance.add(1);
        instance.add(2);
        instance.add(1);

        Optional<Integer> optResult = instance.getFirstNonDuplicated();

        assertEquals(expectedResult, optResult.get());
    }

    @Test
    public void add_four_element_with_list_size_2() {
        Integer expectedResult = 1;
        instance.add(1);
        instance.add(2);
        instance.add(3);
        instance.add(2);

        Optional<Integer> optResult = instance.getFirstNonDuplicated();

        assertEquals(expectedResult, optResult.get());
    }
}
