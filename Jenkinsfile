pipeline {
  agent any
  tools {
    maven 'maven'
    jdk 'Jdk-8'
  }
  stages {
    stage('git') {
      steps {
        git credentialsId:'library-credentials', url:'https://github.com/ShaziyaHasan.git'
      }
    }
    stage('build') {
      steps {
        bat 'mvn -f library-mvc/pom.xml clean install'
      }
    }
  }
}
