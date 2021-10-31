package Lesson7;

import java.util.*;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final int[][] adjMatrix;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, int weight) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = weight;
        return true;
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = 100;
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    private int indexOf(Vertex vertex) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).equals(vertex)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] != 0) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }



    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if ((adjMatrix[currentIndex][i] !=0) && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitedVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setVisited(true);
    }

    private void visitedVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        queue.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitedVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitedVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
        System.out.println();
    }

    @Override
    public int dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>(); //Создаем стэк
        Vertex vertex = vertexList.get(startIndex); //Получаем начальный узел
        Vertex oldVertex = null;
        int weight = 0;
        visitedVertex(stack, vertex); //Добавляем в стэк первый элемент
        while (!stack.isEmpty()) {
            oldVertex = vertex;
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                weight += getWeight(oldVertex, vertex);
            }
            if (vertex != null) {
                visitedVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
        System.out.println();
        return weight;
    }

    @Override
    public void bestWay(String startLabel, String finishLabel) {

        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);
        int weight = 0;

        //Проверка на ошибки в указанных вершинах
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }
        if (finishIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        List<Vertex> bestList = new ArrayList<>(); //Создаем список
        Vertex startVertex = vertexList.get(startIndex); //Получаем начальный узел
        Vertex finishVertex = vertexList.get(finishIndex);
        while (getNearUnvisitedVertex(startVertex) != null) {
            System.out.print(startVertex.getLabel() + " ");
            weight = getWeight(startVertex, getNearUnvisitedVertex(startVertex)) + dfs(getNearUnvisitedVertex(startVertex).getLabel());
            System.out.println(weight);
            startVertex.setVisited(false);
            finishVertex.setVisited(false);
            weight = 0;
        }
    }

    private int getWeight(Vertex firstVertex, Vertex secondVertex) {
        return adjMatrix[indexOf(firstVertex)][indexOf(secondVertex)];
    }
}
