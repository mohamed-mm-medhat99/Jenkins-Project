pipeline {
    agent any
    tools {
          maven 'MAVEN_HOME'
          jdk 'JAVA_HOME'
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