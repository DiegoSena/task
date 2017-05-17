pipeline {
  agent {
    docker {
      image 'maven:3.3.9-jdk-8'
      args '-v /home/diegoguimaraes/.m2:root/.m2'
    }
    
  }
  stages {
    stage('Build') {
      steps {
        sh '''echo PATH = ${PATH}
echo M2_HOME = ${M2_HOME}

mvn clean'''
        archiveArtifacts 'target/*.war'
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