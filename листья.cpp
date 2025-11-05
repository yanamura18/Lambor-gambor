#include <iostream>
using namespace std;

// Структура узла бинарного дерева
struct TreeNode {
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
    int countLeaves(TreeNode* root) {
        // Базовый случай: пустое дерево
        if (root == nullptr) {
            return 0;
        }
        
        // Если это лист (нет потомков)
        if (root->left == nullptr && root->right == nullptr) {
            return 1;
        }
        
        // Рекурсивно подсчитываем листья в левом и правом поддеревьях
        return countLeaves(root->left) + countLeaves(root->right);
    }
};

// Вспомогательная функция для создания тестового дерева
TreeNode* createTestTree() {
    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
    root->left->left = new TreeNode(4);
    root->left->right = new TreeNode(5);
    root->left->left->left = new TreeNode(6);
    return root;
}

int main() {
    Solution solution;
    TreeNode* root = createTestTree();
    
    int result = solution.countLeaves(root);
    cout << "Количество листьев: " << result << endl; // Вывод: 3
    
    return 0;
}
