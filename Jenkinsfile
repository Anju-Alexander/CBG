def myVariable = false
pipeline {
    agent any
    
  

    stages {
        stage('Clone B') {
              steps {
                  echo 'Clone B'
                  git branch: 'main', credentialsId: 'cf3d6d86-2ff7-465a-8767-58e572a16539', url: 'https://github.com/Anju-Alexander/CBG.git'

              }
            
        }
        stage('Build & Push') {
              steps {
                  script{
                     
                     commit = sh(returnStdout: true, script: 'git log -1 --oneline').trim()
                     commitMsg = commit.substring( commit.indexOf(' ') ).trim()
                      myVariable=commitMsg.contains('RENOVATE')
                     
                      if(myVariable)
                    {
                        echo 'build'
                        sh 'mvn clean install'
                    }
                      else
                    {
                     echo 'build Skipped!'
                    }
                  }

              }
            
        }
       

     }
}
