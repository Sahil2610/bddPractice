pipeline {
  agent any
  tools {
            maven 'maven-3.6.3'
        }
 //below parameters are entered in jenkins pipeline
    parameters {
    string(name: 'tags', defaultValue: '@e2e', description: 'Run tests based on tag name')
    string(name: 'reportname', defaultValue: 'test report', description: 'Which tests report to alert on slack?')

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
            bat 'mvn test -Dcucumber.options="--tags @*"'
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
