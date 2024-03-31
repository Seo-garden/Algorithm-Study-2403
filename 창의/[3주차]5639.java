import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static ArrayList<Integer> A = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        String value = "";
        while (true){
            value = br.readLine();
            if(value == null || value.equals("")) break;
            A.add(Integer.parseInt(value));
        }

        Node root = new Node(A.get(0));
        for(int i=1; i<A.size(); i++){
            Node now = root;
            int target = A.get(i);
            // 노드의 위치를 찾는다.
            while (true){
		            // 새로 들어온 값이 현재 노드보다 작으면 left 
                if(now.value > target){
		                // null -> 왼쪽에 담고 종료
                    if(now.left == null){
                        now.left = new Node(target);
                        break;
                    // now -> left -> left
                    }else{
                        now = now.left;
                    }
                    // 
                }else if(now.value < target){
	                // null -> right
                    if(now.right == null){
                        now.right = new Node(target);
                        break;
                      // right -> right -> value;
                    }else{
                        now = now.right;
                    }
                }
            }
        }
        postOrder(root);




    }

    public static void postOrder(Node now){
        if(now == null) return;

        postOrder(now.left);
        postOrder(now.right);

        System.out.println(now.value);
    }


    static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;

        }
    }

}