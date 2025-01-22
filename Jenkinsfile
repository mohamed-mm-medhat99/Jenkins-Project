pipeline {
    agent any
    tools {
          maven 'MAVEN 3.9.9'
          jdk 'JDK23'
        }
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