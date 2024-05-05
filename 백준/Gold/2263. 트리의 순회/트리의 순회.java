import java.io.*;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Main {
    private static int n;
    private static int[] inorder;
    private static int[] postorder;
    private static int postIndex;
    private static Map<Integer, Integer> inorderIndexMap;
    private static StringBuilder result;

    public static TreeNode buildTree(int[] inorder, int[] postorder){
        postIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeRecursive(postorder, 0, inorder.length - 1);
    }

    public static TreeNode buildTreeRecursive(int[] postorder, int inorderLeft, int inorderRight){
        if(inorderLeft > inorderRight) return null;

        int rootValue = postorder[postIndex--];
        TreeNode root = new TreeNode(rootValue);

        root.right = buildTreeRecursive(postorder, inorderIndexMap.get(rootValue) + 1, inorderRight);
        root.left = buildTreeRecursive(postorder, inorderLeft, inorderIndexMap.get(rootValue) - 1);
        return root;
    }

    public static void printPreOrder(TreeNode tree){
        if(tree != null){
            result.append(tree.val).append(" ");
            printPreOrder(tree.left);
            printPreOrder(tree.right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        inorder = new int[n];
        postorder = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        result = new StringBuilder();
        printPreOrder(buildTree(inorder, postorder));

        System.out.println(result);
    }
}