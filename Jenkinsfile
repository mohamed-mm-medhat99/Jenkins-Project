pipeline {
    agent any
    stages {
        stage('Build') {
            agent{
                docker{
                    image 'maven'
                    reuseNode true
                }
            }
            steps {
                sh 'mvn clean test -Dfilename="testNG.xml"'
            }
        }
    }
}