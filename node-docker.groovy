job('NodeJS Docker example') {
    scm {
        git('git://github.com/vigneshm243/simple-nodejs.git') 
    }
    triggers {
        scm('H/5 * * * *')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('vigneshm243/nodejs-test')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
