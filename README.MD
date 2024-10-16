# MAVEN TUTORIAL, Commands and simple explanations
<br /><br />
## Initial Compile
### (No source codes yet, just want maven folder structure)
    mvn compile
>Creates empty project with maven layout/directory style
>Port regular java projects to folder structure and rename packages whatever
<br /><br />
## Compile and run immediately 
### (With java command, takes in arguments as well)
    mvn compile exec:java -Dexec.mainClass="workshopd6.ServerApp" -Dexec.args="3000 C:\Users\Lawson\OneDrive\Desktop\SDF-workshop6-cookiemonster-main\cookie_file.txt"

-Dexec.mainClass="workshopd6.ServerApp"
>Point this to the main/entry point

-Dexec.args="3000 C:\Users\Lawson\OneDrive\Desktop\SDF-workshop6-cookiemonster-main\cookie_file.txt"
>ServerApp takes in two arguments in the main method (port filetxt)
<br /><br />
## Creating a package 
### (Compile classes into target directory, creates a JAR file as well)
    mvn package
>Creates a jar in the target directory
>This jar package contains clientapp and serverapp
>Can contain multiple entry points(main)
>So when running the jar file, specify the entry point
<br /><br />
## Run the jar package to launch ServerApp
    java -cp ./target/workshopd6-1.0-SNAPSHOT.jar workshopd6.ServerApp 3000 "C:\Users\Lawson\OneDrive\Desktop\SDF-workshop6-cookiemonster-main\cookie_file.txt"
>Specify entry point, pass in the 2 arguments PORT textFile

## Run the jar package to launch ClientApp
    java -cp ./target/workshopd6-1.0-SNAPSHOT.jar workshopd6.ClientApp localhost:3000
>Specify entry point, pass in argument HOST:PORT