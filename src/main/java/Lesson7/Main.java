package Lesson7;

public class Main {
    public static void main(String[] args) {
//        testGraph();
        testDfs();
        testBfs();
        testBestWay();
    }

    private static void testGraph() {
        Graph graph = new GraphImpl(4);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.addEdge("D", "B");

        System.out.println("Size of graph is " + graph.getSize());
        graph.display();
    }

    private static void testDfs() {
        Graph graph = new GraphImpl(7);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "B");
        graph.addEdge("B", "E");
        graph.addEdge("D", "F");
        graph.addEdge("F", "G");

        graph.dfs("A");
    }

    private static void testBfs() {
        Graph graph = new GraphImpl(8);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");

        graph.addEdge("A", "B");
        graph.addEdge("B", "E");
        graph.addEdge("E", "H");
        graph.addEdge("C", "F");
        graph.addEdge("D", "G");

        graph.bfs("A");
    }

    private static void testBestWay() {
        Graph graph = new GraphImpl(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва", "Тула", 175);
        graph.addEdge("Москва", "Рязань", 180);
        graph.addEdge("Москва", "Калуга", 160);
        graph.addEdge("Тула", "Липецк", 215);
        graph.addEdge("Рязань", "Тамбов", 240);
        graph.addEdge("Тамбов", "Саратов", 340);
        graph.addEdge("Калуга", "Орел", 170);
        graph.addEdge("Орел", "Курск", 140);
        graph.addEdge("Липецк", "Воронеж", 110);
        graph.addEdge("Саратов", "Воронеж", 470);
        graph.addEdge("Курск", "Воронеж", 210);

        graph.bestWay("Москва", "Воронеж");
    }
}
