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

                        sh 'git remote add repo_b_push https://github.com/Anju-Alexander/CBG.git'
                         sh 'mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.majorVersion}.\\${parsedVersion.minorVersion}.\\${parsedVersion.nextIncrementalVersion} versions:commit'
                         sh 'mvn clean install'
                         sh 'git status'
                         sh 'git add pom.xml'
                         sh 'git commit -m "updated version"'
                         echo 'push'
                         sh 'git push -u repo_b_push main'
                         sh 'git remote rm repo_b_push'
                        
                       
                    }
                      else
                    {
                     sh 'mvn clean install'
                     echo 'No dependency update by Renovate'
                    }
                  }

              }
            
        }
        stage('Trigger MAAS')
        {
            steps {
                
                    script{
                        if(myVariable)
                        {
                            build 'MAAS'
                            echo 'Built MAAS successfully!'
                        }
                        else
                        {
                             echo 'Built MAAS is cancelled'
                        }
                    }
                    
               
            }
        }
       

     }
      post {
          
             
              success {
                echo 'successful!'
                  slackSend channel: 'repo-a-notifications', message: "Latest build of CBG Repo is succesful!!", tokenCredentialId: 'b4c53875-29c5-4f3a-a5dc-5a97790ff44e'

            }
              failure {
                echo 'failed:('
                slackSend channel: 'repo-a-notifications', message: "Latest build of CBG Repo has failed!!", tokenCredentialId: 'b4c53875-29c5-4f3a-a5dc-5a97790ff44e'

            }
          
      }
}
