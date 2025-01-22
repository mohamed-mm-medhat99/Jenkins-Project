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
        stage('reports') {
            steps {
            script {
                    allure([
                            includeProperties: false,
                            jdk: '',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: 'target/allure-results']]
                    ])
            }
            }
        }
}