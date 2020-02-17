pipeline {
    agent any

    tools {
            maven 'Maven 3.6.3'
        }

    stages {
        stage('Compile Stage') {
            steps {
            sh 'mvn clean install'
                echo 'Compiling..'
            }
        }
        stage('Test') {
            steps {
            sh 'mvn test'
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