pipeline {
    agent any
    stages {
        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("selenium-project")
                }
            }
        }
        stage('Run Tests') {
            steps {
                script {
                    docker.image("selenium-project").run("--rm")
                }
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