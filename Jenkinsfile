pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh "docker-compose -f docker-compose.yml up -d"
                sh "docker ps"
            }
        }

        stage('E2E tests') {
            steps {
                script {
                    sh 'mvn clean test -Dfilename="testNG.xml"''
                }
            }
            post {
                always {
                echo 'Stopping containers...'
                sh "docker-compose -f docker-compose.yml down"
                    allure includeProperties: false,
                           jdk: '',
                           results: [[path: 'build/allure-results']]
                }
            }
        }
    }
}