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
        cron('H 10 * * *')
        pollSCM('H/5 * * * *')
        githubPush()
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
                    steps { echo '====================== start UI tests ======================' }
                }

                stage('sonar-scanner') {
                    steps { echo '====================== start SONAR-SCANNER ======================' }
                }
            }

            post {
                always {
                    echo '====================== start POST-BUILD ======================'
                    //junit '**/TEST-*.xml'
                }
            }
        }


    }

}