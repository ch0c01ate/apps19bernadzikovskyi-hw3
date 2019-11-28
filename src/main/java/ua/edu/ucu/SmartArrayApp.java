package ua.edu.ucu;

import java.util.Arrays;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;


public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new MapDecorator(
                new SortDecorator(
                        new FilterDecorator(sa, pr),
                        cmp),
                func);

        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        MyPredicate isSecondYearStudent = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getYear() == 2;
            }
        };

        MyPredicate gpaIsGreaterThan4 = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student) t).getGPA() >= 4.0;
            }
        };

        MyComparator cmpSurnames = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Student) o1).getSurname().compareTo(((Student) o2).getSurname());
            }
        };

        MyFunction getName = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student) t).getName();
            }
        };

        SmartArray studentArray = new SortDecorator(
                new DistinctDecorator(
                        new FilterDecorator(
                                new FilterDecorator(
                                        new BaseArray(students), isSecondYearStudent),
                                gpaIsGreaterThan4)),
                cmpSurnames);

        String[] res = new String[studentArray.size()];
        Object[] arr = studentArray.toArray();

        for (int i = 0; i < studentArray.size(); ++i) {
            Object student = arr[i];
            res[i] = (String) (((Student) student).getSurname() + " " +
                    ((Student) student).getName());
        }
        return res;
    }
}
