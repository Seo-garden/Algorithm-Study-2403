package Baekjoon.gold;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num22856_트리순회 {
    private static StringTokenizer st;
    private static int N;
    private static int visitCount, lastNode;
    private static Node[] tree;

    private static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    private static void inOrder(int cur) {
        if (tree[cur].left != -1) {     //  Left
            inOrder(tree[cur].left);
        }

        lastNode = cur;       //root
        if (tree[cur].right != -1) {
            inOrder(tree[cur].right);
        }
    }

    private static void search(int cur) {

        if (tree[cur].left != -1) {     //  left
            visitCount++;           //탐색 전 들어갈 때
            search(tree[cur].left);
            if (tree[cur].left == lastNode) {        //중위순회 마지막 노드면 간선개수증가 안하고 바로 종료
                System.out.println(visitCount);
                System.exit(0);
            }
            visitCount++;   // 탐색 후 나올 때
        }

        if (tree[cur].right != -1) {   //right
            visitCount++;
            search(tree[cur].right);
            if (tree[cur].right == lastNode) {
                System.out.println(visitCount);
                System.exit(0);
            }
            visitCount++;
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];
        visitCount = 0; //중위 순회 마지막값

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree[parent] = new Node(left, right);
        }

        inOrder(1);
        search(1);
        System.out.println(visitCount);


    }

}

