package exercises.subsets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SubsetsTest {

    private Subsets subsetsIterative;
    private SubsetsRecursiveSolution subsetsRecursive;

    @BeforeEach
    public void setUp(){
        this.subsetsIterative = new Subsets();
        this.subsetsRecursive = new SubsetsRecursiveSolution();
    }

    @Test
    public void shouldFindAllSubsetsUsingIterativeSolution(){
        var expected = buildExpectation();

        int[] nums = {1,2,3};
        var response = subsetsIterative.subsets(nums);

        Assertions.assertTrue(expected.containsAll(response) && response.containsAll(expected));
    }

    @Test
    public void shouldFindAllSubsetsUsingRecursiveSolution(){
        var expected = buildExpectation();

        int[] nums = {1,2,3};
        var response = subsetsRecursive.subsets(nums);

        Assertions.assertTrue(expected.containsAll(response) && response.containsAll(expected));
    }

    private List<List<Integer>> buildExpectation() {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>(temp));
        temp.add(1);
        output.add(new ArrayList<>(temp));
        temp.clear();

        temp.add(2);
        output.add(new ArrayList<>(temp));
        temp.clear();

        temp.add(1);
        temp.add(2);
        output.add(new ArrayList<>(temp));
        temp.clear();

        temp.add(3);
        output.add(new ArrayList<>(temp));
        temp.clear();

        temp.add(1);
        temp.add(3);
        output.add(new ArrayList<>(temp));
        temp.clear();

        temp.add(2);
        temp.add(3);
        output.add(new ArrayList<>(temp));
        temp.clear();

        temp.add(1);
        temp.add(2);
        temp.add(3);
        output.add(new ArrayList<>(temp));

        return output;
    }
}
