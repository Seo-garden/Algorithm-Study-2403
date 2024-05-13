package Baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class num5639_이진검색트리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeNode root = new TreeNode(Integer.parseInt(br.readLine()));  //첫번째 root 노드

        String str = "";
        //더 이상 br할 내용이 없을때 까지
        while ( (str = br.readLine()) != null)  {
            if (str.equals(""))break;
            root.insert(Integer.parseInt(str));
        }

        root.postOrder(root);

    }


}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    void insert(int node){
        if (node < this.val) {      //현재 root 보다 작을때 (왼쪽)
            if (this.left == null) {        // 좌가 비었으면
                this.left = new TreeNode(node); //왼쪽 노드에 생성
            }else {
                this.left.insert(node); //안비어 있다면 더 깊이 생성 하러 감
            }
        }else {
            if (this.right == null) {       //현재 root 보다 클때 (오른쪽)
                this.right = new TreeNode(node);    //오른쪽 노드에 생성
            }else{
                this.right.insert(node);        //이미 있다면 오른쪽 노드를 루트삼아 더 깊이 생성
            }
        }
    }

    void postOrder(TreeNode root) {
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);

        // 루트
        System.out.println(root.val);
    }
}


