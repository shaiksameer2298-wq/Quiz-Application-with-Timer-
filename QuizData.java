public class QuizData {
    public static Question[] getQuestions() {
        return new Question[] {
            new Question("What is Java?", new String[]{"Language", "Coffee", "Island", "OS"}, 0),
            new Question("Length of String 'JAVA'?", new String[]{"3", "4", "5", "6"}, 1),
            new Question("Who developed Java?", new String[]{"Oracle", "James Gosling", "Sun", "IBM"}, 1),
            new Question("Which one is not OOP concept?", new String[]{"Encapsulation", "Inheritance", "Compilation", "Polymorphism"}, 2),
            new Question("Which method starts execution?", new String[]{"start()", "run()", "init()", "main()"}, 3),

           
            new Question("What does JVM stand for?", new String[]{"Java Virtual Machine", "Java Verified Method", "Joint Virtual Method", "Java Vendor Machine"}, 0),
            new Question("Which keyword is used to inherit a class?", new String[]{"this", "super", "extends", "implements"}, 2),
            new Question("Which of these is not a primitive type?", new String[]{"int", "float", "boolean", "String"}, 3),
            new Question("Which access modifier is the most restrictive?", new String[]{"public", "private", "protected", "default"}, 1),
            new Question("Which loop is guaranteed to run at least once?", new String[]{"for", "while", "do-while", "foreach"}, 2)
        };
    }
}