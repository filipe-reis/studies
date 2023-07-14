package exercises.permutations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class PermutationsTest {

    private  Permutations permutations;

    @BeforeEach
    public void setUp(){
        this.permutations = new Permutations();
    }

    @Test
    public void shouldPermute(){
        var expected = buildExpectation();

        int[] nums = {1, 2, 3};
        var response = permutations.permute(nums);

        Assertions.assertEquals(expected, response);

    }

    private List<List<Integer>> buildExpectation() {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> expected = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        expected.add(temp);

        temp = new ArrayList<>();
        temp.add(1);
        temp.add(3);
        temp.add(2);
        expected.add(temp);

        temp = new ArrayList<>();
        temp.add(2);
        temp.add(1);
        temp.add(3);
        expected.add(temp);

        temp = new ArrayList<>();
        temp.add(2);
        temp.add(3);
        temp.add(1);
        expected.add(temp);

        temp = new ArrayList<>();
        temp.add(3);
        temp.add(1);
        temp.add(2);
        expected.add(temp);

        temp = new ArrayList<>();
        temp.add(3);
        temp.add(2);
        temp.add(1);
        expected.add(temp);

        return expected;
    }
}