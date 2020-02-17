pipeline {
    agent any

    stages {
        stage('Compile Stage') {
            steps {
            withMaven(maven: 'maven_3_6_1'){
            sh 'mvn clean install'
            }
                echo 'Compiling..'
            }
        }
        stage('Test') {
            steps {
            withMaven(maven: 'maven_3_6_1'){
            sh 'mvn test'
            }
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