                💻 Java Calculator Project Setup on Ubuntu
1️⃣ Update Ubuntu Packages

Always start by updating your system:

sudo apt update
sudo apt upgrade -y

2️⃣ Install Git

Check if Git is installed:

git --version


If not installed:

sudo apt install git -y


Test installation:

git --version

3️⃣ Clone Your Java Project

Clone your GitHub repository:

git clone https://github.com/yannamsiva/javacalculator.git


Navigate to the project folder:

cd javacalculator


List files to confirm:

ls

4️⃣ Install Java (OpenJDK 17)

Check if Java is installed:

java -version


Install Java 17 if needed:

sudo apt install openjdk-17-jdk -y


Verify installation:

java -version
javac -version


✅ You should see openjdk version "17" and javac 17.

5️⃣ Install Maven

Check if Maven is installed:

mvn -v


If not installed:

sudo apt install maven -y


Verify installation:

mvn -v

6️⃣ Verify Project Structure

Ensure your Maven project has this structure:

javacalculator/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/
                └── shiva/
                    └── ConsoleCalculator.java

7️⃣ 🚀 Maven Build the Project

Clean previous builds and package your project:

mvn clean package


Check the generated .jar file in target/:

ls target/


You should see:

javacalculator-0.0.1-SNAPSHOT.jar

8️⃣ Run the Java Application

Go to the target folder:

cd target


Run the .jar file:

java -jar javacalculator-0.0.1-SNAPSHOT.jar


✅ GUI-based: Calculator window appears.
✅ Console-based: Output appears in the terminal.

9️⃣ (Optional) Install tree for Project Visualization

Install tree:

sudo apt install tree -y


View project structure:

tree src/
