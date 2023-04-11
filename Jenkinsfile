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
                    credentialsId: 'web-automation-java'
                ]]
            ])
        }
    }
    stage('Download dependencies') {
      steps {
        sh 'mvn dependency:resolve'
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