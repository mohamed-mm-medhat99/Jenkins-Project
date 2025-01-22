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
                sh 'mvn -o test -Dfilename="testNG.xml"'
            }
        }
    }
}