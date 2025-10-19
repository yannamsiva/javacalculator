💻 Java Calculator Setup on Ubuntu
Step 1: Update Ubuntu Packages

Always start by updating your system to ensure you have the latest packages.

sudo apt update
sudo apt upgrade -y

Step 2: Install Git

Check if Git is already installed:

git --version


If not installed, run:

sudo apt install git -y


Test installation:

git --version

Step 3: Clone Your Java Project

Clone your GitHub repository:

git clone https://github.com/yannamsiva/javacalculator.git


Navigate to the project directory:

cd javacalculator


List files to confirm:

ls

Step 4: Install Java (OpenJDK 17)

Check if Java is installed:

java -version


If not installed, install Java 17:

sudo apt install openjdk-17-jdk -y


Verify installation:

java -version
javac -version


✅ You should see openjdk version "17" and javac 17.

Step 5: Install Maven

Check if Maven is installed:

mvn -v


If not installed, run:

sudo apt install maven -y


Test Maven installation:

mvn -v


You should see Maven version information.

Step 6: Verify Project Structure

Ensure your Maven project structure is correct:

javacalculator/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── shiva/
                    └── ConsoleCalculator.java

Step 7: Build the Project

Clean any previous builds and package your project:

mvn clean package


If successful, Maven will create a .jar file in the target/ folder.

Check the .jar file:

ls target/


You should see:

javacalculator-0.0.1-SNAPSHOT.jar

Step 8: Run the Java Application

Navigate to the target folder:

cd target


Run the .jar file:

java -jar javacalculator-0.0.1-SNAPSHOT.jar


✅ If it’s GUI-based, the calculator window should appear.
✅ If it’s console-based, outputs will appear in your terminal.

Step 9 (Optional): Install tree Command

To easily visualize your project structure:

sudo apt install tree -y
tree src/
