import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    String gender;
    int age;
    String classroom;
    float score;

    void output() {
        System.out.println(id + "\t\t" + name + "\t\t\t\t" + gender + "\t\t\t" + age + "\t\t" + classroom + "\t\t\t" + score);
    }

    void input(Scanner input) {
        boolean isValid = false;
        do {
            System.out.print("Enter ID : ");
            String strId;
            try {
                strId = input.nextLine();
                id = Integer.parseInt(strId);
                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid ID (Integer only)!");
            }
        } while (!isValid);
        System.out.print("Enter name : ");
        name = input.nextLine();
        System.out.print("Enter gender : ");
        gender = input.nextLine();
        isValid = false;
        do {
            System.out.print("Enter age : ");
            String strAge;
            try {
                strAge = input.nextLine();
                age = Integer.parseInt(strAge);
                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid age (Integer only)!");
            }
        } while (!isValid);
        System.out.print("Enter classroom : ");
        classroom = input.nextLine();
        isValid = false;
        do {
            System.out.print("Enter score : ");
            String strScore;
            try {
                strScore = input.nextLine();
                score = Float.parseFloat(strScore);
                isValid = true;
            } catch (Exception e) {
                System.out.println("Invalid score (can't be string)!");
            }
        } while (!isValid);
    }
}

public class Main {

    static void pressEnterKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(">> Press enter to continue");
        scanner.nextLine();
    }

    static void outputHeader() {
        System.out.println("ID\t\tNAME\t\t\t\tGENDER\t\tAGE\t\tCLASSROOM\t\tSCORE");
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int option = 0;
        String strOpt;
        do {
            System.out.println("------------- Student Management System -------------");
            System.out.println("1. Insert Student to System");
            System.out.println("2. Edit Student Information");
            System.out.println("3. Search Student Information");
            System.out.println("4. Delete Student Information");
            System.out.println("5. Show Student Information");
            System.out.println("6. Exit");

            boolean isValid = false;
            do {
                System.out.print(">> Enter option [1-6] : ");
                try {
                    strOpt = input.nextLine();
                    option = Integer.parseInt(strOpt);
                    isValid = true;
                } catch (Exception e) {
                    option = 0;
                    System.out.println("Incorrect format, please enter again");
                }
            } while (!isValid);

            switch (option) {
                case 1 -> {
                    System.out.println("------------ Insert Student to System -----------");
                    Student student = new Student();
                    student.input(input);
                    students.add(student);
                    System.out.println("Successfully added student into the system!!");
                }
                case 2 -> {
                    System.out.println("----------- Edit Student Information ------------");
                    if (!students.isEmpty()) {
                        int updId = 0;
                        boolean isIdValid = false;
                        boolean found = false;
                        do {
                            System.out.print("Enter student's ID you want to edit : ");
                            String strId;
                            try {
                                strId = input.nextLine();
                                updId = Integer.parseInt(strId);
                                isIdValid = true;
                            } catch (Exception e) {
                                System.out.println("Invalid ID (Integer only)!");
                            }
                        } while (!isIdValid);
                        for (Student student : students) {
                            if (student.id == updId) {
                                found = true;
                                System.out.print("Enter new name : ");
                                student.name = input.nextLine();
                                System.out.print("Enter new gender : ");
                                student.gender = input.nextLine();
                                boolean isAgeValid = false;
                                do {
                                    System.out.print("Enter new age : ");
                                    String strAge;
                                    try {
                                        strAge = input.nextLine();
                                        student.age = Integer.parseInt(strAge);
                                        isAgeValid = true;
                                    } catch (Exception e) {
                                        System.out.println("Invalid age (Integer only)!");
                                    }
                                } while (!isAgeValid);
                                System.out.print("Enter new classroom : ");
                                student.classroom = input.nextLine();
                                boolean isScoreValid = false;
                                do {
                                    System.out.print("Enter new score : ");
                                    String strScore;
                                    try {
                                        strScore = input.nextLine();
                                        student.score = Float.parseFloat(strScore);
                                        isScoreValid = true;
                                    } catch (Exception e) {
                                        System.out.println("Invalid score (Can't be string)!");
                                    }
                                } while (!isScoreValid);
                                System.out.println("Successfully updated student's info with ID " + updId + "!!");
                            }
                        }
                        if (!found) {
                            System.out.println("Student with ID " + updId + " can't be found!!");
                        }
                    } else {
                        System.out.println("There no student is the list!");
                    }

                }
                case 3 -> {
                    if (!students.isEmpty()) {
                        int searchOpt = 0;
                        do {
                            System.out.println("------------- Search Student Information -----------");
                            System.out.println("1. Search by ID");
                            System.out.println("2. Search by name");
                            System.out.println("3. Search by Gender");
                            System.out.println("4. Search by classname");
                            System.out.println("5. Exit");
                            boolean isOptValid = false;
                            String strSearchOpt;
                            do {
                                System.out.print(">> Choose an option [1-5] : ");
                                try {
                                    strSearchOpt = input.nextLine();
                                    searchOpt = Integer.parseInt(strSearchOpt);
                                    isOptValid = true;
                                } catch (Exception e) {
                                    System.out.println("Invalid format (Integer only)!!");
                                }
                            } while (!isOptValid);


                            switch (searchOpt) {
                                case 1 -> {
                                    int searchID = 0;
                                    boolean found = false;
                                    System.out.println("----------------- Search by ID -------------");
                                    String strSearchId;
                                    isOptValid = false;

                                    do {
                                        System.out.print("Enter ID to search : ");
                                        try {
                                            strSearchId = input.nextLine();
                                            searchID = Integer.parseInt(strSearchId);
                                            isOptValid = true;
                                        } catch (Exception e) {
                                            System.out.println("Invalid ID (Integer only)!!");
                                        }
                                    } while (!isOptValid);

                                    for (Student student : students) {
                                        if (searchID == student.id) {
                                            found = true;
                                            student.output();
                                        }
                                    }
                                    if (!found) {
                                        System.out.println("Student with ID " + searchID + " can't be found!");
                                    }
                                }
                                case 2 -> {
                                    String searchName;
                                    boolean found = false;
                                    System.out.println("----------------- Search by Name -------------");

                                    System.out.print("Enter student's name to search : ");
                                    searchName = input.nextLine();
                                    for (Student student : students) {
                                        if (searchName.equalsIgnoreCase(student.name)) {
                                            found = true;
                                            student.output();
                                        }
                                    }
                                    if (!found) {
                                        System.out.println("Student with name " + searchName + " can't be found!");
                                    }
                                }
                                case 3 -> {
                                    String searchGender;
                                    boolean found = false;
                                    System.out.println("----------------- Search by Gender -------------");

                                    System.out.print("Enter student's gender to search : ");
                                    searchGender = input.nextLine();
                                    for (Student student : students) {
                                        if (searchGender.equalsIgnoreCase(student.gender)) {
                                            found = true;
                                            student.output();
                                        }
                                    }
                                    if (!found) {
                                        System.out.println("Student with gender " + searchGender + " can't be found!");
                                    }

                                }
                                case 4 -> {
                                    String searchClass;
                                    boolean found = false;
                                    System.out.print("----------------- Search by Classname -------------");

                                    System.out.println("Enter student's classname to search : ");
                                    searchClass = input.nextLine();
                                    for (Student student : students) {
                                        if (searchClass.equalsIgnoreCase(student.classroom)) {
                                            found = true;
                                            student.output();
                                        }
                                    }
                                    if (!found) {
                                        System.out.println("Student with gender " + searchClass + " can't be found!");
                                    }

                                }
                                case 5 -> {
                                    System.out.println("Exiting program...");
                                }
                            }
                            pressEnterKey();
                        } while (searchOpt != 5);
                    } else {
                        System.out.println("There is no student in the list!!");
                    }

                }

                case 4 -> {
                    System.out.println("----------- Delete Student Information ------------");
                    if (!students.isEmpty()) {
                        int delId = 0;
                        boolean isIdValid = false;
                        boolean found = false;
                        do {
                            System.out.print("Enter student's ID you want to delete : ");
                            String strId;
                            try {
                                strId = input.nextLine();
                                delId = Integer.parseInt(strId);
                                isIdValid = true;
                            } catch (Exception e) {
                                System.out.println("Invalid ID (Integer only)!");
                            }
                        } while (!isIdValid);
                        for (Student student : students) {
                            if (student.id == delId) {
                                found = true;
                                students.remove(student);
                                System.out.println("Successfully deleted a student with ID " + delId + "!!");
                            }

                        }

                        if (!found) {
                            System.out.println("Student with ID " + delId + " can't be found!!");
                        }
                    } else {
                        System.out.println("There is no student is the list!");
                    }
                }
                case 5 -> {
                    System.out.println("--------------------- Show Student Information --------------------");
                    outputHeader();
                    for (Student student : students) {
                        student.output();
                    }
                }
                case 6 -> {
                    System.out.println("Exit program...");
                }
                default -> System.out.println("Wrong option!! Choose again from [1-6]");
            }
            pressEnterKey();
        } while (option != 6);
    }
}
