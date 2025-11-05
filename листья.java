class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    /**
     * Подсчитывает количество листьев в бинарном дереве
     * 
     * @param root корень бинарного дерева
     * @return количество листьев
     */
    public int countLeaves(TreeNode root) {
        // Базовый случай: пустое дерево
        if (root == null) {
            return 0;
        }
        
        // Если это лист (нет потомков)
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        // Рекурсивно подсчитываем листья в левом и правом поддеревьях
        return countLeaves(root.left) + countLeaves(root.right);
    }
}

public class Main {
    // Вспомогательная функция для создания тестового дерева
    public static TreeNode createTestTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        return root;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = createTestTree();
        
        int result = solution.countLeaves(root);
        System.out.println("Количество листьев: " + result); // Вывод: 3
        
        // Дополнительные примеры
        System.out.println("\nДополнительные примеры:");
        
        // Пример 1: Пустое дерево
        System.out.println("Пустое дерево: " + solution.countLeaves(null)); // 0
        
        // Пример 2: Только корень
        TreeNode singleNode = new TreeNode(1);
        System.out.println("Один узел: " + solution.countLeaves(singleNode)); // 1
    }
}
