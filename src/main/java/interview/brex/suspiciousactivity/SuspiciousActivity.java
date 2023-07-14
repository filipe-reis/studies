package main.java.interview.brex.suspiciousactivity;


import java.util.*;

/**
 *
 * Não tive essa questão na minha entrevista. Encontrei ela na internet!
 * Question:
 * We have a set of known suspicious user activities and a batch of new user activities.
 * An activity is an ordered tuple of attributes. Using the known set,
 * we want to find activities in the new batch that are suspicious.
 *
 * To do so, we have set up a simple hypothesis -
 *
 * An activity is suspicious if it is “similar” to any other suspicious activity,
 * including suspicious activities from the new batch.
 * An activity is similar to another activity if they have the same values for at least k attributes.
 * Given the set of known suspicious activities, similarity factor k and the set of new activities,
 * determine which of the new activities are suspicious according to the above hypothesis
 */
public class SuspiciousActivity {

    public static void main(String[] args) {
        SuspiciousActivitySolution solution = new SuspiciousActivitySolution();
        Set<String> suspiciousActivities = new HashSet<>();

        suspiciousActivities.add("Brad");
        suspiciousActivities.add("San Francisco");
        suspiciousActivities.add("withdraw");

        List<String> newActivity1 = new ArrayList<>(Arrays.asList("Joe", "Miami", "withdraw"));
        List<String> newActivity2 = new ArrayList<>(Arrays.asList("John", "San Francisco", "deposit"));
        List<String> newActivity3 = new ArrayList<>(Arrays.asList("Albert", "London", "withdraw"));
        List<String> newActivity4 = new ArrayList<>(Arrays.asList("Diana", "London", "withdraw"));
        List<String> newActivity5 = new ArrayList<>(Arrays.asList("Diana", "San Francisco", "withdraw"));
        List<String> newActivity6 = new ArrayList<>(Arrays.asList("Joe", "New York", "update_address"));

        List<List<String>> new_activities = new ArrayList<>();
        new_activities.add(newActivity1);
        new_activities.add(newActivity2);
        new_activities.add(newActivity3);
        new_activities.add(newActivity4);
        new_activities.add(newActivity5);
        new_activities.add(newActivity6);

        List<List<String>> suspiciousActivitiesList = solution.findSuspiciousActivities(suspiciousActivities, new_activities, 1);

        System.out.println(suspiciousActivitiesList);

    }
}

class SuspiciousActivitySolution{

    public List<List<String>> findSuspiciousActivities(Set<String> suspiciousActivities,
                                                       List<List<String>> newActivities,
                                                       int k){
        int countSimilar;
        List<List<String>> output = new ArrayList<>();


        for(List<String> list: newActivities){
            List<String> temp = new ArrayList<>();
            countSimilar = 0;
            for(String activity : list){
                if(suspiciousActivities.contains(activity)){

                    temp.add(activity);
                    countSimilar++;
                }
            }
            if(countSimilar >= k){
                output.add(temp);
            }

        }

        return output;
    }
}
