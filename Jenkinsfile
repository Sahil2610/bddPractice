pipeline {


  environment {
    //Project Configurations
    solutionName="bdd-automation"
    reportUrl = "http://localhost:8080/job/$env.JOB_NAME/$env.BUILD_NUMBER/cucumber-html-reports/overview-failures.html"



   //below parameters are entered in jenkins pipeline
   parameters {

   //         string(name: 'test', defaultValue: 'api_tests', description: 'Which tests to run?')
            string(name: 'TAGNAME', defaultValue: '', description: 'Which Test to run?')
   //         string(name: 'browser', defaultValue: 'seleniumgrid', description: 'Which browser to use?')
   //         string(name: 'platform', defaultValue: 'mobile', description: 'Which platform to run tests?')
   //         string(name: 'environment', defaultValue: 'test', description: 'Which environment to run tests?')
   //         string(name: 'report', defaultValue: 'jenkinsreport_apitests', description: 'Which report to generate?')
   //         string(name: 'reportname', defaultValue: 'API', description: 'Which tests report to alert on slack?')

   //     }
   

  }

  agent any

  stages {
   
   stage('Run Test') {
            steps {
            withMaven(maven: 'maven_3_6_3'){
              sh 'mvn test -DTAGNAME=${TAGNAME}'
            }
                echo 'Running Test..'
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
