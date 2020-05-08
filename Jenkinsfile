pipeline {

 environment {
    //Project Configurations
    solutionName="ruby-cucumber"
    reportUrl = "http://localhost:8080/job/$env.JOB_NAME/$env.BUILD_NUMBER/cucumber-html-reports/overview-failures.html"



   //below parameters are entered in jenkins pipeline
   parameters {

   string(name: 'tags', defaultValue: '', description: 'Run tests based on tag name.')


   }


  }
    agent any

    tools {
            maven 'maven-3.6.3'
        }

    stages {
        stage('Compile Stage') {
            steps {
            bat 'mvn clean install -DskipTests'
                echo 'Compiling..'
            }
        }
        stage('Test') {
            steps {
            bat 'mvn test -Dtags'
                echo 'Running Test..'
            }
        }
        stage('Cucumber-report') {
            steps {
            cucumber buildStatus: "UNSTABLE",
            fileIncludePattern: "**/cucumber.json",
            jsonReportDirectory: 'target'
                echo 'Generating report....'
            }
        }
    }
}