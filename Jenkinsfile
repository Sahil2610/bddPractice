pipeline {
  agent any
  tools {
            maven 'maven-3.6.3'
        }
 //below parameters are entered in jenkins pipeline
    parameters {
    string(name: 'tags', defaultValue: '@e2e', description: 'Run tests based on tag name')  }

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
  post {
  	     failure {

  	      echo "Test failed"
                      cucumber buildStatus: 'FAIL',
                                   failedFeaturesNumber: 1,
                                   failedScenariosNumber: 1,
                                   skippedStepsNumber: 1,
                                   failedStepsNumber: 1,
                                   fileIncludePattern: '**/*.json',
                                   sortingMethod: 'ALPHABETICAL'

          slackSend color: 'red', message: "${params.reportname} Tests failed. >> Click to view <$reportUrl|report>"

  	     }

  	      success {

          echo "Test succeeded"
                     cucumber buildStatus: 'SUCCESS',
                                            failedFeaturesNumber: 0,
                                            failedScenariosNumber: 0,
                                            skippedStepsNumber: 0,
                                            failedStepsNumber: 0,
                                            fileIncludePattern: '**/*.json',
                                            sortingMethod: 'ALPHABETICAL'

          slackSend color: 'green', message: "${params.reportname} Tests passed. >> Click to view <$reportUrl|report>"

          }

  }

}
