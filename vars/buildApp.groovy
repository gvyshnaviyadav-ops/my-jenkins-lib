def call(String tag,String dockerHubUsername) {
    sh """
        echo "Building images..."
        
        docker build -t ${dockerHubUsername}/todo-frontend:${tag} ./todo-frontend
        docker build -t ${dockerHubUsername}/todo-backend:${tag} ./todo_project

    """
}