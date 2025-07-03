# Binary Search Tree in Java

This project implements a Binary Search Tree (BST) in Java with support for insertion, search, deletion, traversal, and graphical visualization using JavaFX. It also includes unit tests using JUnit.

## 📁 Project Structure

<pre>
project-root/
│
├── .vscode/
| ├── launch.json # # Launch configuration for running/debugging
│ └── settings.json # VS Code settings including library references
│
├── lib/
│ ├── javafx-sdk-24.0.1/ # JavaFX SDK jars
│ ├── junit-4.13.2.jar # JUnit jar
│ └── hamcrest-core-1.3.jar # JUnit dependency
│
├── src/
│ ├── AbstractBinarySearchTree.java # Abstract base class for BST
│ ├── BinarySearchTree.java # BST implementation with delete
│ ├── BinarySearchTreeTest.java # JUnit test cases
│ ├── BinarySearchTreeViewer.java # JavaFX GUI launcher
│ └── BinaryTreeView.java # JavaFX visual rendering of the tree
│
├── .gitignore # Specifies intentionally untracked files to ignore in version control
|
├── LICENSE # Creative Commons Attribution-NonCommercial 4.0 International
|
└── README.md # Project overview and instructions
</pre>
  
## 🛠️ Features

- ✅ Insert, search, and remove nodes
- ✅ Postorder traversal with visitor pattern
- ✅ JavaFX GUI to visualize the BST
- ✅ JUnit testing for core functionality
- ✅ Custom error handling and detailed comments

## 🚀 Getting Started

### 1. Requirements

- Java 8 or higher
- JavaFX SDK 17+
- JUnit 4
- VS Code with Java Extension Pack (or any Java IDE)

### 2. Setup Instructions

#### a. JavaFX Setup

- Java JDK **21** (recommended)
- JavaFX SDK **21.0.7**
- JUnit 4.13.2 (with hamcrest)

#### b. Add JUnit JARs to lib/ and ensure these are referenced in your settings.

#### c. Run Tests
Run JUnit tests using your IDE's test runner or build tool.

#### d. Run JavaFX App
Launch BinarySearchTreeViewer.java with JavaFX VM options:

🧪 Testing
Test class: BinarySearchTreeTest.java
Test framework: JUnit 4

🧾 Notes
SuppressWarnings annotations are used for unchecked type casts where necessary.

Generic types (<K, V>) are used to allow key-value flexibility.

Visual warnings for raw types and generics have been mostly resolved by parameterizing the types.

Make sure lib/ folder is present and included in your classpath for both JavaFX and JUnit support.

📚 Author
Tyler Lynch
