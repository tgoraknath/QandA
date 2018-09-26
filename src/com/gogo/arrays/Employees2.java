package com.gogo.arrays;
import java.util.*;

public class Employees2 {
    static int[] sortedListOfSalaries(String[][] workers) {
        int[] salaries = new int[workers.length];
        Queue<Integer> managers = new LinkedList<Integer>(); // Queue for Managers
        // Calculate salaries of all FTEs and Contractors
        for (int i = 0; i < workers.length; i++) {
            if (workers[i][1].equals("Contractor")) {
                salaries[i] = 52 * Integer.valueOf(workers[i][3]) * Integer.valueOf(workers[i][4]);
            } else if (workers[i][1].equals("FTE")) {
                salaries[i] = Integer.valueOf(workers[i][3]);
            } else if (workers[i][1].equals("Manager")) {
                managers.add(i); // Add a Manager to the Queue to compute later
            }
        }
        // Calculate salaries of all Managers
        while (!managers.isEmpty()) {
            int currentManager = managers.remove();
            String[] reports = workers[currentManager][3].split(",");
            int managerSalary = 0;
            boolean isValid = true; // Whether current Manager's salary is computable
            for (int i = 0; i < reports.length; i++) {
                int currentReport = Integer.valueOf(reports[i]);
                if (salaries[currentReport - 1] == 0) {
                    isValid = false; // Current Manager's salary depends on a Manager who's salary hasn't been
                                        // computed yet.
                    managers.add(currentManager); // Add the manager back to Queue
                    break;
                }
                managerSalary = managerSalary + salaries[currentReport - 1];
            }
            if (isValid)
                salaries[currentManager] = managerSalary; // Store the Manager's salary if it is valid
        }
        Arrays.sort(salaries);
        return salaries;
    }
    
    static List<Integer> sortedListOfSalariesTwo(List<List<String>> workers) {
        Integer[] salaries = new Integer[workers.size()];
        Map<Integer, Integer> salariesMap = new HashMap<Integer, Integer>();
        Queue<Integer> managers = new LinkedList<Integer>();
        // Calculate salaries of all FTEs and Contractors
        for (int i = 0; i < workers.size(); i++) {
            System.out.println(workers.get(i).get(1));
//          System.out.println(workers.get(i));
            if ("Contractor".equals(workers.get(i).get(1))) {
                salaries[i]= (52 * Integer.valueOf(workers.get(i).get(3)) * Integer.valueOf(workers.get(i).get(4)));
                salariesMap.put(Integer.valueOf(workers.get(i).get(0)), salaries[i]);
            } else if ("FTE".equals(workers.get(i).get(1))) {
                salaries[i]= Integer.valueOf(workers.get(i).get(3));
                salariesMap.put(Integer.valueOf(workers.get(i).get(0)), salaries[i]);
            } else if ("Manager".equals(workers.get(i).get(1))) {
                managers.add(i);
            }
        }
        while (!managers.isEmpty()) {
            int currentManager = managers.remove();
            String[] reports = workers.get(currentManager).get(3).split(",");
            int managerSalary = 0;
            boolean isValid = true; // Whether current Manager's salary is computable
            for (int i = 0; i < reports.length; i++) {
                int currentReport = Integer.valueOf(reports[i]);
System.out.println(salaries);
                if (salaries[currentReport - 1] == 0) {
                    isValid = false; // Current Manager's salary depends on a Manager who's salary hasn't been
                                        // computed yet.
                    managers.add(currentManager); // Add the manager back to Queue
                    break;
                }
                managerSalary = managerSalary + salaries[currentReport - 1];
            }
            if (isValid)
                salaries[currentManager] = managerSalary; // Store the Manager's salary if it is valid
        }
        List<Integer> list = Arrays.asList(salaries);
        Collections.sort(list);
        return list;
    }
    public static void main(String[] args) {
        // Test case
        String[][] test = new String[6][5];
        int[] result = new int[5];
        test[0] = new String[] { "1", "FTE", "ABC", "75000", "20" };
        test[1] = new String[] { "2", "FTE", "DEF", "50000", "10" };
        test[2] = new String[] { "3", "Manager", "GHI", "2,5", null };
        test[3] = new String[] { "4", "FTE", "JKL", "100000", null };
        test[4] = new String[] { "5", "Manager", "MNO", "1,6", null };
        test[5] = new String[] { "6", "Manager", "SIX", "4", null };
        result = sortedListOfSalaries(test);
        // Print the results
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        /*
        List<List<String>> info4 = new ArrayList<>();
        String[] s1 = { "1", "FTE", "George", "75000", null };
        String[] s2 = { "2", "FTE", "Stephan", "50000", null };
        String[] s3 = { "3", "Manager", "Veronica", "4,6", null };//125K + 100K
        String[] s4 = { "4", "Manager", "Christopher", "1,5", null };//125K
        String[] s5 = { "5", "Manager", "Mary", "2", null };//50K
        String[] s6 = { "6", "FTE", "John", "10000", null };//100K
        //50K, 75K, 
        info4.add(Arrays.asList(s1));
        info4.add(Arrays.asList(s2));
        info4.add(Arrays.asList(s3));
        info4.add(Arrays.asList(s4));
        info4.add(Arrays.asList(s5));
        info4.add(Arrays.asList(s6));
        System.out.println(sortedListOfSalariesTwo(info4));*/
    }
}