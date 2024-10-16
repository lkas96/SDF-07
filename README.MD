# MAVEN TUT

mvn compile
    1. creates empty project with maven layout/directory style
    2. port regular java projects to folder structure and rename packages whatever




compiles directly and run the java command, takes in arguments as well
mvn compile exec:java -Dexec.mainClass="workshopd6.ServerApp" -Dexec.args="3000 C:\Users\Lawson\OneDrive\Desktop\SDF-workshop6-cookiemonster-main\cookie_file.txt"
                        > Point this to the main/entry point    >ServerApp takes in two arguments in the main method (port filetxt)



mvn package
    1. creates a jar in the target directory
    2. this jar package contains clientapp and serverapp
    3. can contain multiple entry points(main)
    4. so when running the jar file, specify the entry point



run the jar package to launch client app
    java -cp ./target/workshopd6-1.0-SNAPSHOT.jar workshopd6.ClientApp localhost:3000

run the jar package to launch server app
    java -cp ./target/workshopd6-1.0-SNAPSHOT.jar workshopd6.ServerApp 3000 "C:\Users\Lawson\OneDrive\Desktop\SDF-workshop6-cookiemonster-main\cookie_file.txt"