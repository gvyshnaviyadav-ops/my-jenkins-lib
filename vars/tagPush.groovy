def call(String tag,String dockerHubUsername) {
    sh """

        echo "Tagging and pushing images to Docker Hub..."
        docker push ${dockerHubUsername}/todo-backend:${tag}
        docker push ${dockerHubUsername}/todo-frontend:${tag}
    """
}