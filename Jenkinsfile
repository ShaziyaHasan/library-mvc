pipeline {
  agent any
  tools {
    maven 'maven'
    jdk 'Jdk-11'
  }
  stages {
    stage{'git'} {
      steps {
        git credentialsId:'library-credentials', url:'https://github.com/ShaziyaHasan/library-mvc.git'
      }
    }
    stage('build') {
      steps {
        bat 'mvn -f library-mvc/pom.xml clean install'
      }
    }
  }
}