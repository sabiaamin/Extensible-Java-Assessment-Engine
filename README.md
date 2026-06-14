# Extensible-Java-Assessment-Engine

## Overview
A scalable, console-based Java assessment engine built using core Object-Oriented Programming (OOP) principles. This collaborative two-person project features user authentication, persistent state management, and an automated question-allocation algorithm that delivers randomized, difficulty-balanced quizzes across multiple technical domains.

## Features
* User Authentication: Registration and login system for individual users.
* Persistent State Management: Saves user credentials and historical quiz results to local text files using Java File I/O.
* Dynamic Quizzes: Randomly selects questions from a predefined bank, guaranteeing a mix of Easy, Medium, and Difficult questions per session.
* Detailed Scorecards: Displays the question text, difficulty level, correct answer, and the user's selected answer upon quiz completion.
* Scalable Architecture: Modular design makes it simple to integrate new subjects and question formats.

## Technologies Used
* Java (Core)
* Object-Oriented Design (Polymorphism, Abstraction, Inheritance)
* Collections Framework (ArrayList, Collections.shuffle)
* File I/O Streams (FileReader, FileWriter, BufferedReader, BufferedWriter)
* Custom Exception Handling

## Project Structure
* Main.java: The application entry point handling menu navigation and user routing.
* QuizService.java: Contains the core logic for executing quizzes, capturing input, and evaluating answers.
* UserService.java: Handles file reading and writing for user registration, login, and data persistence.
* QuestionBank.java: The central repository initializing and storing all categorized questions.
* Question.java & MultipleChoiceQuestion.java: The abstract base class and concrete implementation defining question behavior.
* User.java & QuizResult.java: Data models representing the user and their performance state.
* InvalidQuizInputException.java: Custom exception class for input validation.

## How to Run
1. Clone this repository to your local machine.
2. Open a terminal or command prompt and navigate to the directory containing the source files (the src folder).
3. Compile all the Java files using the following command:
   javac *.java
4. Run the application using the following command:
   java Main
