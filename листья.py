class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def count_leaves(root):
    """
    Подсчитывает количество листьев в бинарном дереве
    
    Args:
        root: Корень бинарного дерева
        
    Returns:
        int: Количество листьев в дереве
    """
    # Базовый случай: пустое дерево
    if root is None:
        return 0
    
    # Если это лист (нет потомков)
    if root.left is None and root.right is None:
        return 1
    
    # Рекурсивно подсчитываем листья в левом и правом поддеревьях
    return count_leaves(root.left) + count_leaves(root.right)

def create_test_tree():
    """Создает тестовое дерево для демонстрации"""
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root.left.left.left = TreeNode(6)
    return root

# Тестирование
if __name__ == "__main__":
    root = create_test_tree()
    result = count_leaves(root)
    print(f"Количество листьев: {result}")  # Вывод: 3
    
    # Дополнительные примеры
    print("\nДополнительные примеры:")
    
    # Пример 1: Пустое дерево
    print(f"Пустое дерево: {count_leaves(None)}")  # 0
    
    # Пример 2: Только корень
    single_node = TreeNode(1)
    print(f"Один узел: {count_leaves(single_node)}")  # 1
    
    # Пример 3: Сбалансированное дерево
    balanced = TreeNode(1)
    balanced.left = TreeNode(2)
    balanced.right = TreeNode(3)
    print(f"Сбалансированное дерево: {count_leaves(balanced)}")  # 2
