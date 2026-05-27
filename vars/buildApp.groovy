def call() {
    sh """
        echo "Building images..."
        
        docker build -t todo-frontend:${BUILD_NUMBER} ./todo-frontend
        docker build -t todo-backend:${BUILD_NUMBER} ./todo_project
    """
}