def updateVulnerabilityScan(Map config = [:]) {
    loadScript(name: 'trivy.sh')

    // 1. Decide the filename based on the severity passed from Jenkinsfile
    def targetFile = (config.severity == "CRITICAL") ? 
                     "trivy-image-critical-results.json" : 
                     "trivy-image-high-medium-low-results.json"

    // 2. Pass 'targetFile' as the 4th argument
    // 3. 'set +e' prevents the pipeline from crashing before the file is saved              
    sh """
        set +e
        ./trivy.sh ${config.severity} ${config.exitCode} ${config.imageName} ${targetFile}
        set -e
    """
}