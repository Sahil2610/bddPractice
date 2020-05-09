pipeline {
parameters{string(name: 'tags', defaultValue: '', description: 'Tests to run based on tags',  trim: false)}

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
            bat 'mvn test -D tags=params.tags'
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
