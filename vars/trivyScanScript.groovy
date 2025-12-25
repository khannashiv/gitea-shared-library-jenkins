def updateVulnerabilityScan(Map config = [:]) {
    loadScript(name: trivy.sh)
    sh "./trivy.sh ${config.severity} ${config.exit-code} ${config.imageName}"
}