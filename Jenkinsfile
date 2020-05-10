pipeline {
  agent any
  tools {
            maven 'maven-3.6.3'
        }
  parameters {
  string(name: 'tags', defaultValue: '', description: 'Tests to run based on tags',  trim: false)
  string(name: 'goal', defaultValue: '', description: 'Specify maven goal',  trim: false)
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
            echo "Hello ${params.tags}"
            //def paramAValue = "${params.tags}"
            //bat 'mvn test -Dcucumber.options = "--tags paramAValue"'

            bat '${params.goal}'
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
