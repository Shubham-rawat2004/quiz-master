import java.sql.*;
import java.util.Scanner;

public class QuizMaster {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final String URL = "jdbc:mysql://127.0.0.1:3306/Quiz";
        final String USERNAME = "root";
        final String PASSWORD = "Shub@2004";

        System.out.println("Enter your username:");
        String userName = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Login successful");
                int userId = resultSet.getInt("user_id");

                System.out.println("Choose your course:");
                System.out.println("1. FOR MCA");
                System.out.println("2. FOR B.Tech");
                System.out.println("3. FOR MBA");

                int course = sc.nextInt();

                switch (course) {
                    case 1:
                        handleMCA(sc, connection, userId);
                        break;
                    case 2:
                        handleBTech(sc, connection, userId);
                        break;
                    case 3:
                        handleMBA(sc, connection, userId);
                        break;
                    default:
                        System.out.println("Invalid course selection!");
                }
            } else {
                System.out.println("Invalid login credentials");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void handleMCA(Scanner sc, Connection connection, int userId) {
        System.out.println("You have successfully entered the MCA Course");
        System.out.println("a. for JAVA");
        System.out.println("b. for COA");

        String option = sc.nextLine();
        switch (option) {
            case "a":
                runJavaQuiz(sc, connection, userId);
                break;
            case "b":
                runCOAQuiz(sc, connection, userId);
                break;
            default:
                System.out.println("Invalid option!");
        }
    }

    private static void handleBTech(Scanner sc, Connection connection, int userId) {
        System.out.println("You have successfully entered the B.Tech Course");
        System.out.println("1. For Electrical Engineering");
        System.out.println("2. For Python");

        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                runElectricalEngineeringQuiz(sc, connection, userId);
                break;
            case 2:
                runPythonQuiz(sc, connection, userId);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private static void handleMBA(Scanner sc, Connection connection, int userId) {
        System.out.println("You have successfully entered the MBA Course");
        System.out.println("1. Financial Accounting");
        System.out.println("2. Business Environment");

        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                runFinancialAccountingQuiz(sc, connection, userId);
                break;
            case 2:
                runBusinessEnvironmentQuiz(sc, connection, userId);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private static void runJavaQuiz(Scanner sc, Connection connection, int userId) {
        String[] questions = {
                "1. Which of the following is not a Java keyword?",
                "2. What is the size of int in Java?",
                "3. Which company developed Java?",
                "4. Which method is used to print output in Java?"
        };

        String[] options = {
                "1. static  2. void  3. private  4. main",
                "1. 2 bytes  2. 4 bytes  3. 8 bytes  4. 16 bytes",
                "1. Microsoft  2. Sun Microsystems  3. Apple  4. IBM",
                "1. print()  2. println()  3. write()  4. display()"
        };

        int[] answers = {4, 2, 2, 2};
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println(options[i]);
            System.out.print("Enter your choice (1-4): ");
            int userAnswer = sc.nextInt();


            if (userAnswer == answers[i]) {
                score++;
            }
        }
        System.out.println("Your final score: " + score + "/" + questions.length);
    }

    private static void runCOAQuiz(Scanner sc, Connection connection, int userId) {
        String[] questions = {
                "1. What does COA stand for?",
                "2. Which is the primary memory in COA?",
                "3. What is the function of ALU?",
                "4. What does the Control Unit do?"
        };

        String[] options = {
                "1. Control of Architecture  2. Computer Organization and Architecture  3. Central Organization Architecture  4. Central Operative Architecture",
                "1. RAM  2. Hard Drive  3. SSD  4. Cache",
                "1. Arithmetic Logic Unit  2. Administrative Logic Unit  3. Arithmetic Linear Unit  4. Automatic Logic Unit",
                "1. Controls data flow  2. Performs calculations  3. Manages storage  4. Coordinates input/output"
        };

        int[] answers = {2, 1, 1, 1};
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println(options[i]);
            System.out.print("Enter your choice (1-4): ");
            int userAnswer = sc.nextInt();


            if (userAnswer == answers[i]) {
                score++;
            }
        }
        System.out.println("Your final score: " + score + "/" + questions.length);
    }

    private static void runElectricalEngineeringQuiz(Scanner sc, Connection connection, int userId) {
        String[] questions = {
                "1. What is Ohm's Law?",
                "2. What is the unit of electrical power?",
                "3. Which of the following is a semiconductor material?",
                "4. What does a capacitor do?"
        };

        String[] options = {
                "1. V = IR  2. V = I/R  3. I = VR  4. V = I^2R",
                "1. Ampere  2. Watt  3. Volt  4. Ohm",
                "1. Copper  2. Silicon  3. Iron  4. Aluminum",
                "1. Stores charge  2. Stores energy  3. Stores data  4. Converts energy"
        };

        int[] answers = {1, 2, 2, 1};
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println(options[i]);
            System.out.print("Enter your choice (1-4): ");
            int userAnswer = sc.nextInt();


            if (userAnswer == answers[i]) {
                score++;
            }
        }
        System.out.println("Your final score: " + score + "/" + questions.length);
    }

    private static void runPythonQuiz(Scanner sc, Connection connection, int userId) {
        String[] questions = {
                "1. What is the correct extension for Python files?",
                "2. Which of the following is not a Python data type?",
                "3. How do you create a function in Python?",
                "4. Which Python statement is used to create a loop?"
        };

        String[] options = {
                "1. .py  2. .pt  3. .pyth  4. .pyn",
                "1. List  2. Dictionary  3. Set  4. Map",
                "1. function()  2. def function()  3. func()  4. create function()",
                "1. loop()  2. iterate()  3. for loop  4. do while"
        };

        int[] answers = {1, 4, 2, 3};
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println(options[i]);
            System.out.print("Enter your choice (1-4): ");
            int userAnswer = sc.nextInt();


            if (userAnswer == answers[i]) {
                score++;
            }
        }
        System.out.println("Your final score: " + score + "/" + questions.length);
    }

    private static void runFinancialAccountingQuiz(Scanner sc, Connection connection, int userId) {
        String[] questions = {
                "1. What is the main purpose of financial accounting?",
                "2. What is the equation for the accounting balance sheet?",
                "3. What is depreciation in accounting?",
                "4. What is a trial balance?"
        };

        String[] options = {
                "1. Track expenses  2. Record transactions  3. Prepare tax filings  4. Record profits/losses",
                "1. Assets = Liabilities + Equity  2. Assets = Liabilities - Equity  3. Assets = Equity + Revenue  4. Liabilities = Assets + Revenue",
                "1. Value reduction over time  2. Money paid for equipment  3. Value increase over time  4. Reserves set aside",
                "1. A balance of revenues  2. A list of trial expenses  3. A summary of income statements  4. A summary of all debits and credits"
        };

        int[] answers = {2, 1, 1, 4};
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println(options[i]);
            System.out.print("Enter your choice (1-4): ");
            int userAnswer = sc.nextInt();
//            sc.nextLine();  // Consume the newline character


            if (userAnswer == answers[i]) {
                score++;
            }
        }
        System.out.println("Your final score: " + score + "/" + questions.length);
    }

    private static void runBusinessEnvironmentQuiz(Scanner sc, Connection connection, int userId) {
        String[] questions = {
                "1. What does SWOT stand for in business?",
                "2. What is the concept of corporate social responsibility?",
                "3. What does PEST analysis examine?",
                "4. What is a business model?"
        };

        String[] options = {
                "1. Strengths, Weaknesses, Opportunities, Threats  2. Strategy, Workload, Outcomes, Time  3. Sustainability, Welfare, Opportunities, Threats  4. Sales, Workload, Opportunity, Time",
                "1. Profit-sharing initiatives  2. Business responsibility towards society  3. Legal compliance  4. Business-focused advertising",
                "1. Political, Environmental, Social, Technological factors  2. Political, Economic, Social, Technological factors  3. Profit, Expense, Sale, Trade factors  4. Profit, External, Strategy, Transition factors",
                "1. Method of management  2. Revenue model  3. Model for creating value  4. Strategy planning"
        };

        int[] answers = {1, 2, 2, 3};
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.println(options[i]);
            System.out.print("Enter your choice (1-4): ");
            int userAnswer = sc.nextInt();
            sc.nextLine();  // Consume the newline character


            if (userAnswer == answers[i]) {
                score++;
            }
        }
        System.out.println("Your final score: " + score + "/" + questions.length);
    }
}