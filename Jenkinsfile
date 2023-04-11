pipeline {
  agent any
  stages {
      stage('Checkout') {
        steps {
          checkout([$class: 'GitSCM',
            branches: [[name: 'main']],
            doGenerateSubmoduleConfigurations: false,
            extensions: [],
            submoduleCfg: [],
            userRemoteConfigs: [[
              url: 'https://github.com/roob3x/web-automation-java.git',
              credentialsId: 'web-automation-java-pipeline'
            ]]
          ])
        }
      }
    stage('Download dependencies') {
      agent {
        docker {
          image 'maven:latest'
          args '-v $HOME/.m2:/root/.m2'
        }
      }
      steps {
        sh 'mvn dependency:resolve'
      }
    }
    stage('Build') {
      agent {
        docker {
          image 'maven:latest'
          args '-v $HOME/.m2:/root/.m2'
        }
      }
      steps {
        sh 'mvn clean install'
      }
    }
    stage('Test') {
      agent {
        docker {
          image 'maven:latest'
          args '-v $HOME/.m2:/root/.m2'
        }
      }
      steps {
        sh 'mvn test'
      }
    }
  }
}