pipeline {
    agent any
    stages {
        stage('Build') {
            agent{
                docker{
                    image 'maven'
                    args '-u root'
                    reuseNode true
                }
            }
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