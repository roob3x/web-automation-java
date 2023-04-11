pipeline {
    agent {
        docker {
            image 'maven:latest'
            args '-v $HOME/.m2:/root/.m2'
        }
    }
    environment {
        MAVEN_HOME = '/usr/share/maven'
        PATH = "$MAVEN_HOME/bin:${PATH}"
    }
    stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM',
                          branches: [[name: 'main']],
                          userRemoteConfigs: [[
                              credentialsId: 'web-automation-java-pipeline',
                              url: 'https://github.com/roob3x/web-automation-java.git'
                          ]]
                ])
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}