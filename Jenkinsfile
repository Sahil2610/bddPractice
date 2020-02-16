pipeline {
    agent any

    stages {
        stage('Compile Stage') {
            steps {
            withMaven(maven: 'maven_3_8_2'){
            sh 'mvn clean install'
            }
                echo 'Compiling..'
            }
        }
        stage('Test') {
            steps {
            withMaven(maven: 'maven_3_8_2'){
            sh 'mvn test'
            }
                echo 'Running Test..'
            }
        }
        stage('Cucumber-report') {
            steps {
            cucumber buildStatus: "UNSTABLE",
            // publish html
                    publishHTML target: [
                        allowMissing: false,
                        alwaysLinkToLastBuild: false,
                        keepAll: true,
                        reportDir: 'coverage',
                        reportFiles: 'index.html',
                        reportName: 'cucumber-report'
                      ]
            }
        }
    }
}