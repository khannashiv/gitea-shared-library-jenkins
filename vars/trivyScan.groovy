def vulnerabilityScan(String imageName) {

    sh """
        echo "Docker image is: ${imageName}"

        trivy image --severity HIGH,MEDIUM,LOW --exit-code 0 --quiet --format json --output trivy-image-high-medium-low-results.json ${imageName}

        trivy image --severity CRITICAL --exit-code 1 --quiet --format json --output trivy-image-critical-results.json ${imageName}
    """
}


def convertFormat() {

   sh '''
        echo "Converting Trivy JSON reports to HTML and JUnit XML..."

        trivy convert --format template \
            --template "@/usr/local/share/trivy/templates/html.tpl" \
            --output trivy-image-high-medium-low-results.html \
            trivy-image-high-medium-low-results.json

        trivy convert --format template \
            --template "@/usr/local/share/trivy/templates/html.tpl" \
            --output trivy-image-critical-results.html \
            trivy-image-critical-results.json

        trivy convert --format template \
            --template "@/usr/local/share/trivy/templates/junit.tpl" \
            --output trivy-image-critical-results.xml \
            trivy-image-critical-results.json

        trivy convert --format template \
            --template "@/usr/local/share/trivy/templates/junit.tpl" \
            --output trivy-image-high-medium-low-results.xml \
            trivy-image-high-medium-low-results.json
	'''
}