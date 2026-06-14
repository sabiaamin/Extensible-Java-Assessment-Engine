import java.util.ArrayList; // stores objects rather than primitives
import java.util.Collections; // For Collections.shuffle() //mostly used sorting,shuffling,searching


/// This class holds all the questions for all subjects and difficulties.
/// It's responsible for initializing them and providing a way to get a random set of questions for a new quiz.
/// It demonstrates polymorphism
/// All our ArrayLists are of the parent type: ArrayList<Question>
/// But we will be adding child objects to them: new MultipleChoiceQuestion(...)


public class QuestionBank {
    /// Fields
    private ArrayList<Question> javaEasyQuestions;
    private ArrayList<Question> javaMediumQuestions;
    private ArrayList<Question> javaDifficultQuestions;

    private ArrayList<Question> dsEasyQuestions;
    private ArrayList<Question> dsMediumQuestions;
    private ArrayList<Question> dsDifficultQuestions;

    private ArrayList<Question> networkingEasyQuestions;
    private ArrayList<Question> networkingMediumQuestions;
    private ArrayList<Question> networkingDifficultQuestions;

    /// Constructor
    public QuestionBank() {
        // Initialize all the lists
        javaEasyQuestions = new ArrayList<>();
        javaMediumQuestions = new ArrayList<>();
        javaDifficultQuestions = new ArrayList<>();

        dsEasyQuestions = new ArrayList<>();
        dsMediumQuestions = new ArrayList<>();
        dsDifficultQuestions = new ArrayList<>();

        networkingEasyQuestions = new ArrayList<>();
        networkingMediumQuestions = new ArrayList<>();
        networkingDifficultQuestions = new ArrayList<>();

        // Populate the lists
        loadQuestions();
    }

    /// Main Public Method
    public ArrayList<Question> getQuizQuestions(Subject subject) {

        //This ArrayList grows as we add questions
        ArrayList<Question> quizQuestions = new ArrayList<>();

        switch (subject) {
            case JAVA:
                addRandomQuestions(quizQuestions, javaEasyQuestions, 2);
                addRandomQuestions(quizQuestions, javaMediumQuestions, 2);
                addRandomQuestions(quizQuestions, javaDifficultQuestions, 2);
                break;

            case DATA_STRUCTURES:
                addRandomQuestions(quizQuestions, dsEasyQuestions, 2);
                addRandomQuestions(quizQuestions, dsMediumQuestions, 2);
                addRandomQuestions(quizQuestions, dsDifficultQuestions, 2);
                break;

            case NETWORKING:
                addRandomQuestions(quizQuestions, networkingEasyQuestions, 2);
                addRandomQuestions(quizQuestions, networkingMediumQuestions, 2);
                addRandomQuestions(quizQuestions, networkingDifficultQuestions, 2);
                break;

            default:
                return null;
        }

        return quizQuestions;
    }


    /// Private Helper Methods
    private void addRandomQuestions(ArrayList<Question> quizList, ArrayList<Question> sourceList, int count) {
        ArrayList<Question> copy = new ArrayList<>(sourceList);
        Collections.shuffle(copy);

        for (int i = 0; i < count && i < copy.size(); i++) {
            quizList.add(copy.get(i));
        }
    }


    private void loadQuestions() {

        /// JAVA: EASY

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the file extension for a compiled Java class file?",
                new String[] {
                        "1. .java",
                        "2. .class",
                        "3. .jar",
                        "4. .exe"
                },
                1, // 2. .class
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "Which data type would you use to store a whole number like 10?",
                new String[] {
                        "1. double",
                        "2. String",
                        "3. int",
                        "4. boolean"
                },
                2, // 3. int
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "Which data type would you use to store a decimal number like 3.14?",
                new String[] {
                        "1. float",
                        "2. double",
                        "3. int",
                        "4. Both 1 and 2"
                },
                3, // 4. (double is more common, but float also works)
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "Which data type is used to store a 'True' or 'False' value?",
                new String[] {
                        "1. bool",
                        "2. bit",
                        "3. char",
                        "4. boolean"
                },
                3, // 4. boolean
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the output of: System.out.println(10 + 5);",
                new String[] {
                        "1. 10 + 5",
                        "2. 15",
                        "3. 105",
                        "4. Error"
                },
                1, // 2. 15
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the output of: System.out.println(\"10\" + \"5\");",
                new String[] {
                        "1. 15",
                        "2. 105",
                        "3. \"105\"",
                        "4. Error"
                },
                1, // 2. 105 (String concatenation)
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the '%' operator called?",
                new String[] {
                        "1. Division operator",
                        "2. Percentage operator",
                        "3. Modulus operator",
                        "4. Equality operator"
                },
                2, // 3. Modulus (remainder)
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the output of: System.out.println(10 % 3);",
                new String[] {
                        "1. 1",
                        "2. 3",
                        "3. 3.33",
                        "4. 0"
                },
                0, // 1. 1 (10 / 3 is 3 with a remainder of 1)
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "Which keyword is used to declare a variable that cannot be modified?",
                new String[] {
                        "1. const",
                        "2. static",
                        "3. final",
                        "4. fixed"
                },
                2, // 3. final
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the correct way to write a multi-line comment in Java?",
                new String[] {
                        "1. // This is a comment",
                        "2. /* This is a comment */",
                        "3. ",
                        "4. # This is a comment"
                },
                1, // 2.
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "What does 'OOP' stand for?",
                new String[] {
                        "1. Object-Oriented Programming",
                        "2. Object-Open Protocol",
                        "3. Original-Order Processing",
                        "4. Object-Oriented Protocol"
                },
                0, // 1.
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "In OOP, what is a 'class' often described as?",
                new String[] {
                        "1. A function",
                        "2. A variable",
                        "3. A blueprint for creating objects",
                        "4. An instance of an object"
                },
                2, // 3.
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "In OOP, what is an 'object'?",
                new String[] {
                        "1. A data type",
                        "2. A keyword",
                        "3. An instance of a class",
                        "4. A blueprint"
                },
                2, // 3.
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "Which keyword is used to create an 'object' (an instance) of a class?",
                new String[] {
                        "1. new",
                        "2. create",
                        "3. instance",
                        "4. object"
                },
                0, // 1. new
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "Which method is the main entry point for a Java application?",
                new String[] {
                        "1. public void start()",
                        "2. public static void main(String[] args)",
                        "3. private void main(String[] args)",
                        "4. public static void run()"
                },
                1, // 2.
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the output of: int x = 5; x = x + 1; System.out.println(x);",
                new String[] {
                        "1. 5",
                        "2. 6",
                        "3. 1",
                        "4. 0"
                },
                1, // 2. 6
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the output of: int x = 5; x++; System.out.println(x);",
                new String[] {
                        "1. 5",
                        "2. 6",
                        "3. 1",
                        "4. 0"
                },
                1, // 2. 6 (x++ increments x)
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the output of: int x = 5; x--; System.out.println(x);",
                new String[] {
                        "1. 5",
                        "2. 4",
                        "3. -1",
                        "4. 0"
                },
                1, // 2. 4
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "Which operator is used for 'equal to' comparison?",
                new String[] {
                        "1. =",
                        "2. ==",
                        "3. :=",
                        "4. equals"
                },
                1, // 2. ==
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "Which operator is used for 'not equal to' comparison?",
                new String[] {
                        "1. !=",
                        "2. <>",
                        "3. =!=",
                        "4. not"
                },
                0, // 1. !=
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the output of: String name = \"Java\"; System.out.println(name.length());",
                new String[] {
                        "1. 5",
                        "2. 4",
                        "3. 3",
                        "4. Error"
                },
                1, // 2. 4
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the output of: String name = \"Java\"; System.out.println(name.charAt(0));",
                new String[] {
                        "1. J",
                        "2. a",
                        "3. 0",
                        "4. Error"
                },
                0, // 1. J (index starts at 0)
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "What keyword is used to start an 'if' statement?",
                new String[] {
                        "1. if",
                        "2. when",
                        "3. check",
                        "4. case"
                },
                0, // 1. if
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "What keyword provides the alternative case for an 'if' statement?",
                new String[] {
                        "1. otherwise",
                        "2. then",
                        "3. else",
                        "4. default"
                },
                2, // 3. else
                Subject.JAVA,
                Difficulty.EASY
        ));

        javaEasyQuestions.add(new MultipleChoiceQuestion(
                "Which loop is guaranteed to execute at least one time?",
                new String[] {
                        "1. for",
                        "2. while",
                        "3. do-while",
                        "4. All loops"
                },
                2, // 3. do-while
                Subject.JAVA,
                Difficulty.EASY
        ));

        /// JAVA: MEDIUM

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code?\nString s1 = \"Hello\";\nString s2 = new String(\"Hello\");\nSystem.out.println(s1 == s2);",
                new String[] {
                        "1. true",
                        "2. false",
                        "3. Throws an error",
                        "4. Hello"
                },
                1, // 2. false (== compares references, s2 is a new object on the heap)
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code?\nString s1 = \"Hello\";\nString s2 = \"Hello\";\nSystem.out.println(s1 == s2);",
                new String[] {
                        "1. true",
                        "2. false",
                        "3. Throws an error",
                        "4. Hello"
                },
                0, // 1. true (s1 and s2 point to the same object in the String pool)
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code?\nString s1 = \"Hello\";\nString s2 = new String(\"Hello\");\nSystem.out.println(s1.equals(s2));",
                new String[] {
                        "1. true",
                        "2. false",
                        "3. Throws an error",
                        "4. Hello"
                },
                0, // 1. true (equals() compares the actual character values)
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "What is 'method overloading'?",
                new String[] {
                        "1. A subclass has a method with the same signature as the parent class",
                        "2. A class has two or more methods with the same name but different parameters",
                        "3. A method calls itself recursively",
                        "4. A method that runs in a separate thread"
                },
                1, // 2.
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "What is 'method overriding'?",
                new String[] {
                        "1. A subclass provides a specific implementation for a method defined in its parent class",
                        "2. A class has two methods with the same name but different parameters",
                        "3. A method is declared 'final'",
                        "4. A method that can throw multiple exceptions"
                },
                0, // 1.
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code?\nint x = 5;\nint y = ++x;\nSystem.out.println(\"x=\" + x + \", y=\" + y);",
                new String[] {
                        "1. x=6, y=5",
                        "2. x=5, y=5",
                        "3. x=5, y=6",
                        "4. x=6, y=6"
                },
                3, // 4. (pre-increment: x becomes 6, then y is set to 6)
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code?\nint x = 5;\nint y = x++;\nSystem.out.println(\"x=\" + x + \", y=\" + y);",
                new String[] {
                        "1. x=6, y=5",
                        "2. x=5, y=5",
                        "3. x=5, y=6",
                        "4. x=6, y=6"
                },
                0, // 1. (post-increment: y is set to 5, then x becomes 6)
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "Which statement is true about 'String' vs 'StringBuilder'?",
                new String[] {
                        "1. String is mutable, StringBuilder is immutable",
                        "2. String is immutable, StringBuilder is mutable",
                        "3. Both are mutable",
                        "4. Both are immutable"
                },
                1, // 2. (String objects cannot be changed, StringBuilder can)
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "Which of these collections stores key-value pairs?",
                new String[] {
                        "1. ArrayList",
                        "2. HashMap",
                        "3. HashSet",
                        "4. LinkedList"
                },
                1, // 2. HashMap
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "Which of these collections does NOT allow duplicate elements?",
                new String[] {
                        "1. ArrayList",
                        "2. HashMap",
                        "3. HashSet",
                        "4. LinkedList"
                },
                2, // 3. HashSet
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the purpose of a 'constructor' in a class?",
                new String[] {
                        "1. To destroy an object and free memory",
                        "2. To be the main entry point of the program",
                        "3. To initialize a new object when it is created",
                        "4. To copy an existing object"
                },
                2, // 3.
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "If a class has no constructor defined, what happens?",
                new String[] {
                        "1. The code will not compile",
                        "2. The Java compiler provides a default, no-argument constructor",
                        "3. The class cannot be instantiated",
                        "4. It throws a NullPointerException at runtime"
                },
                1, // 2.
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the purpose of the 'super' keyword?",
                new String[] {
                        "1. To refer to the current object's instance (like 'this')",
                        "2. To declare a variable as a global constant",
                        "3. To call a method or constructor from the immediate parent class",
                        "4. To make a method run with the highest priority"
                },
                2, // 3.
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the purpose of the 'static' keyword on a method?",
                new String[] {
                        "1. The method can be accessed without creating an instance of the class",
                        "2. The method can never be changed",
                        "3. The method is hidden from other classes",
                        "4. The method is used for inheritance"
                },
                0, // 1.
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "Can a 'static' method access a non-static instance variable?",
                new String[] {
                        "1. Yes, always",
                        "2. Yes, if the variable is public",
                        "3. No, because the static method doesn't belong to a specific object",
                        "4. Only if you use the 'this' keyword"
                },
                2, // 3.
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code?\nArrayList<String> list = new ArrayList<>();\nlist.add(\"A\");\nlist.add(\"B\");\nlist.add(1, \"C\");\nSystem.out.println(list);",
                new String[] {
                        "1. [A, B, C]",
                        "2. [A, C, B]",
                        "3. [C, A, B]",
                        "4. Error"
                },
                1, // 2. [A, C, B] (inserts "C" at index 1)
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "What is an 'abstract' class?",
                new String[] {
                        "1. A class that cannot be instantiated and may contain abstract methods",
                        "2. A class that is marked 'final'",
                        "3. A class that has only static methods",
                        "4. A class that is empty"
                },
                0, // 1.
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "What is an 'interface'?",
                new String[] {
                        "1. A concrete class with methods that can be instantiated",
                        "2. A class that can only have 'static' variables",
                        "3. A special class used only for constructors",
                        "4. A blueprint of a class, defining methods that a class must implement"
                },
                3, // 4.
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "Can a class implement multiple interfaces?",
                new String[] {
                        "1. Yes",
                        "2. No",
                        "3. Only if the interfaces are empty",
                        "4. Only if the class is 'abstract'"
                },
                0, // 1. Yes
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "Can a class 'extend' (inherit from) multiple classes?",
                new String[] {
                        "1. Yes",
                        "2. No, Java only supports single inheritance for classes",
                        "3. Yes, if the parent classes are 'abstract'",
                        "4. Yes, if you use the 'implements' keyword"
                },
                1, // 2.
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the purpose of the 'finally' block in a try-catch statement?",
                new String[] {
                        "1. It is the last 'catch' block to be executed",
                        "2. It is a block of code that *always* executes, whether an exception is thrown or not",
                        "3. It is where you declare the 'final' exception",
                        "4. It is an alternative to the 'catch' block"
                },
                1, // 2.
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the difference between 'throw' and 'throws'?",
                new String[] {
                        "1. They are the same and can be used interchangeably",
                        "2. 'throw' is used to manually throw an exception, 'throws' is used to declare an exception in a method's signature",
                        "3. 'throws' is used to manually throw an exception, 'throw' is used to declare an exception",
                        "4. 'throw' is for 'Exception', 'throws' is for 'Error'"
                },
                1, // 2.
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code snippet?\n\ntry {\n  int x = 10 / 0;\n  System.out.println(\"A\");\n} catch (ArithmeticException e) {\n  System.out.println(\"B\");\n} finally {\n  System.out.println(\"C\");\n}",
                new String[] {
                        "1. A B C",
                        "2. B C",
                        "3. A C",
                        "4. C"
                },
                1, // 2. B C (Exception is thrown, "A" is skipped, "B" is caught, "C" runs)
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code snippet?\n\ntry {\n  System.out.println(\"A\");\n} catch (Exception e) {\n  System.out.println(\"B\");\n} finally {\n  System.out.println(\"C\");\n}",
                new String[] {
                        "1. A",
                        "2. C",
                        "3. A C",
                        "4. B C"
                },
                2, // 3. A C (No exception, "A" runs, "B" is skipped, "C" runs)
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        javaMediumQuestions.add(new MultipleChoiceQuestion(
                "Which of these is a 'checked' exception?",
                new String[] {
                        "1. NullPointerException",
                        "2. ArrayIndexOutOfBoundsException",
                        "3. IOException",
                        "4. ArithmeticException"
                },
                2, // 3. IOException (Must be handled with try-catch or 'throws')
                Subject.JAVA,
                Difficulty.MEDIUM
        ));

        /// JAVA: DIFFICULT

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code?\n\nInteger i1 = 127;\nInteger i2 = 127;\nSystem.out.println(i1 == i2);",
                new String[] {
                        "1. true",
                        "2. false",
                        "3. Compile Error",
                        "4. Runtime Error"
                },
                0, // 1. true (Integer caching for values -128 to 127)
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code?\n\nInteger i1 = 128;\nInteger i2 = 128;\nSystem.out.println(i1 == i2);",
                new String[] {
                        "1. true",
                        "2. false",
                        "3. Compile Error",
                        "4. Runtime Error"
                },
                1, // 2. false (Values outside -128 to 127 are new objects)
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code snippet?\n\ntry {\n  System.out.print(\"A\");\n  return;\n} finally {\n  System.out.print(\"B\");\n}",
                new String[] {
                        "1. A",
                        "2. B",
                        "3. AB",
                        "4. BA"
                },
                2, // 3. AB (The 'finally' block *always* executes, even after a 'return')
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "Which statement is true regarding the 'hashCode()' and 'equals()' contract?",
                new String[] {
                        "1. If two objects are equal by 'equals()', they MUST have different hash codes.",
                        "2. If two objects have the same hash code, they MUST be equal by 'equals()'.",
                        "3. If two objects are equal by 'equals()', they MUST have the same hash code.",
                        "4. There is no relationship between 'hashCode()' and 'equals()'."
                },
                2, // 3. (This is the fundamental contract for collections like HashSet)
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code?\n\nclass Parent { void print() { System.out.println(\"P\"); } }\nclass Child extends Parent { void print() { System.out.println(\"C\"); } }\n\nParent p = new Child();\np.print();",
                new String[] {
                        "1. P",
                        "2. C",
                        "3. Compile Error",
                        "4. Runtime Error (ClassCastException)"
                },
                1, // 2. C (Runtime Polymorphism - the object's actual type determines the method)
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the primary difference between 'final', 'finally', and 'finalize'?",
                new String[] {
                        "1. They are all keywords for exception handling.",
                        "2. final is a keyword, finally is a block, finalize is a method for garbage collection.",
                        "3. final and finally are the same; finalize is for constants.",
                        "4. final is for methods, finally is for classes, finalize is for variables."
                },
                1, // 2.
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is a 'Lambda Expression' in Java?",
                new String[] {
                        "1. A new 'for' loop syntax for collections.",
                        "2. A special way to create a 'static' method.",
                        "3. An anonymous function (a block of code) used to implement a functional interface.",
                        "4. A keyword for creating objects without a constructor."
                },
                2, // 3.
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code?\n\nint x = 5;\nx = x++ + ++x + x;\nSystem.out.println(x);",
                new String[] {
                        "1. 17",
                        "2. 18",
                        "3. 19",
                        "4. 20"
                },
                2, // 3. 19 (x++ returns 5, x is now 6. ++x increments x to 7, returns 7. x is now 7. 5 + 7 + 7 = 19)
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the purpose of the 'volatile' keyword in Java?",
                new String[] {
                        "1. To make a variable a constant (non-changeable).",
                        "2. To ensure that a variable's value is always read from main memory, not a thread's cache.",
                        "3. To make a class non-inheritable.",
                        "4. To mark an object for immediate garbage collection."
                },
                1, // 2. (It's a concurrency keyword for thread visibility)
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code?\n\nstatic {\n  System.out.print(\"S \");\n}\n{\n  System.out.print(\"I \");\n}\n\npublic static void main(String[] args) {\n  new Main();\n  new Main();\n}",
                new String[] {
                        "1. S I I",
                        "2. S I S I",
                        "3. I S I S",
                        "4. S I"
                },
                0, // 1. S I I (Static block runs once on class load, instance block runs for each 'new' object)
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the difference between List<?> (Wildcard) and List<Object>?",
                new String[] {
                        "1. They are identical and can be used interchangeably.",
                        "2. You can add any object to List<Object>, but you can only add 'null' to List<?>.",
                        "3. You can add any object to List<?>, but you can only add 'Object' to List<Object>.",
                        "4. List<Object> is for input, List<?> is for output."
                },
                1, // 2. (List<?> means 'a list of some unknown type', so you can't safely add anything to it)
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is a 'functional interface' in Java?",
                new String[] {
                        "1. An interface with no methods.",
                        "2. An interface with only 'static' methods.",
                        "3. An interface with only 'default' methods.",
                        "4. An interface with exactly one abstract method (SAM)."
                },
                3, // 4.
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code?\n\npublic static void main(String[] args) {\n  try {\n    System.out.print(1);\n    int x = 10 / 0;\n    System.out.print(2);\n  } catch (Exception e) {\n    System.out.print(3);\n  } finally {\n    System.out.print(4);\n  }\n  System.out.print(5);\n}",
                new String[] {
                        "1. 12345",
                        "2. 1345",
                        "3. 1245",
                        "4. 135"
                },
                1, // 2. 1345 (1 prints, exception, 2 is skipped, 3 prints, 4 prints, 5 prints)
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code?\n\nString s1 = \"abc\";\nString s2 = s1;\ns1 += \"d\";\nSystem.out.println(s2);",
                new String[] {
                        "1. abc",
                        "2. abcd",
                        "3. d",
                        "4. null"
                },
                0, // 1. abc (Because String is immutable. s1 += "d" creates a new object and points s1 to it. s2 still points to "abc")
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code?\n\nStringBuilder sb1 = new StringBuilder(\"abc\");\nStringBuilder sb2 = sb1;\nsb1.append(\"d\");\nSystem.out.println(sb2);",
                new String[] {
                        "1. abc",
                        "2. abcd",
                        "3. d",
                        "4. null"
                },
                1, // 2. abcd (StringBuilder is mutable. sb1 and sb2 point to the SAME object, which is modified)
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "Which of these is NOT a terminal operation in the Java Stream API?",
                new String[] {
                        "1. .forEach()",
                        "2. .collect()",
                        "3. .map()",
                        "4. .count()"
                },
                2, // 3. .map() (it's an intermediate operation)
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is a 'checked' exception in Java?",
                new String[] {
                        "1. An exception that is 'checked' by the 'finally' block.",
                        "2. An exception that must be declared (with 'throws') or handled (with 'try-catch').",
                        "3. An exception that inherits from 'RuntimeException'.",
                        "4. An exception that can only be thrown by the JVM."
                },
                1, // 2. (like IOException)
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "Can you 'override' a 'private' method in a subclass?",
                new String[] {
                        "1. Yes, if the subclass is in the same package.",
                        "2. Yes, if you use the @Override annotation.",
                        "3. No, 'private' methods are not visible to the subclass and cannot be overridden.",
                        "4. No, you can only override 'public' methods."
                },
                2, // 3.
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "Can you 'override' a 'static' method in a subclass?",
                new String[] {
                        "1. Yes, this is polymorphism.",
                        "2. No, you can only 'hide' a static method, not override it (it's static binding).",
                        "3. Yes, but you must also make it 'static' in the subclass.",
                        "4. No, 'static' methods are 'final' by default."
                },
                1, // 2. (Method overriding is a runtime concept, static methods are resolved at compile time)
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code?\n\npublic static void main(String[] args) {\n  System.out.println(test());\n}\nstatic int test() {\n  try {\n    return 1;\n  } finally {\n    return 2;\n  }\n}",
                new String[] {
                        "1. 1",
                        "2. 2",
                        "3. Compile Error: two return statements",
                        "4. Runtime Error"
                },
                1, // 2. 2 (The 'finally' block's return *overrides* the 'try' block's return)
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code?\n\npublic static void main(String[] args) {\n  System.out.println(1.0 / 0.0);\n}",
                new String[] {
                        "1. ArithmeticException",
                        "2. 0.0",
                        "3. Infinity",
                        "4. NaN (Not a Number)"
                },
                2, // 3. Infinity (Floating-point division by zero is allowed)
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code?\n\npublic static void main(String[] args) {\n  System.out.println(0.0 / 0.0);\n}",
                new String[] {
                        "1. ArithmeticException",
                        "2. 0.0",
                        "3. Infinity",
                        "4. NaN (Not a Number)"
                },
                3, // 4. NaN
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code?\n\npublic static void main(String[] args) {\n  System.out.println(Math.sqrt(-1));\n}",
                new String[] {
                        "1. ArithmeticException",
                        "2. 1.0",
                        "3. -1.0",
                        "4. NaN (Not a Number)"
                },
                3, // 4. NaN
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the output of this code?\n\nString str = \"a\";\nswitch (str) {\n  case \"a\": System.out.print(\"1\");\n  case \"b\": System.out.print(\"2\");\n  case \"c\": System.out.print(\"3\");\n}",
                new String[] {
                        "1. 1",
                        "2. 12",
                        "3. 123",
                        "4. Compile Error"
                },
                2, // 3. 123 (Switch "falls through" because there are no 'break' statements)
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        javaDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the 'diamond operator' (<>) in Java?",
                new String[] {
                        "1. An operator for bitwise XOR.",
                        "2. A way to create 2D arrays.",
                        "3. A type of loop in the Stream API.",
                        "4. A shortcut for type inference in generic instance creation (e.g., new ArrayList<>())."
                },
                3, // 4.
                Subject.JAVA,
                Difficulty.DIFFICULT
        ));

        /// DATA_STRUCTURES: EASY

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "Which data structure uses LIFO (Last-In, First-Out) behavior?",
                new String[] {
                        "1. Queue",
                        "2. Stack",
                        "3. Array",
                        "4. Linked List"
                },
                1, // 2. Stack
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "Which data structure uses FIFO (First-In, First-Out) behavior?",
                new String[] {
                        "1. Queue",
                        "2. Stack",
                        "3. Tree",
                        "4. Graph"
                },
                0, // 1. Queue
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the term for adding an element to a Stack?",
                new String[] {
                        "1. Enqueue",
                        "2. Offer",
                        "3. Push",
                        "4. Add"
                },
                2, // 3. Push
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the term for removing an element from a Stack?",
                new String[] {
                        "1. Dequeue",
                        "2. Poll",
                        "3. Remove",
                        "4. Pop"
                },
                3, // 4. Pop
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the term for adding an element to the end of a Queue?",
                new String[] {
                        "1. Enqueue",
                        "2. Push",
                        "3. Pop",
                        "4. Peek"
                },
                0, // 1. Enqueue
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the term for removing an element from the front of a Queue?",
                new String[] {
                        "1. Push",
                        "2. Pop",
                        "3. Dequeue",
                        "4. Peek"
                },
                2, // 3. Dequeue
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "Which data structure is best for storing a list of items that you can access by an index (e.g., item[5])?",
                new String[] {
                        "1. Array",
                        "2. Stack",
                        "3. Queue",
                        "4. Tree"
                },
                0, // 1. Array
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the main disadvantage of a fixed-size Array?",
                new String[] {
                        "1. It is slow to access elements",
                        "2. Its size cannot be changed after creation",
                        "3. It cannot store duplicate elements",
                        "4. It must store elements in sorted order"
                },
                1, // 2.
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "In a Linked List, what does each 'node' contain?",
                new String[] {
                        "1. Only the data",
                        "2. Only a pointer to the next node",
                        "3. The data and a pointer to the next node",
                        "4. A pointer to the previous node"
                },
                2, // 3.
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the first node in a Linked List called?",
                new String[] {
                        "1. Root",
                        "2. Head",
                        "3. Top",
                        "4. Start"
                },
                1, // 2. Head
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "What does the 'head' pointer point to if the Linked List is empty?",
                new String[] {
                        "1. The first element",
                        "2. Itself",
                        "3. null",
                        "4. An error is thrown"
                },
                2, // 3. null
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the time complexity of accessing an element in an Array by its index?",
                new String[] {
                        "1. O(1)",
                        "2. O(n)",
                        "3. O(log n)",
                        "4. O(n^2)"
                },
                0, // 1. O(1) (Constant time)
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the worst-case time complexity of searching for an element in an unsorted Array?",
                new String[] {
                        "1. O(1)",
                        "2. O(n)",
                        "3. O(log n)",
                        "4. O(n^2)"
                },
                1, // 2. O(n) (Linear time)
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "In a Singly Linked List, which operation is the slowest?",
                new String[] {
                        "1. Adding an element to the front (head)",
                        "2. Adding an element to the end (tail)",
                        "3. Reading the first element",
                        "4. All are equally fast"
                },
                1, // 2. (You have to traverse the entire list to find the end: O(n))
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "Which data structure is non-linear?",
                new String[] {
                        "1. Array",
                        "2. Stack",
                        "3. Queue",
                        "4. Tree"
                },
                3, // 4. Tree
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "In a Binary Tree, what is the maximum number of children a node can have?",
                new String[] {
                        "1. 1",
                        "2. 2",
                        "3. 3",
                        "4. Unlimited"
                },
                1, // 2. 2
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the top-most node in a Tree called?",
                new String[] {
                        "1. Head",
                        "2. Top",
                        "3. Root",
                        "4. Parent"
                },
                2, // 3. Root
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "What are the nodes at the very bottom of a Tree (with no children) called?",
                new String[] {
                        "1. Leaves",
                        "2. Children",
                        "3. Roots",
                        "4. Branches"
                },
                0, // 1. Leaves
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "A 'Binary Search Tree' (BST) is a binary tree where...",
                new String[] {
                        "1. All nodes are in sorted order",
                        "2. The left child's value is always less than the parent's, and the right child's is greater",
                        "3. It is always perfectly balanced",
                        "4. All leaf nodes are at the same level"
                },
                1, // 2.
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "What is a 'Hash Table' (like HashMap) used for?",
                new String[] {
                        "1. Storing data in a sorted list",
                        "2. Storing data in a LIFO structure",
                        "3. Storing key-value pairs for fast lookup",
                        "4. Storing data in a tree structure"
                },
                2, // 3.
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "What is a 'hash collision'?",
                new String[] {
                        "1. When two keys are identical",
                        "2. When two keys hash to the same storage index",
                        "3. When two values are identical",
                        "4. When the hash table is full"
                },
                1, // 2.
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "A 'Graph' data structure consists of...",
                new String[] {
                        "1. A Root and Leaves",
                        "2. Keys and Values",
                        "3. Nodes (or Vertices) and Edges",
                        "4. A Head and a Tail"
                },
                2, // 3.
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "What does 'Big O' notation (e.g., O(n)) represent?",
                new String[] {
                        "1. The exact time an algorithm takes",
                        "2. The 'worst-case' time complexity (how it scales)",
                        "3. The 'best-case' time complexity",
                        "4. The amount of memory an algorithm uses"
                },
                1, // 2.
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "Which algorithm is used for searching in a *sorted* array?",
                new String[] {
                        "1. Linear Search",
                        "2. Binary Search",
                        "3. Merge Sort",
                        "4. Bubble Sort"
                },
                1, // 2. Binary Search
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));

        dsEasyQuestions.add(new MultipleChoiceQuestion(
                "Which of these is NOT a sorting algorithm?",
                new String[] {
                        "1. Bubble Sort",
                        "2. Merge Sort",
                        "3. Linear Search",
                        "4. Quick Sort"
                },
                2, // 3. Linear Search (it's a searching algorithm)
                Subject.DATA_STRUCTURES,
                Difficulty.EASY
        ));


        /// DATA_STRUCTURES: MEDIUM

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "When would you prefer a LinkedList over an ArrayList?",
                new String[] {
                        "1. When you need fast random access by index (e.g., get(i))",
                        "2. When you have a small, fixed-size list",
                        "3. When you have frequent insertions and deletions in the middle of the list",
                        "4. When you want to minimize memory usage"
                },
                2, // 3. (LinkedList is O(1) for insertion/deletion, ArrayList is O(n))
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the time complexity for accessing an element by index in an ArrayList?",
                new String[] {
                        "1. O(1)",
                        "2. O(n)",
                        "3. O(log n)",
                        "4. O(n^2)"
                },
                0, // 1. O(1) (Constant time)
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the *worst-case* time complexity for accessing an element by index in a Singly LinkedList?",
                new String[] {
                        "1. O(1)",
                        "2. O(n)",
                        "3. O(log n)",
                        "4. O(n^2)"
                },
                1, // 2. O(n) (You may have to traverse the whole list)
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the time complexity of inserting a new element into a *sorted* array?",
                new String[] {
                        "1. O(1)",
                        "2. O(n)",
                        "3. O(log n)",
                        "4. O(n^2)"
                },
                1, // 2. O(n) (You must find the spot (O(log n)) but then shift elements (O(n)))
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "Which real-world scenario is a good example of a Queue?",
                new String[] {
                        "1. A web browser's 'Back' button history",
                        "2. A print spooler (handling print jobs in order)",
                        "3. A call stack for recursive functions",
                        "4. A system for undo/redo in a text editor"
                },
                1, // 2. (First-In, First-Out)
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "Which real-world scenario is a good example of a Stack?",
                new String[] {
                        "1. A line of people at a movie theater",
                        "2. A print spooler",
                        "3. A web browser's 'Back' button history",
                        "4. A list of players waiting to join a game"
                },
                2, // 3. (Last-In, First-Out)
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "How does a PriorityQueue differ from a regular Queue?",
                new String[] {
                        "1. It is LIFO instead of FIFO",
                        "2. It does not allow duplicate elements",
                        "3. Elements are dequeued based on 'priority' rather than FIFO order",
                        "4. It is much faster for all operations"
                },
                2, // 3.
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the output of an 'in-order' traversal of a Binary Search Tree (BST)?",
                new String[] {
                        "1. The elements in reverse-sorted order",
                        "2. The elements in sorted order",
                        "3. The elements in the order they were inserted",
                        "4. The elements level-by-level"
                },
                1, // 2. (Left, Root, Right)
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "What is a 'full' binary tree?",
                new String[] {
                        "1. A tree where all leaf nodes are at the same level",
                        "2. A tree where every node has exactly 0 or 2 children",
                        "3. A tree where the left child is always smaller than the right",
                        "4. A tree that is perfectly balanced"
                },
                1, // 2.
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the worst-case time complexity for search in a Binary Search Tree (BST)?",
                new String[] {
                        "1. O(1)",
                        "2. O(log n)",
                        "3. O(n)",
                        "4. O(n^2)"
                },
                2, // 3. O(n) (If the tree is 'degenerate' and becomes a linked list)
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the primary advantage of a *balanced* BST (like an AVL or Red-Black Tree)?",
                new String[] {
                        "1. It is easier to implement than a normal BST",
                        "2. It uses less memory",
                        "3. It guarantees O(log n) time complexity for search, insert, and delete",
                        "4. It stores elements in FIFO order"
                },
                2, // 3.
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "In a 'Min-Heap', what is the relationship between a parent node and its children?",
                new String[] {
                        "1. The parent's value is always *greater* than its children's values",
                        "2. The parent's value is always *less than* its children's values",
                        "3. The left child is smaller, the right child is larger",
                        "4. There is no guaranteed relationship"
                },
                1, // 2.
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "What is 'Separate Chaining' used for in a Hash Table?",
                new String[] {
                        "1. To make the hash function faster",
                        "2. To sort the elements in the table",
                        "3. To handle hash collisions by storing colliding elements in a list at the same index",
                        "4. To double the size of the hash table when it gets full"
                },
                2, // 3.
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "What is 'Linear Probing' used for in a Hash Table?",
                new String[] {
                        "1. To handle hash collisions by searching for the next empty slot in the array",
                        "2. To create a linked list of all elements",
                        "3. To search the hash table element by element (linearly)",
                        "4. To make the hash function more complex"
                },
                0, // 1. (It's a form of 'Open Addressing')
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the primary goal of a good hash function?",
                new String[] {
                        "1. To always produce a unique hash for every key (a 'perfect' hash)",
                        "2. To distribute keys as evenly as possible across the hash table",
                        "3. To be reversible (so you can get the key from the hash)",
                        "4. To be a very fast O(1) calculation"
                },
                1, // 2. (Minimizing collisions is the goal; perfect hashes are rare)
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "How is a Java 'HashSet' typically implemented internally?",
                new String[] {
                        "1. It is backed by an ArrayList",
                        "2. It is backed by a balanced binary tree (like TreeSet)",
                        "3. It is backed by a HashMap (using keys for storage and a dummy value)",
                        "4. It is a simple array"
                },
                2, // 3.
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the average AND worst-case time complexity of Bubble Sort?",
                new String[] {
                        "1. O(n log n)",
                        "2. O(n)",
                        "3. O(n^2)",
                        "4. O(log n)"
                },
                2, // 3. O(n^2)
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the *best-case* time complexity of Bubble Sort?",
                new String[] {
                        "1. O(1)",
                        "2. O(n) (if the list is already sorted and an 'optimized' version is used)",
                        "3. O(n log n)",
                        "4. O(n^2)"
                },
                1, // 2. (With a flag, it makes one pass and exits)
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the core strategy used by Merge Sort?",
                new String[] {
                        "1. Swapping adjacent elements until sorted",
                        "2. Selecting a 'pivot' and partitioning the array",
                        "3. Building a 'heap' and extracting the max element",
                        "4. 'Divide and Conquer': recursively splitting and merging sorted subarrays"
                },
                3, // 4.
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the time complexity of Merge Sort in all cases?",
                new String[] {
                        "1. O(n)",
                        "2. O(n log n)",
                        "3. O(n^2)",
                        "4. O(log n)"
                },
                1, // 2.
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "What is a 'pivot' element in the Quick Sort algorithm?",
                new String[] {
                        "1. The smallest element in the array",
                        "2. The largest element in the array",
                        "3. An element chosen to partition the array (elements smaller on one side, larger on the other)",
                        "4. The middle element, which is already sorted"
                },
                2, // 3.
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the *best-case* time complexity of Insertion Sort?",
                new String[] {
                        "1. O(n)",
                        "2. O(n log n)",
                        "3. O(n^2)",
                        "4. O(1)"
                },
                0, // 1. O(n) (When the array is already sorted)
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "In graph theory, what is an 'Adjacency Matrix'?",
                new String[] {
                        "1. A 2D array where matrix[i][j] is 1 if there is an edge from node i to node j",
                        "2. A list where each node stores a list of its neighbors",
                        "3. A stack of all nodes in the graph",
                        "4. A tree representing the shortest path"
                },
                0, // 1.
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "In graph theory, what is an 'Adjacency List'?",
                new String[] {
                        "1. A 2D array representing all edges",
                        "2. A list where each node stores a list of its neighbors",
                        "3. A queue of all nodes in the graph",
                        "4. A list of all edges, sorted by weight"
                },
                1, // 2.
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));

        dsMediumQuestions.add(new MultipleChoiceQuestion(
                "Which graph traversal algorithm uses a Stack?",
                new String[] {
                        "1. Breadth-First Search (BFS)",
                        "2. Depth-First Search (DFS)",
                        "3. Dijkstra's Algorithm",
                        "4. Prim's Algorithm"
                },
                1, // 2. (Either explicitly, or implicitly via recursion)
                Subject.DATA_STRUCTURES,
                Difficulty.MEDIUM
        ));


        /// DATA_STRUCTURES: DIFFICULT

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the time complexity of building a Binary Heap from an unsorted array of 'n' elements (heapify)?",
                new String[] {
                        "1. O(n log n)",
                        "2. O(n^2)",
                        "3. O(n)",
                        "4. O(log n)"
                },
                2, // 3. O(n) (This is a non-obvious, important fact)
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "In a binary heap, what is the time complexity of finding an arbitrary element (not the min/max)?",
                new String[] {
                        "1. O(1)",
                        "2. O(log n)",
                        "3. O(n)",
                        "4. O(n log n)"
                },
                2, // 3. O(n) (A heap is not a search tree; you must check every element in the worst case)
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the worst-case time complexity of QuickSort?",
                new String[] {
                        "1. O(n log n)",
                        "2. O(n)",
                        "3. O(n^2)",
                        "4. O(log n)"
                },
                2, // 3. O(n^2)
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "When does the O(n^2) worst-case for QuickSort occur?",
                new String[] {
                        "1. When the array is completely random",
                        "2. When the array is already sorted (and the pivot is chosen badly, e.g., first element)",
                        "3. When the array contains many duplicate elements",
                        "4. The worst case is only theoretical and never occurs"
                },
                1, // 2.
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the key property of an AVL Tree?",
                new String[] {
                        "1. The heights of the left and right subtrees of any node differ by at most 1",
                        "2. Every node is either 'Red' or 'Black'",
                        "3. It is a 'perfect' binary tree",
                        "4. It is implemented using an array"
                },
                0, // 1.
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is 'amortized' time complexity?",
                new String[] {
                        "1. The best-case time complexity",
                        "2. The worst-case time complexity",
                        "3. The time complexity for an algorithm that runs in parallel",
                        "4. The average time for a *sequence* of operations, even if one operation is slow"
                },
                3, // 4.
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is a real-world example of 'amortized O(1)' complexity?",
                new String[] {
                        "1. Searching a balanced BST",
                        "2. Accessing an array element by index",
                        "3. Adding an element to an ArrayList (which occasionally resizes)",
                        "4. Sorting with MergeSort"
                },
                2, // 3. (Most adds are O(1), a few are O(n))
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "Which graph algorithm can be used to detect a cycle in an *undirected* graph?",
                new String[] {
                        "1. Dijkstra's Algorithm",
                        "2. Prim's Algorithm",
                        "3. Depth-First Search (DFS)",
                        "4. Bellman-Ford Algorithm"
                },
                2, // 3. (By checking for a 'back-edge' to an already visited node)
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "Dijkstra's shortest path algorithm will not work correctly with...",
                new String[] {
                        "1. Directed graphs",
                        "2. Cyclic graphs",
                        "3. Graphs with negative edge weights",
                        "4. Disconnected graphs"
                },
                2, // 3.
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "Which algorithm *can* find the shortest path in a graph with negative edge weights (but no negative cycles)?",
                new String[] {
                        "1. Dijkstra's Algorithm",
                        "2. Bellman-Ford Algorithm",
                        "3. Prim's Algorithm",
                        "4. Breadth-First Search (BFS)"
                },
                1, // 2.
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the time complexity of Dijkstra's algorithm using a PriorityQueue (Binary Heap)?",
                new String[] {
                        "1. O(V + E)",
                        "2. O(V^2)",
                        "3. O(E log V)",
                        "4. O(V log E)"
                },
                2, // 3. (O(V log V + E log V) which simplifies to O(E log V))
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the primary data structure used in Kruskal's algorithm to efficiently detect cycles?",
                new String[] {
                        "1. A Stack",
                        "2. A Priority Queue",
                        "3. An Adjacency Matrix",
                        "4. A Union-Find (Disjoint Set) data structure"
                },
                3, // 4.
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the space complexity of an Adjacency List for a graph with V vertices and E edges?",
                new String[] {
                        "1. O(V^2)",
                        "2. O(E^2)",
                        "3. O(V * E)",
                        "4. O(V + E)"
                },
                3, // 4.
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the space complexity of an Adjacency Matrix for a graph with V vertices and E edges?",
                new String[] {
                        "1. O(V^2)",
                        "2. O(V + E)",
                        "3. O(V)",
                        "4. O(E)"
                },
                0, // 1. (It doesn't depend on E)
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "For which type of graph is an Adjacency Matrix *more* space-efficient than an Adjacency List?",
                new String[] {
                        "1. A sparse graph (few edges)",
                        "2. A dense graph (many edges, E is close to V^2)",
                        "3. A tree",
                        "4. A disconnected graph"
                },
                1, // 2.
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is a 'Trie' (Prefix Tree) data structure optimized for?",
                new String[] {
                        "1. Sorting a list of numbers",
                        "2. Storing key-value pairs with fast lookup",
                        "3. Storing and searching for strings based on their prefixes",
                        "4. Finding the shortest path in a graph"
                },
                2, // 3.
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the time complexity of searching for a word of length 'k' in a Trie?",
                new String[] {
                        "1. O(k) (proportional to the word's length)",
                        "2. O(n) (proportional to the number of words in the trie)",
                        "3. O(log n)",
                        "4. O(1)"
                },
                0, // 1. (This is its main advantage - it's independent of 'n')
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "Which graph traversal algorithm is best for finding the shortest path in an *unweighted* graph?",
                new String[] {
                        "1. Depth-First Search (DFS)",
                        "2. Breadth-First Search (BFS)",
                        "3. Dijkstra's Algorithm",
                        "4. Bellman-Ford Algorithm"
                },
                1, // 2. (BFS explores level by level, guaranteeing the first time it finds the end is the shortest path)
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "Which of these sorting algorithms is *not* a 'comparison-based' sort?",
                new String[] {
                        "1. Merge Sort",
                        "2. Quick Sort",
                        "3. Heap Sort",
                        "4. Counting Sort"
                },
                3, // 4. (Counting Sort, Radix Sort, Bucket Sort are non-comparison)
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the theoretical *best* time complexity for a comparison-based sorting algorithm?",
                new String[] {
                        "1. O(n)",
                        "2. O(n log n)",
                        "3. O(n^2)",
                        "4. O(1)"
                },
                1, // 2. (This is the lower bound, which MergeSort and HeapSort achieve)
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "In a 0-indexed array representing a Binary Heap, if a node is at index 'i', where is its parent?",
                new String[] {
                        "1. (i / 2)",
                        "2. (i - 1) / 2",
                        "3. (i + 1) / 2",
                        "4. (i * 2) + 1"
                },
                1, // 2. (Integer division)
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "In a 0-indexed array representing a Binary Heap, if a node is at index 'i', where is its *left* child?",
                new String[] {
                        "1. (i / 2)",
                        "2. (i - 1) / 2",
                        "3. (2 * i) + 1",
                        "4. (2 * i)"
                },
                2, // 3.
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "Which sorting algorithm is 'in-place' and has an average-case time of O(n log n)?",
                new String[] {
                        "1. Merge Sort",
                        "2. Quick Sort",
                        "3. Insertion Sort",
                        "4. Bubble Sort"
                },
                1, // 2. (Merge Sort is O(n log n) but is not in-place)
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is a 'Topological Sort' used for?",
                new String[] {
                        "1. Sorting a nearly-sorted list very quickly",
                        "2. Sorting elements in a Binary Search Tree",
                        "3. Finding a linear ordering of a *Directed Acyclic Graph* (DAG) based on dependencies",
                        "4. Sorting elements in a Stack"
                },
                2, // 3. (e.g., ordering tasks, class prerequisites)
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));

        dsDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the key difference between a 'B-Tree' and a 'Binary Search Tree' (BST)?",
                new String[] {
                        "1. B-Trees are not sorted",
                        "2. B-Trees are always binary (max 2 children)",
                        "3. B-Trees can have *many* children and keys per node, and are optimized for disk I/O",
                        "4. B-Trees are used for sorting, while BSTs are used for searching"
                },
                2, // 3. (This is why they are used in databases and filesystems)
                Subject.DATA_STRUCTURES,
                Difficulty.DIFFICULT
        ));


        /// NETWORKING: EASY
        // --- NETWORKING: EASY (Batch 1) ---

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What does 'LAN' stand for?",
                new String[] {
                        "1. Local Area Network",
                        "2. Long Area Network",
                        "3. Linked Access Network",
                        "4. Local Access Naming"
                },
                0, // 1.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What does 'WAN' stand for?",
                new String[] {
                        "1. Wireless Area Network",
                        "2. Wide Area Network",
                        "3. Wired Access Network",
                        "4. World Area Network"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What is an 'IP Address'?",
                new String[] {
                        "1. A physical hardware address",
                        "2. A unique logical address for a device on a network",
                        "3. A type of network cable",
                        "4. A website name (like google.com)"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What does 'IP' stand for?",
                new String[] {
                        "1. Internet Protocol",
                        "2. Internal Protocol",
                        "3. Internet Provider",
                        "4. Internet Page"
                },
                0, // 1.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What does 'DNS' stand for?",
                new String[] {
                        "1. Digital Network Service",
                        "2. Domain Name System",
                        "3. Data Naming Service",
                        "4. Dynamic Network System"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the job of DNS?",
                new String[] {
                        "1. To secure your network connection",
                        "2. To assign IP addresses to devices",
                        "3. To translate domain names (like google.com) into IP addresses",
                        "4. To speed up your internet connection"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What is a 'server'?",
                new String[] {
                        "1. A computer that provides data or services to other computers (clients)",
                        "2. A computer that is used to browse the internet",
                        "3. A type of network firewall",
                        "4. The main computer in your home"
                },
                0, // 1.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What is a 'client' in a network?",
                new String[] {
                        "1. A computer that provides services to other computers",
                        "2. The owner of the network",
                        "3. A computer or program that requests data or services from a server",
                        "4. A type of network"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What piece of hardware connects a local network (LAN) to the internet (WAN)?",
                new String[] {
                        "1. A CPU",
                        "2. A Monitor",
                        "3. A Router",
                        "4. A Hard Drive"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What does 'HTTP' stand for?",
                new String[] {
                        "1. HyperText Transfer Protocol",
                        "2. High-Tech Text Protocol",
                        "3. Home Transfer Text Protocol",
                        "4. Hyperlink Text Transfer Page"
                },
                0, // 1.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What does 'HTTPS' stand for?",
                new String[] {
                        "1. HyperText Transfer Protocol Secure",
                        "2. HyperText Transfer Protocol Simple",
                        "3. HyperText Transfer Page Secure",
                        "4. HyperText Transfer Site"
                },
                0, // 1.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the 'S' in 'HTTPS' for?",
                new String[] {
                        "1. 'Simple'",
                        "2. 'Speed'",
                        "3. 'Server'",
                        "4. 'Secure' (it means the connection is encrypted)"
                },
                3, // 4.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What is a 'MAC Address'?",
                new String[] {
                        "1. An IP address for Apple computers",
                        "2. A unique physical hardware address burned into a network card",
                        "3. A type of network protocol",
                        "4. A software-based address that changes frequently"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What is a 'firewall' used for?",
                new String[] {
                        "1. To speed up your internet",
                        "2. To store your files",
                        "3. To block unauthorized access to a network",
                        "4. To connect to Wi-Fi"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "Which of these is an example of an IPv4 address?",
                new String[] {
                        "1. 192.168.1.1",
                        "2. 00-1A-2B-3C-4D-5E",
                        "3. google.com",
                        "4. 2001:0db8:85a3:0000:0000:8a2e:0370:7334"
                },
                0, // 1.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What is 'Wi-Fi'?",
                new String[] {
                        "1. A type of internet service",
                        "2. A wired network connection",
                        "3. A technology that allows devices to connect to a network wirelessly",
                        "4. A type of computer"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What does 'URL' stand for?",
                new String[] {
                        "1. Uniform Resource Locator",
                        "2. Universal Resource Link",
                        "3. Uniform Resource Link",
                        "4. Universal Request Locator"
                },
                0, // 1.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What is a 'protocol' in networking?",
                new String[] {
                        "1. A physical device",
                        "2. A type of software",
                        "3. A set of rules that govern how data is transmitted",
                        "4. A type of network error"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What does 'TCP' stand for?",
                new String[] {
                        "1. Test Control Protocol",
                        "2. Transmission Control Protocol",
                        "3. Transfer Command Protocol",
                        "4. Text Control Protocol"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the main characteristic of TCP?",
                new String[] {
                        "1. It is very fast and unreliable (sends data without checking)",
                        "2. It is reliable and connection-oriented (guarantees delivery)",
                        "3. It is only used for sending email",
                        "4. It is only used for wireless networks"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What does 'UDP' stand for?",
                new String[] {
                        "1. User Datagram Protocol",
                        "2. Universal Data Protocol",
                        "3. User Data Packet",
                        "4. Unique Datagram Protocol"
                },
                0, // 1.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What is the main characteristic of UDP?",
                new String[] {
                        "1. It is very reliable and checks every packet",
                        "2. It is connection-oriented",
                        "3. It is connectionless and fast, but does not guarantee delivery",
                        "4. It is used to create firewalls"
                },
                2, // 3. (Good for video streaming or gaming)
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What is an 'ISP'?",
                new String[] {
                        "1. Internet Service Provider",
                        "2. Internal System Protocol",
                        "3. Internet Security Protocol",
                        "4. Internet Server Provider"
                },
                0, // 1.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What is 'bandwidth'?",
                new String[] {
                        "1. The speed of your computer's CPU",
                        "2. The physical length of a network cable",
                        "3. The maximum amount of data that can be transferred over a network in a given time",
                        "4. A type of network security"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        networkingEasyQuestions.add(new MultipleChoiceQuestion(
                "What is 'latency' (or 'ping')?",
                new String[] {
                        "1. The maximum download speed",
                        "2. The delay (time) it takes for data to travel from one point to another",
                        "3. A type of computer virus",
                        "4. The amount of data you can download"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.EASY
        ));

        /// NETWORKING: MEDIUM

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the main difference between TCP and UDP?",
                new String[] {
                        "1. TCP is faster, but UDP is more reliable",
                        "2. TCP is connection-oriented (reliable), UDP is connectionless (fast)",
                        "3. TCP is for video streaming, UDP is for websites",
                        "4. TCP uses IP addresses, UDP uses MAC addresses"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the 'three-way handshake' in TCP?",
                new String[] {
                        "1. A process to end a connection (FIN, FIN-ACK, ACK)",
                        "2. A process to check for errors (REQ, RES, ACK)",
                        "3. A process to establish a connection (SYN, SYN-ACK, ACK)",
                        "4. A process to find the fastest route"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "Which layer of the OSI model is responsible for routing packets?",
                new String[] {
                        "1. Layer 1 (Physical Layer)",
                        "2. Layer 2 (Data Link Layer)",
                        "3. Layer 3 (Network Layer)",
                        "4. Layer 4 (Transport Layer)"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "Which layer of the OSI model handles 'port numbers' and protocols like TCP/UDP?",
                new String[] {
                        "1. Layer 3 (Network Layer)",
                        "2. Layer 4 (Transport Layer)",
                        "3. Layer 5 (Session Layer)",
                        "4. Layer 7 (Application Layer)"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "Which layer of the OSI model handles 'MAC Addresses' and physical framing?",
                new String[] {
                        "1. Layer 1 (Physical Layer)",
                        "2. Layer 2 (Data Link Layer)",
                        "3. Layer 3 (Network Layer)",
                        "4. Layer 4 (Transport Layer)"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "Which layer of the OSI model includes protocols like HTTP and FTP?",
                new String[] {
                        "1. Layer 3 (Network Layer)",
                        "2. Layer 4 (Transport Layer)",
                        "3. Layer 5 (Session Layer)",
                        "4. Layer 7 (Application Layer)"
                },
                3, // 4.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the purpose of a 'port number' in networking?",
                new String[] {
                        "1. To identify a specific device on the network",
                        "2. To identify a specific application or service on a device",
                        "3. To identify the physical hardware of a network card",
                        "4. To identify the user of a device"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the standard port number for HTTP (unsecured web traffic)?",
                new String[] {
                        "1. 22",
                        "2. 25",
                        "3. 80",
                        "4. 443"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the standard port number for HTTPS (secure web traffic)?",
                new String[] {
                        "1. 80",
                        "2. 443",
                        "3. 8080",
                        "4. 21"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the purpose of a 'Subnet Mask' (e.g., 255.255.255.0)?",
                new String[] {
                        "1. To hide the IP address from hackers",
                        "2. To divide an IP address into a 'network' part and a 'host' part",
                        "3. To encrypt the data being sent",
                        "4. To assign a port number to an application"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What is 'DHCP' used for?",
                new String[] {
                        "1. To translate domain names into IP addresses",
                        "2. To automatically assign IP addresses to devices on a network",
                        "3. To encrypt network traffic securely",
                        "4. To send email"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What is 'NAT' (Network Address Translation)?",
                new String[] {
                        "1. A protocol for secure file transfers",
                        "2. A protocol for sending email",
                        "3. A way to translate domain names to IP addresses (like DNS)",
                        "4. A way to allow multiple devices on a private network to share a single public IP address"
                },
                3, // 4.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the 'localhost' IP address, which always refers to your own computer?",
                new String[] {
                        "1. 192.168.0.1",
                        "2. 1.1.1.1",
                        "3. 127.0.0.1",
                        "4. 0.0.0.0"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What protocol is used to send email?",
                new String[] {
                        "1. HTTP",
                        "2. FTP",
                        "3. SMTP",
                        "4. POP3"
                },
                2, // 3. SMTP (Simple Mail Transfer Protocol)
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What protocol is commonly used to retrieve email from a mail server?",
                new String[] {
                        "1. HTTP",
                        "2. FTP",
                        "3. SMTP",
                        "4. POP3 or IMAP"
                },
                3, // 4.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What does 'FTP' stand for?",
                new String[] {
                        "1. Fast Transfer Protocol",
                        "2. File Transfer Protocol",
                        "3. Folder Transfer Protocol",
                        "4. File Text Protocol"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What is a 'packet' in networking?",
                new String[] {
                        "1. A complete, unchangeable file",
                        "2. A small, fixed-size unit of data transmitted over a network",
                        "3. A type of network error",
                        "4. A physical network connector"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What is a 'port scan'?",
                new String[] {
                        "1. An attempt to find open, listening ports on a server, often for malicious reasons",
                        "2. A normal part of the TCP handshake",
                        "3. A method for speeding up a network connection",
                        "4. A way to change your IP address"
                },
                0, // 1.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What does 'IPv6' do that IPv4 doesn't?",
                new String[] {
                        "1. It is slower but more secure",
                        "2. It uses 32-bit addresses",
                        "3. It provides a vastly larger number of unique IP addresses (using 128-bit addresses)",
                        "4. It is only for wireless devices"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What is a 'VPN' (Virtual Private Network)?",
                new String[] {
                        "1. A private, internal network for a company's office (like a LAN)",
                        "2. A service that encrypts your internet traffic and routes it through a remote server",
                        "3. A type of hardware router",
                        "4. A protocol for assigning IP addresses"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What is the 'Default Gateway' in network settings?",
                new String[] {
                        "1. Your computer's IP address",
                        "2. The IP address of your ISP",
                        "3. The IP address of the router on your local network (the 'exit' to the internet)",
                        "4. The IP address of the DNS server"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "Which protocol is typically used for online gaming or video streaming, where speed is more important than perfect reliability?",
                new String[] {
                        "1. TCP",
                        "2. UDP",
                        "3. HTTP",
                        "4. FTP"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What is a 'socket' in programming?",
                new String[] {
                        "1. A physical port on a router",
                        "2. The combination of an IP address and a port number (e.g., 127.0.0.1:80)",
                        "3. A hardware component for networking",
                        "4. Another name for a MAC address"
                },
                1, // 2. (It's the endpoint for communication)
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What is a 'hub' in networking (a now-outdated device)?",
                new String[] {
                        "1. A smart device that sends data only to the intended computer",
                        "2. A 'dumb' device that repeats all data it receives to all connected computers",
                        "3. A device that connects a LAN to the internet",
                        "4. A device that encrypts data"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        networkingMediumQuestions.add(new MultipleChoiceQuestion(
                "What is a 'switch' (a more modern device than a hub)?",
                new String[] {
                        "1. A 'dumb' device that repeats data to all ports",
                        "2. A 'smart' device that learns MAC addresses and sends data only to the intended port",
                        "3. A device that assigns IP addresses",
                        "4. A device that blocks all network traffic"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.MEDIUM
        ));

        /// NETWORKING: DIFFICULT

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the output of the 'ping 127.0.0.1' command?",
                new String[] {
                        "1. It sends packets to the router (default gateway)",
                        "2. It sends packets to the DNS server",
                        "3. It sends packets to your computer's own network card (the loopback address)",
                        "4. It broadcasts packets to the entire local network"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "In the TCP 3-way handshake, what is the correct sequence of flags sent?",
                new String[] {
                        "1. SYN -> ACK -> SYN-ACK",
                        "2. SYN -> SYN-ACK -> ACK",
                        "3. ACK -> SYN -> ACK-SYN",
                        "4. SYN -> FIN -> ACK"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is a 'FIN' packet used for in TCP?",
                new String[] {
                        "1. To start a connection",
                        "2. To signal an error and reset the connection",
                        "3. To gracefully terminate a connection",
                        "4. To acknowledge a received packet"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is a 'RST' (Reset) packet used for in TCP?",
                new String[] {
                        "1. To gracefully terminate a connection",
                        "2. To immediately abort a connection, often due to an error or invalid port",
                        "3. To resend a lost packet",
                        "4. To start a new connection"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the 'Time to Live' (TTL) field in an IP packet?",
                new String[] {
                        "1. The time in seconds the packet is allowed to exist",
                        "2. The number of routers (hops) the packet can pass through before being discarded",
                        "3. The time until the packet's data expires",
                        "4. The number of devices on the destination network"
                },
                1, // 2. (Prevents infinite loops)
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "Which protocol is responsible for resolving an IP address into a MAC address on a local network?",
                new String[] {
                        "1. DNS (Domain Name System)",
                        "2. DHCP (Dynamic Host Configuration Protocol)",
                        "3. ARP (Address Resolution Protocol)",
                        "4. NAT (Network Address Translation)"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is a 'Man-in-the-Middle' (MITM) attack?",
                new String[] {
                        "1. A type of virus that infects the OS kernel",
                        "2. An attack where the attacker secretly intercepts and relays communication between two parties",
                        "3. An attack that floods a server with too many requests",
                        "4. An attack where a hacker guesses passwords"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is a 'DDoS' (Distributed Denial of Service) attack?",
                new String[] {
                        "1. An attack to steal passwords",
                        "2. An attack to intercept data",
                        "3. An attack that attempts to make a server unavailable by overwhelming it with traffic from many sources",
                        "4. An attack that modifies data inside a database"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the difference between a 'public' IP address and a 'private' IP address?",
                new String[] {
                        "1. Public IPs are secure (HTTPS), private IPs are not",
                        "2. Public IPs are routable on the global internet, private IPs are only for use within a local network (e.g., 192.168.x.x)",
                        "3. Public IPs are for servers, private IPs are for clients",
                        "4. There is no difference, the terms are interchangeable"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the 'CIDR' notation (e.g., 192.168.1.0/24)?",
                new String[] {
                        "1. A way to represent a MAC address",
                        "2. A way to specify the range of IP addresses in a network (the /24 means a 24-bit subnet mask)",
                        "3. A type of IPv6 address",
                        "4. A protocol for secure communication"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is 'BGP' (Border Gateway Protocol) used for?",
                new String[] {
                        "1. To exchange routing information between autonomous systems (the 'backbone' of the internet)",
                        "2. To assign IP addresses to home computers",
                        "3. To encrypt web traffic",
                        "4. To resolve domain names"
                },
                0, // 1.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the main purpose of ICMP (Internet Control Message Protocol)?",
                new String[] {
                        "1. To transfer large files",
                        "2. To carry all web traffic (like HTTP)",
                        "3. To send error messages and operational information (e.g., 'ping' and 'destination unreachable')",
                        "4. To securely log in to a remote server"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is a 'Socket' in networking (from a programming perspective)?",
                new String[] {
                        "1. The physical hardware port (e.g., RJ45)",
                        "2. An endpoint for communication, consisting of an IP address and a port number",
                        "3. A type of network firewall",
                        "4. The router on a local network"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the difference between 'IMAP' and 'POP3' for retrieving email?",
                new String[] {
                        "1. IMAP is for sending, POP3 is for receiving",
                        "2. POP3 is for sending, IMAP is for receiving",
                        "3. POP3 downloads email and removes it from the server; IMAP syncs email with the server",
                        "4. They are identical protocols"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is a 'load balancer'?",
                new String[] {
                        "1. A device that encrypts all network traffic",
                        "2. A device that distributes incoming network traffic across multiple servers",
                        "3. A device that blocks DDoS attacks",
                        "4. A device that assigns IP addresses"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is 'TLS/SSL' (Transport Layer Security)?",
                new String[] {
                        "1. A protocol for routing packets on the internet",
                        "2. A protocol for assigning IP addresses",
                        "3. A cryptographic protocol designed to provide secure communication over a network (the 'S' in HTTPS)",
                        "4. A protocol for streaming video"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is a 'Certificate Authority' (CA)?",
                new String[] {
                        "1. An organization that manages the assignment of IP addresses",
                        "2. A trusted entity that issues digital certificates to verify the identity of websites (for HTTPS)",
                        "3. The main DNS server for the internet",
                        "4. A type of firewall"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the 'Same-Origin Policy' in web browsers?",
                new String[] {
                        "1. A policy that all web traffic must use the same protocol (e.g., HTTP)",
                        "2. A security policy that prevents a script on one web page from accessing data on another page (unless they share the same 'origin')",
                        "3. A policy that all devices on a network must have the same IP address",
                        "4. A policy that ensures all data is encrypted"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What does 'CORS' (Cross-Origin Resource Sharing) do?",
                new String[] {
                        "1. It is an attack that bypasses the Same-Origin Policy",
                        "2. It is a mechanism that allows a server to relax the Same-Origin Policy and permit requests from other domains",
                        "3. It is a protocol for encrypting all web traffic",
                        "4. It is a way to block all cross-origin requests"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the 'OSI Model'?",
                new String[] {
                        "1. A physical piece of networking hardware",
                        "2. A specific protocol like TCP",
                        "3. A conceptual framework that standardizes the 7 layers of a telecommunication system",
                        "4. A type of network security software"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the difference between a 'proxy' and a 'reverse proxy'?",
                new String[] {
                        "1. A proxy handles outgoing traffic (for clients); a reverse proxy handles incoming traffic (for servers)",
                        "2. A proxy is for HTTP; a reverse proxy is for HTTPS",
                        "3. A proxy is software; a reverse proxy is hardware",
                        "4. There is no difference"
                },
                0, // 1.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "In IPv4, what is the 'broadcast' address for the network 192.168.1.0/24?",
                new String[] {
                        "1. 192.168.1.0",
                        "2. 192.168.1.1",
                        "3. 192.168.1.254",
                        "4. 192.168.1.255"
                },
                3, // 4. (The last address in the subnet is reserved for broadcast)
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is 'packet sniffing'?",
                new String[] {
                        "1. The process of inspecting and logging all data packets that pass over a network",
                        "2. The process of sending out 'ping' requests",
                        "3. The process of compressing data packets",
                        "4. The process of discarding corrupted packets"
                },
                0, // 1.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "Which technology allows you to run multiple virtual LANs on a single physical network switch?",
                new String[] {
                        "1. VPN (Virtual Private Network)",
                        "2. VLAN (Virtual Local Area Network)",
                        "3. NAT (Network Address Translation)",
                        "4. DHCP (Dynamic Host Configuration Protocol)"
                },
                1, // 2.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));

        networkingDifficultQuestions.add(new MultipleChoiceQuestion(
                "What is the purpose of the 'ACK' flag in a TCP packet?",
                new String[] {
                        "1. To request a new connection",
                        "2. To terminate the connection",
                        "3. To acknowledge that a packet was successfully received",
                        "4. To signal that the packet is urgent"
                },
                2, // 3.
                Subject.NETWORKING,
                Difficulty.DIFFICULT
        ));
    }
}