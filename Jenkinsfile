pipeline {
  agent any
  parameters {
    string(name: 'BRANCH', defaultValue: 'main', description: 'Git branch to build')
    choice(name: 'BROWSER', choices: ['chrome', 'firefox', 'edge'], description: 'Browser to run tests')
    booleanParam(name: 'HEADLESS', defaultValue: true, description: 'Run headless')
  }
  stages {
    stage('Checkout') {
      steps { git branch: params.BRANCH, url: 'https://github.com/your-org/ecommerce-automation.git' }
    }
    stage('Build') {
      steps { sh 'mvn -B -DskipTests clean package' }
    }
    stage('Run Tests') {
      steps { sh "mvn test -Dbrowser=${params.BROWSER} -Dheadless=${params.HEADLESS}" }
    }
    stage('Archive Reports') {
      steps {
        archiveArtifacts artifacts: 'target/ExtentReport.html, target/screenshots/**', allowEmptyArchive: true
        publishHTML([reportDir: 'target', reportFiles: 'ExtentReport.html', reportName: 'Extent Report', keepAll: true])
      }
    }
  }
  post {
    always {
      junit 'target/surefire-reports/*.xml'
    }
  }
}
