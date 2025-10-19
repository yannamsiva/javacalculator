Step 1: Update Ubuntu Packages

Always start by updating your system:

sudo apt update
sudo apt upgrade -y

Step 2: Install Git

Check if Git is installed:

git --version


If it’s not installed, run:

sudo apt install git -y


Test installation:

git --version

Step 3: Clone Your Java Project

Clone your GitHub project:

git clone https://github.com/yannamsiva/javacalculator.git


Go into the project directory:

cd javacalculator


List files to confirm:

ls

Step 4: Install Java (OpenJDK 17)

Check if Java is installed:

java -version


Install Java 17:

sudo apt install openjdk-17-jdk -y


Check installation:

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


You should see Maven version info.

Step 6: Verify Project Structure

Make sure your project has this Maven structure:

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


If everything is correct, Maven will create a .jar file in the target/ folder.

Check the .jar file:

ls target/


You should see something like:

javacalculator-0.0.1-SNAPSHOT.jar

Step 8: Run the Java Application

Go to the target folder:

cd target


Run the .jar file:

java -jar javacalculator-0.0.1-SNAPSHOT.jar
