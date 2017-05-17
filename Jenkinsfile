pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'hello'
        sh 'mvn package -DskipTests'
        archiveArtifacts '*.war'
      }
    }
    stage('Deploy') {
      steps {
        parallel(
          "deploy auto": {
            echo 'deploying in uat'
            
          },
          "deploy qat": {
            echo 'deploy qat'
            
          },
          "deploy uat": {
            echo 'deploying uat'
            
          }
        )
      }
    }
  }
}