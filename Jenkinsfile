#!groovy

properties([disableConcurrentBuilds()])

pipeline {
    agent {
        label 'master'
    }

    options {
        timestamps()
        ansiColor('xterm')
        buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
        disableResume()
        durabilityHint('PERFORMANCE_OPTIMIZED')
        disableConcurrentBuilds()
    }

    triggers {
//        cron('H 10 * * *')
        pollSCM('H 10 * * *')
    }

    stages {
        stage('build') {
            steps   {
                echo '====================== start BUILD ======================'
            }
        }

        stage('test') {
            parallel {
                stage('unit-tests') {
                    steps { echo '====================== start UNIT tests ======================' }
                }

                stage('ui-tests') {
                    when {
                        branch 'master'
                    }
                    steps { echo '====================== start UI tests ======================' }
                }

                stage('sonar-scanner') {
                    when {
                        branch "dev*"
                    }
                    steps {
                        echo '====================== start UI tests ======================'
                        withSonarQubeEnv() {
                            sh "./gradlew sonarqube"
                        }
                    }
                }
            }

            post {
                always {
                    echo '====================== start POST-BUILD ======================'
                    //junit '**/TEST-*.xml'
                }
            }
        }

        stage ('PR task') {
            when {
                branch 'PR-*'
            }

            steps {
                echo 'Steps for PR'
            }
        }

    }

}