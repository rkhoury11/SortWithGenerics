import java.util.Random;
import java.util.ArrayList;
import sorting.Sort;
import person.Student;
import java.util.Scanner;

public class App {

    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> ArrayList<Student<T>> createRandomArray(int arrayLength, String typeName) {
        ArrayList<Student<T>> arrayList = new ArrayList<>(arrayLength);
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            String id = String.valueOf(i);
            switch (typeName) {
                case "Integer":
                    arrayList.add((Student<T>) new Student<Integer>(id, random.nextInt(100)));
                    break;
                case "Float":
                    arrayList.add((Student<T>) new Student<Float>(id, random.nextFloat(100)));
                    break;
                case "Double":
                    arrayList.add((Student<T>) new Student<Double>(id, random.nextDouble(100)));
                    break;
                default:
                    System.out.println("Use Integer as the grade data type");
                    arrayList.add((Student<T>) new Student<Integer>(id, random.nextInt(100)));
            }
        }
        return arrayList;
    }

    public static <T extends Comparable <T>> void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
        System.out.println("Please input the array size:");
        int arrayLength = scanner.nextInt();
        System.out.println("Please input the grade data type (choose Integer, Float, or Double): ");
        String typeName = scanner.next();
        ArrayList<Student<T>> arrayList = createRandomArray(arrayLength, typeName);
        System.out.println(arrayList.toString());
        System.out.println(Sort.isSorted(arrayList));

        System.out.println("Please input the sorting type (choose merge or bubble): ");
        String sortType = scanner.next();

        switch (sortType){
            case "merge":
            Sort.mergeSort(arrayList);
            break;
            case "bubble":
            Sort.bubbleSort(arrayList);
            break;
            default:
            System.out.println("Use merge as the sorting type");
            Sort.mergeSort(arrayList);
        }

        System.out.println(arrayList.toString());
        System.out.println(Sort.isSorted(arrayList));

        System.out.println("Continue? Please enter yes or no");
        String yesNo = scanner.next();
        if (yesNo.equals("no")) 
        break;
        }
        scanner.close();
        
    }
}