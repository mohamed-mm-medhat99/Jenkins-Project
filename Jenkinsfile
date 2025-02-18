pipeline {
    agent any
    stages {
        stage('Build the project') {
            steps {
                sh 'mvn clean test -Dfilename="testNG.xml"'
            }
        }
    }
    post{
            always{
                allure includeProperties:
                false,
                jdk: '',
                results: [[path: 'build/allure-results']]
            }
        }
}