
pipeline {
    agent any

    stages {
        stage('Clone B') {
              steps {
                  echo 'Clone B'
                  git branch: 'main', credentialsId: 'cf3d6d86-2ff7-465a-8767-58e572a16539', url: 'https://github.com/Anju-Alexander/Repository_B.git'

              }
            
        }
        stage('Build & Push') {
              steps {
                  script{
                     echo 'build'
                     sh 'mvn clean install'
                     sh 'mvn test'
                     echo 'build stable!'
                  }

              }
            
        }
       

     }
}