def call(String OpenshiftcredintialsID, String imageName) {
    
    // Update deployment configuration with new Docker Hub image tag
    sh "sed -i 's|image:.*|image: ${imageName}:${BUILD_NUMBER}|g' java-deployment-service.yaml"
    

    withKubeCredentials(kubectlCredentials: [[caCertificate: '', clusterName: '', contextName: '', credentialsId: 'open-shift-service', namespace: 'mohamedtabana', serverUrl: 'https://console-openshift-console.apps.ocp-training.ivolve-test.com']]) {
        sh "oc apply -f java-deployment-service.yaml -n mohamedtabana"
    }
}
