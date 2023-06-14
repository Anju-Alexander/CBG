
pipeline {
    agent any
    tools { 
        maven 'Maven 3.9.1' 
        
    }
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
                     sh 'mvn clean test -B -U'
                     echo 'build stable!'
                  }

              }
            
        }
       

     }
}
