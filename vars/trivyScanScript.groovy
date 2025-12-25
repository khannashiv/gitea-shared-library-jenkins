def updateVulnerabilityScan(Map config = [:]) {
    loadScript(name: 'trivy.sh')
    sh "./trivy.sh ${config.severity} ${config.exitCode} ${config.imageName}"
}